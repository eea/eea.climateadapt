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
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.logging.Logger;

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
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TermRangeQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

public class ClimateSearchEngine extends IndexSearcher {

	Logger l = Logger.getLogger(getClass().getName());
	IndexSearcher searcher;

	public ClimateSearchEngine(IndexReader r) {
		super(r);
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
		System.out.println("Searching for structures:" + structureId);
		System.out.println("Search Bean :" + formBean.toString(formBean));
		ScoreDoc[] hits = this.getTopDocs(formBean, formBean.getAnyOfThese(),
				aceItemType, structureId).scoreDocs;

		List<AceItemSearchResult> results = new ArrayList<AceItemSearchResult>();

		//
		// calculate factor to normalize relevance scores
		float topScore = 0f;
		for (ScoreDoc hit : hits) {

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
			Document document = searcher.doc(hit.doc);

			// AceItemLocalService aceItemLocalService =
			// AceItemLocalServiceUtil.getService();
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
				long articleId = Long.valueOf(document.getFieldable(Field.UID)
						.stringValue().split("_PORTLET_")[1]);
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
					storageType = "CITYPROFILE";
				} else
					storageType = "ARTICLE";
				aceItemSearchResult.setStoragetype(storageType);
				aceItemSearchResult.setStoredAt(articleUrlTitle);
				aceItemSearchResult.setRating(System.currentTimeMillis());
				aceItemSearchResult.setName(document.get(Field.TITLE));
				String description = nullSafeString(new String[] {
						document.get(Field.CONTENT),
						document.get(Field.DESCRIPTION),
						document.get(Field.NAME) });
				aceItemSearchResult.setShortdescription(description);
				aceItemSearchResult.setFeature("");
				aceItemSearchResult.setControlstatus(Short.valueOf(document
						.getFieldable(Field.STATUS).stringValue()));
				// aceItemSearchResult.setDeeplink("");
				// aceItemSearchResult.setFeature("feature");
				Date publishDate = new SimpleDateFormat("yyyyMMddHHmmSS")
						.parse(document.getFieldable(Field.PUBLISH_DATE)
								.stringValue());
				Calendar publishCal = Calendar.getInstance();
				publishCal.setTime(publishDate);
				aceItemSearchResult.setNew(isNew(publishCal));
				// if (document.getFieldable(Field.PUBLISH_DATE).sgetYear() !=
				// null
				// && aceitem.getYear().length() > 0)
				// {
				aceItemSearchResult.setYear(String.valueOf(publishCal
						.get(Calendar.YEAR)));
				// }
				float relevance = hit.score * normalizeScoreFactor * 100;
				aceItemSearchResult.setRelevance(relevance);
				results.add(aceItemSearchResult);

			}
		}
		return results;
	}

	private String nullSafeString(String[] strings) {
		for (String string : Arrays.asList(strings))
			if (string != null)
				return string;
		return "";
	}

	private boolean isNew(Calendar publishCal) {
		boolean isNew = false;
		Calendar now = Calendar.getInstance();
		publishCal.add(Calendar.MONTH, 3);
		if (publishCal.after(now))
			isNew = true;
		return isNew;
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
		String sectorField = "b_m_sectors";
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
				impact = labels.getString("acesearch-climateimpacts-lbl-"
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
			int fromYear = 1970;
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

		TopDocs searchResults = searcher.search(booleanQuery, 99);
		System.out.println("Search Text: " + searchText);
		System.out.println("Lucene boolean query: " + booleanQuery);
		System.out.println("Search Bean: " + formBean.toString(formBean));

		searcher.close();
		return searchResults;
	}

}
