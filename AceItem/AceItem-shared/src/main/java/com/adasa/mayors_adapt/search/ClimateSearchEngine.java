package com.adasa.mayors_adapt.search;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
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

public class ClimateSearchEngine extends IndexSearcher {

	Logger l = Logger.getLogger(getClass().getName());
	IndexSearcher searcher;

	public ClimateSearchEngine(IndexReader r) {
		super(r);
		searcher = new IndexSearcher(r);
	}

	static public IndexReader getIndexReader(String INDEX_DIRECTORY)
			throws IOException {
//		Directory directory = FSDirectory.open(new File(INDEX_DIRECTORY));
		Directory directory = FSDirectory.open(new File(ACEIndexUtil.retrieveWebcontentIndexFolder()));
		IndexReader indexReader = IndexReader.open(directory, false);
		return indexReader;
	}

	public TopDocs getTopDocs(AceSearchFormBean formBean,
			String searchText, long structureId) throws IOException, PortalException,
			SystemException, ParseException {

		BooleanQuery booleanQuery = new BooleanQuery();
		BooleanQuery textQuery = new BooleanQuery();
		if (searchText!=null && searchText.length() > 0) {
			searchText = searchText.toLowerCase();
			textQuery.add(new TermQuery(new Term(Field.TITLE, searchText)),
					BooleanClause.Occur.SHOULD);
			textQuery.add(
					new TermQuery(new Term(Field.CONTENT, searchText)),
					BooleanClause.Occur.SHOULD);
		}
		booleanQuery.add(textQuery, BooleanClause.Occur.MUST);

		booleanQuery.add(
				new TermQuery(new Term(Field.STATUS, Integer
						.toString(WorkflowConstants.STATUS_APPROVED))),
				BooleanClause.Occur.MUST);
		booleanQuery.add(new TermQuery(new Term("head", "true")),
				BooleanClause.Occur.MUST);

		

        //
        // everything must be a JournalArticle
        //
		booleanQuery.add(new TermQuery(new Term(Field.ENTRY_CLASS_NAME,
				com.liferay.portlet.journal.model.JournalArticle.class.getName())), BooleanClause.Occur.MUST);

        //
        // handle city profile ItemType
        //
		BooleanQuery typesQuery = new BooleanQuery();
		String[] types = formBean.getAceitemtype();
		if ((types != null) && (types.length > 0)) {
			for (String type : types) {
				if (type.equalsIgnoreCase("CITYPROFILE"))
					booleanQuery.add(new TermQuery(new Term(Field.CLASS_TYPE_ID,
							String.valueOf(structureId))), BooleanClause.Occur.MUST);
					}
		}

		
        //
        // handle sectors
        //
		BooleanQuery sectorsQuery = new BooleanQuery();
		String sectorField = "Select12195";
		String[] sectors = formBean.getSector();
		if ((sectors != null) && (sectors.length > 0)) {
			for (String sector : sectors) {
				sectorsQuery.add(new TermQuery(new Term("ddm/" + structureId
						+ "/"+sectorField+"_en_GB", sector)),
						BooleanClause.Occur.SHOULD);
			}
			booleanQuery.add(sectorsQuery, BooleanClause.Occur.MUST);
		}

        //
        // handle elements
        //
		BooleanQuery elementsQuery = new BooleanQuery();
		String elementField = "Element";
		String[] elements = formBean.getElement();
		if ((elements != null) && (elements.length > 0)) {
			for (String element : elements) {
				elementsQuery.add(new TermQuery(new Term("ddm/" + structureId
						+ "/"+elementField+"_en_GB", element)),
						BooleanClause.Occur.SHOULD);
			}
			booleanQuery.add(elementsQuery, BooleanClause.Occur.MUST);
		}

        //
        // handle scenarios
        //
		BooleanQuery scenariosQuery = new BooleanQuery();
		String scenarioField = "Scenario";
		String[] scenarios = formBean.getScenario();
		if ((scenarios != null) && (scenarios.length > 0)) {
			for (String scenario : scenarios) {
				scenariosQuery.add(new TermQuery(new Term("ddm/" + structureId
						+ "/"+scenarioField+"_en_GB", scenario)),
						BooleanClause.Occur.SHOULD);
			}
			booleanQuery.add(scenariosQuery, BooleanClause.Occur.MUST);
		}


        //
        // handle impacts
        //
		BooleanQuery impactsQuery = new BooleanQuery();
		String impactField = "Climate_Impact";
		String[] impacts = formBean.getImpact();
		if ((impacts != null) && (impacts.length > 0)) {
			for (String impact : impacts) {
				impactsQuery.add(new TermQuery(new Term("ddm/" + structureId
						+ "/"+impactField+"_en_GB", impact)),
						BooleanClause.Occur.SHOULD);
			}
			booleanQuery.add(impactsQuery, BooleanClause.Occur.MUST);
		}

  
        // adding year
        //rawQuery += " AND year:2013" ;

        Query yearQuery = null;
        if (formBean.getStartyear() != null && formBean.getEndyear() != null)
        {
        	int fromYear=1970;
        	int toYear=Calendar.getInstance().get(Calendar.YEAR);
            try {
                  fromYear = Integer.parseInt(formBean.getStartyear()[0]);
            } catch(NumberFormatException e) {
            }
            try {
                  toYear = Integer.parseInt(formBean.getEndyear()[0]);
            } catch(NumberFormatException e) {
            }
            String yearField = "displayDate";
 			booleanQuery.add(new TermRangeQuery(yearField, String.valueOf(fromYear)+"0101000000",String.valueOf(toYear)+"3112235900", true,true),
					BooleanClause.Occur.MUST);
        }

        if ( formBean.getFeaturedItem() != null && !formBean.getFeaturedItem().equals("") ) {
//        	System.out.println("Filter by feature");
        	String featuredField = "featuredField";
        	booleanQuery.add(new TermQuery(new Term("ddm/" + structureId
					+ "/"+featuredField+"_en_GB", "true")),
					BooleanClause.Occur.SHOULD);
        }

		//
		// handle countries
		//
		BooleanQuery countriesQuery = new BooleanQuery();
		String[] countries = formBean.getCountries();
		if ((countries != null) && (countries.length > 0)) {
			for (String country : countries) {
				countriesQuery.add(new TermQuery(new Term("ddm/" + structureId
						+ "/Country_en_GB", country)),
						BooleanClause.Occur.SHOULD);
			}
			booleanQuery.add(countriesQuery, BooleanClause.Occur.MUST);
		}

		TopDocs searchResults = searcher.search(booleanQuery, 99);
		System.out.println("Lucene boolean query: " + booleanQuery);
		System.out.println("Search Text: " + searchText);

		searcher.close();
		return searchResults;
	}

