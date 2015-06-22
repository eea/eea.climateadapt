package com.adasa.mayors_adapt.search;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import junit.framework.TestCase;
import nl.wur.alterra.cgi.ace.search.AceItemSearchResult;
import nl.wur.alterra.cgi.ace.search.AceSearchFormBean;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Fieldable;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.TopDocs;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.util.InitUtil;

public class ClimateSearchEngineTest extends TestCase {

	Logger l = Logger.getLogger(getClass().getName());
	static String INDEX_DIRECTORY = "/Climate_liferay/data/lucene/1";
	static ClimateSearchEngine searcher;

	@Override
	protected void setUp() throws Exception {
		searcher = new ClimateSearchEngine(
				ClimateSearchEngine.getIndexReader(INDEX_DIRECTORY));
		List<String> locations = Arrays
				.asList(new String[] { "/AceItem-shared/src/main/resources/META-INF" });
		// InitUtil.initWithSpring();
		super.setUp();
	}

	public void Search() throws IOException, PortalException, SystemException,
			ParseException {
		long structureId = 11254912;
		System.out.println("Start:" + System.currentTimeMillis());
		AceSearchFormBean formBean = new AceSearchFormBean();
		// formBean.setCountries(new String[]{"FR"});
		formBean.setAnyOfThese("estuaries");
		// formBean.setAceitemtype(new String[]{"CITYPROFILE"});
		formBean.setAceitemtype(new String[] { "ARTICLE" });
		TopDocs searchResults = searcher.getTopDocs(formBean,
				formBean.getAnyOfThese(), "ARTICLE", structureId);
		System.out.println("Resultados: " + searchResults.totalHits);
		for (int i = 0; i < searchResults.totalHits; i++) {
			Document docu = searcher.doc(searchResults.scoreDocs[i].doc);
			List<Fieldable> fieldables = docu.getFields();
			StringWriter string = new StringWriter();
			for (Fieldable fieldable : fieldables) {
				string.append(fieldable.name() + ":"
						+ docu.getFieldable(fieldable.name()) + ";");
			}
			System.out
					.println("----------------------------------------------------------------------------");
			System.out.println(i + ") Doc: " + docu.toString());
			System.out.println("title: " + docu.getFieldable("title"));
			System.out.println("title: " + docu.get("title"));
			System.out.println("ENTRY_CLASS_NAME: "
					+ docu.getFieldable(Field.ENTRY_CLASS_NAME));
			System.out.println("CLASS_PK: "
					+ docu.getFieldable(Field.ENTRY_CLASS_PK));
			System.out.println("CLASS_TYPE_ID: "
					+ docu.getFieldable(Field.CLASS_TYPE_ID));
			System.out.println("version: " + docu.getFieldable(Field.VERSION));
			System.out.println("content: " + docu.getFieldable(Field.CONTENT));
			System.out.println("status: " + docu.getFieldable(Field.STATUS));

		}
		searcher.close();

	}

	public void testSearch2() throws IOException, PortalException,
			SystemException, ParseException {
		long structureId = 11254912;
		System.out.println("Start:" + System.currentTimeMillis());
		AceSearchFormBean formBean = new AceSearchFormBean();
		// formBean.setCountries(new String[]{"FR"});
		formBean.setAnyOfThese("paris");
		 formBean.setAceitemtype(new String[]{"CITYPROFILE"});
//		formBean.setAceitemtype(new String[] { "ARTICLE" });
		 List<AceItemSearchResult> searchResults = searcher.searchLuceneByStructure(formBean, formBean.getAceitemtype()[0], structureId);
		searcher.close();

	}
}
