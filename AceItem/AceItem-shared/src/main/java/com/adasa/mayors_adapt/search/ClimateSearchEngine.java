package com.adasa.mayors_adapt.search;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.search.AceItemSearchResult;
import nl.wur.alterra.cgi.ace.search.AceSearchFormBean;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexConstant;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexUtil;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TermRangeQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.google.gson.Gson;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.AssetRendererFactory;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

public class ClimateSearchEngine extends IndexSearcher {

	Logger l = Logger.getLogger(getClass().getName());
	IndexSearcher searcher;
	LiferayPortletRequest request;
	LiferayPortletResponse response;

	public ClimateSearchEngine(IndexReader r, PortletRequest request) {
		super(r);
		this.request = (LiferayPortletRequest) request;
		this.response = (LiferayPortletResponse) response;
		searcher = new IndexSearcher(r);
	}

	static public IndexReader getIndexReader(String INDEX_DIRECTORY)
			throws IOException {
		// Directory directory = FSDirectory.open(new File(INDEX_DIRECTORY));
		Directory directory = FSDirectory.open(new File(ACEIndexUtil
				.retrieveWebcontentIndexFolder()));
		IndexReader indexReader = IndexReader.open(directory, false);
		return indexReader;
	}

	public List<AceItemSearchResult> searchLuceneByStructure(
			AceSearchFormBean formBean, String aceItemType, long structureId)
			throws IOException, PortalException, SystemException,
			ParseException, java.text.ParseException {
		System.out
				.println("-------------------------------------------------------------");
		System.out.println("Searching for structure:" + structureId);
		System.out.println("AceItem type: " + aceItemType);
		// formBean.setAceitemtype(null);
		ScoreDoc[] hits = this.getTopDocs(formBean, formBean.getAnyOfThese(),
				aceItemType, structureId).scoreDocs;
		List<AceItemSearchResult> results = new ArrayList<AceItemSearchResult>();

		//
		// calculate factor to normalize relevance scores
		float topScore = 0f;
		for (ScoreDoc hit : hits) {
//			System.out.println("Doc Name: " + searcher.doc(hit.doc).toString());

			float score = hit.score;
			// System.out.println("score: " + score);
			if (score != Float.NaN) {
				if (score > topScore) {
					topScore = score;
				}
			}
		}
		// System.out.println("topscore is: " + topScore);
		if (topScore == Float.NaN || !(topScore > 0f)) {
			topScore = 1f;
		}
		float normalizeScoreFactor = 1 / topScore;
		// System.out.println("normalizeScoreFactor is: " +
		// normalizeScoreFactor);

		for (ScoreDoc hit : hits) {

			// AceItemLocalService aceItemLocalService =
			// AceItemLocalServiceUtil.getService();
			try {
				Document document = searcher.doc(hit.doc);
				AceItem aceItem;

				String aceItemId = document
						.get(ACEIndexConstant.IndexField.ACEITEM_ID);

				if (aceItemId != null) {

					aceItem = AceItemLocalServiceUtil.getAceItem(Long
							.parseLong(aceItemId));
					aceItem.setAceItemId(Long.parseLong(aceItemId));

					// relevance expressed as a percentage
					float relevance = hit.score * normalizeScoreFactor * 100;

					// System.out.println("hit.score is: " + hit.score);
					// System.out.println("relevance (0.0) is: " + relevance);

					AceItemSearchResult aceItemSearchResult = new AceItemSearchResult(
							aceItem);
					aceItemSearchResult.setRelevance(relevance);
					// System.out.println("AceItemSearchResult name is " +
					// aceItemSearchResult.getName());
					// System.out.println("AceItemSearchResult isNew is " +
					// aceItemSearchResult.isIsNew());
					// System.out.println("AceItemSearchResult feature is " +
					// aceItemSearchResult.getFeature());
					results.add(aceItemSearchResult);
				} else {
					long articleId = Long.valueOf(document
							.getFieldable(Field.UID).stringValue()
							.split("_PORTLET_")[1]);
					JournalArticle article = JournalArticleLocalServiceUtil
							.getArticle(articleId);
					String articleUrlTitle = article.getUrlTitle();
					AceItemSearchResult aceItemSearchResult = new AceItemSearchResult();
					// aceItemSearchResult.setAceItemId(Long.valueOf(document
					// .getFieldable("uid").stringValue()));
					aceItemSearchResult.setAceItemId(articleId);
					String classTypeId = document.get(Field.CLASS_TYPE_ID);
					String storageType = null;
					if (classTypeId != null
							&& Long.valueOf(classTypeId) == structureId) {
						{
							storageType = "CITYPROFILE";
							aceItemSearchResult.setStoredAt(articleUrlTitle);
						}
					} else {
						storageType = "ARTICLE";
						// aceItemSearchResult.setStoredAt(getStoredAt(articleId));
//						aceItemSearchResult.setStoredAt(+articleUrlTitle);
						aceItemSearchResult.setStoredAt(articleUrlTitle);
					}
					aceItemSearchResult.setStoragetype(storageType);
					aceItemSearchResult.setRating(0L);
					aceItemSearchResult.setDeeplink("");
					aceItemSearchResult.setName(document.get(Field.TITLE));
					String description = nullSafeString(new String[] {
							document.get(Field.CONTENT),
							document.get(Field.DESCRIPTION),
							document.get(Field.NAME) });
					aceItemSearchResult.setShortdescription(description);
					aceItemSearchResult.setFeature("");
					aceItemSearchResult.setControlstatus((short) 1);
					// aceItemSearchResult.setControlstatus(Short.valueOf(document
					// .getFieldable(Field.STATUS).stringValue()));
					// aceItemSearchResult.setDeeplink("");
					// aceItemSearchResult.setFeature("feature");
					Date approvalDate = new SimpleDateFormat("yyyyMMddHHmmSS")
							.parse(document.getFieldable(Field.PUBLISH_DATE)
									.stringValue());
					Date createdDate = new SimpleDateFormat("yyyyMMddHHmmSS")
							.parse(document.getFieldable(Field.CREATE_DATE)
									.stringValue());
					Calendar createCal = Calendar.getInstance();
					createCal.setTime(createdDate);
					aceItemSearchResult.setNew(aceItemSearchResult.isNew(
							approvalDate, createdDate));
					// if (document.getFieldable(Field.PUBLISH_DATE).sgetYear()
					// !=
					// null
					// && aceitem.getYear().length() > 0)
					// {
					aceItemSearchResult.setYear(String.valueOf(createCal
							.get(Calendar.YEAR)));
					// }
					float relevance = hit.score * normalizeScoreFactor * 100;
					aceItemSearchResult.setRelevance(relevance);
					results.add(aceItemSearchResult);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		Gson gson = new Gson();
//		String json = gson.toJson(results);
//		System.out.println(json);
		return results;
	}

	private String getStoredAt(long articleId) {
		AssetEntry assetEntry;
		String viewUrl = "";
		try {
			JournalArticle article = JournalArticleLocalServiceUtil
					.getArticle(articleId);
			assetEntry = AssetRendererFactoryRegistryUtil
					.getAssetRendererFactoryByClassName(
							JournalArticle.class.getName()).getAssetEntry(
							JournalArticle.class.getName(),
							article.getResourcePrimKey());
			viewUrl = getAssetViewURL(request, response, assetEntry);
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return viewUrl;
	}

	public String getAssetViewURL(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse, AssetEntry assetEntry) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long plid = 0;
		try {
			plid = PortalUtil.getPlidFromPortletId(
					themeDisplay.getScopeGroupId(), "101");
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// LiferayPortletURL viewURL = PortletURLFactoryUtil.create(
		// request.getHttpServletRequest(), "101", plid,
		// PortletRequest.RENDER_PHASE);
		// PortletURL viewURL = liferayPortletResponse.createRenderURL(101);
		PortletURL viewURL = null;
		try {
			viewURL = assetEntry.getAssetRenderer().getURLView(response,
					WindowState.NORMAL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		viewURL.setParameter("struts_action", "/asset_publisher/view_content");

		String currentURL = PortalUtil.getCurrentURL(liferayPortletRequest);

		// viewURL.setParameter("redirect", currentURL);

		viewURL.setParameter("assetEntryId",
				String.valueOf(assetEntry.getEntryId()));

		AssetRendererFactory assetRendererFactory = assetEntry
				.getAssetRendererFactory();

		AssetRenderer assetRenderer = assetEntry.getAssetRenderer();

		viewURL.setParameter("type", assetRendererFactory.getType());

		if (Validator.isNotNull(assetRenderer.getUrlTitle())) {
			viewURL.setParameter("urlTitle", assetRenderer.getUrlTitle());
		}

		return viewURL.toString();
	}

	private String nullSafeString(String[] strings) {
		for (String string : Arrays.asList(strings))
			if (string != null)
				return string;
		return "";
	}

	public TopDocs getTopDocs(AceSearchFormBean formBean, String searchText,
			String aceItemType, long structureId) throws IOException,
			PortalException, SystemException, ParseException {
		ResourceBundle labels = ResourceBundle.getBundle("content.Language",
				Locale.ENGLISH);
		BooleanQuery booleanQuery = new BooleanQuery();
		BooleanQuery textQuery = new BooleanQuery();
		if (searchText != null && searchText.length() > 0) {
			searchText = searchText.toLowerCase();
			textQuery.add(new TermQuery(new Term(Field.TITLE, searchText)),
					BooleanClause.Occur.SHOULD);
			textQuery.add(new TermQuery(new Term(Field.CONTENT, searchText)),
					BooleanClause.Occur.SHOULD);
			booleanQuery.add(textQuery, BooleanClause.Occur.MUST);
		}

		booleanQuery.add(
				new TermQuery(new Term(Field.STATUS, Integer
						.toString(WorkflowConstants.STATUS_APPROVED))),
				BooleanClause.Occur.MUST);
		booleanQuery.add(new TermQuery(new Term("head", "true")),
				BooleanClause.Occur.MUST);

		//
		// everything is a JournalArticle
		//
		booleanQuery.add(
				new TermQuery(new Term(Field.ENTRY_CLASS_NAME,
						com.liferay.portlet.journal.model.JournalArticle.class
								.getName())), BooleanClause.Occur.MUST);

		//
		// handle city profile ItemType
		//
		BooleanQuery typesQuery = new BooleanQuery();
		String[] types = formBean.getAceitemtype();
		boolean city = false, article = false;
		// if ((types != null) && (types.length > 0)) {
		// for (String type : types) {
		// System.out.println("Type: " + type);
		// if (type.equalsIgnoreCase("CITYPROFILE")){
		// city=true;
		// typesQuery.add(new TermQuery(new Term(Field.CLASS_TYPE_ID,
		// String.valueOf(structureId))),
		// BooleanClause.Occur.MUST_NOT);
		// }
		// if (type.equalsIgnoreCase("ARTICLE")){
		// article = true;
		// typesQuery.add(new TermQuery(new Term(Field.CLASS_TYPE_ID,
		// String.valueOf(structureId))),
		// BooleanClause.Occur.MUST);
		// }
		// }
		// if (city && article){}
		// else if (city )
		// booleanQuery.add(new TermQuery(new Term(Field.CLASS_TYPE_ID,
		// String.valueOf(structureId))),
		// BooleanClause.Occur.MUST);
		// else if (article)
		// booleanQuery.add(new TermQuery(new Term(Field.CLASS_TYPE_ID,
		// String.valueOf(structureId))),
		// BooleanClause.Occur.MUST_NOT);
		//
		// } else {
		if (aceItemType.equals("CITYPROFILE")) {
			booleanQuery.add(
					new TermQuery(new Term(Field.CLASS_TYPE_ID, String
							.valueOf(structureId))), BooleanClause.Occur.MUST);
		}
		if (aceItemType.equals("ARTICLE")) {
			booleanQuery.add(
					new TermQuery(new Term(Field.CLASS_TYPE_ID, String
							.valueOf(structureId))),
					BooleanClause.Occur.MUST_NOT);
		}
		// }
		//
		// handle sectors
		//
		BooleanQuery sectorsQuery = new BooleanQuery();
		String sectorField = "b_m_sector";
		String[] sectors = formBean.getSector();
		if ((sectors != null) && (sectors.length > 0)) {
			for (String sector : sectors) {
				sector = labels.getString("acesearch-sectors-lbl-" + sector);
				sectorsQuery.add(new TermQuery(new Term("ddm/" + structureId
						+ "/" + sectorField + "_en_GB", sector)),
						BooleanClause.Occur.SHOULD);
			}
			booleanQuery.add(sectorsQuery, BooleanClause.Occur.MUST);
		}

		//
		// handle elements
		//
		BooleanQuery elementsQuery = new BooleanQuery();
		String elementField = "h_m_elements";
		String[] elements = formBean.getElement();
		if ((elements != null) && (elements.length > 0)) {
			for (String element : elements) {
				element = labels.getString("acesearch-elements-lbl-" + element);
				elementsQuery.add(new TermQuery(new Term("ddm/" + structureId
						+ "/" + elementField + "_en_GB", element)),
						BooleanClause.Occur.SHOULD);
			}
			booleanQuery.add(elementsQuery, BooleanClause.Occur.MUST);
		}

		//
		// handle scenarios
		//
		// BooleanQuery scenariosQuery = new BooleanQuery();
		// String scenarioField = "Scenario";
		// String[] scenarios = formBean.getScenario();
		// if ((scenarios != null) && (scenarios.length > 0)) {
		// for (String scenario : scenarios) {
		// scenariosQuery.add(new TermQuery(new Term("ddm/" + structureId
		// + "/" + scenarioField + "_en_GB", scenario)),
		// BooleanClause.Occur.SHOULD);
		// }
		// booleanQuery.add(scenariosQuery, BooleanClause.Occur.MUST);
		// }

		//
		// handle impacts
		//
		BooleanQuery impactsQuery = new BooleanQuery();
		String impactField = "b_m_climate_impacts";
		String[] impacts = formBean.getImpact();
		if ((impacts != null) && (impacts.length > 0)) {
			for (String impact : impacts) {
				impact = labels.getString("aceitem-climateimpacts-lbl-"
						+ impact);
				impactsQuery.add(new TermQuery(new Term("ddm/" + structureId
						+ "/" + impactField + "_en_GB", impact)),
						BooleanClause.Occur.SHOULD);
			}
			booleanQuery.add(impactsQuery, BooleanClause.Occur.MUST);
		}

		// adding year
		// rawQuery += " AND year:2013" ;

		Query yearQuery = null;
		if (formBean.getStartyear() != null && formBean.getEndyear() != null) {
			int fromYear = 0;
			int toYear = Calendar.getInstance().get(Calendar.YEAR);
			try {
				fromYear = Integer.parseInt(formBean.getStartyear()[0]);
			} catch (NumberFormatException e) {
			}
			try {
				toYear = Integer.parseInt(formBean.getEndyear()[0]);
			} catch (NumberFormatException e) {
			}
			String yearField = "displayDate";
			if (fromYear > 0 && toYear > 0)
				booleanQuery.add(
						new TermRangeQuery(yearField, String.valueOf(fromYear)
								+ "0101000000", String.valueOf(toYear)
								+ "3112235900", true, true),
						BooleanClause.Occur.MUST);
		}

		//
		// handle featured
		//
		// if (formBean.getFeaturedItem() != null
		// && !formBean.getFeaturedItem().equals("")) {
		// // System.out.println("Filter by feature");
		// String featuredField = "featuredField";
		// booleanQuery.add(new TermQuery(new Term("ddm/" + structureId + "/"
		// + featuredField + "_en_GB", "true")),
		// BooleanClause.Occur.SHOULD);
		// }

		//
		// handle countries
		//
		BooleanQuery countriesQuery = new BooleanQuery();
		String[] countries = formBean.getCountries();
		if ((countries != null) && (countries.length > 0)) {
			String countryField = "a_m_country";
			for (String country : countries) {
				country = labels.getString("acesearch-country-lbl-" + country);
				countriesQuery.add(new TermQuery(new Term("ddm/" + structureId
						+ "/" + countryField + "_en_GB", country)),
						BooleanClause.Occur.SHOULD);
			}
			booleanQuery.add(countriesQuery, BooleanClause.Occur.MUST);
		}

		TopDocs searchResults;

		// = searcher.search(booleanQuery, 99);

		System.out.println("sort by is " + formBean.getSortBy());
		SortField sortField = null; 
		if (formBean.getSortBy()!= null && formBean.getSortBy().equals("NAME")) {
			sortField = new SortField("title", Locale.UK);
		} else if (formBean.getSortBy()!= null && formBean.getSortBy().equals("YEAR")) {
			sortField = new SortField("createDate", Locale.UK, true);
		}

		System.out.println("Search Text: " + searchText);
		System.out.println("Lucene boolean query: " + booleanQuery);
		System.out.println("Search Bean: " + formBean.toString(formBean));

		if (sortField != null) {
			Sort sort = new Sort(sortField);
			searchResults = searcher.search(booleanQuery, 999, sort);
		} else
			searchResults = searcher.search(booleanQuery, 999);

		System.out.println("Results Number: " + searchResults.totalHits);
//		System.out.println("First doc:"
//				+ searcher.doc(searchResults.scoreDocs[0].doc).toString());
		searcher.close();
		return searchResults;
	}

}