	public List<AceItemSearchResult> searchLuceneByStructure(
			AceSearchFormBean formBean, String aceItemType, long structureId) throws IOException,
			PortalException, SystemException, ParseException {
		System.out.println("Searching for structures:"+structureId);
		ScoreDoc[] hits = this.getTopDocs(formBean,
				formBean.getAnyOfThese(), structureId).scoreDocs;

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
				AceItemSearchResult aceItemSearchResult = new AceItemSearchResult();
				System.out.println("Document: " + document.toString());
				aceItemSearchResult.setName(document.getFieldable("title")
						.stringValue());
				// aceItemSearchResult.setAceItemId(Long.valueOf(document
				// .getFieldable("uid").stringValue()));
				aceItemSearchResult.setAceItemId(Long.valueOf(document
						.getFieldable("articleId").stringValue()));
				aceItemSearchResult.setStoredAt("cityprofile_id="
						+ document.getFieldable("articleId").stringValue());
				aceItemSearchResult.setStoragetype("CITYPROFILE");
				aceItemSearchResult.setRating(System.currentTimeMillis());
				aceItemSearchResult.setShortdescription(document.getFieldable(
						"title").stringValue());
				aceItemSearchResult.setControlstatus(Short.valueOf(document
						.getFieldable("status").stringValue()));
				// aceItemSearchResult.setDeeplink("");
				// aceItemSearchResult.setFeature("feature");
				aceItemSearchResult.setNew(true);
				// if (document.get(Field.CREATE_DATE).aceitem.getYear() != null
				// && aceitem.getYear().length() > 0)
				// {
				aceItemSearchResult.setYear("2015");
				// }
				float relevance = hit.score * normalizeScoreFactor * 100;
				aceItemSearchResult.setRelevance(relevance);
				results.add(aceItemSearchResult);

			}
		}
		return results;
	}

}
