package nl.wur.alterra.cgi.ace.search;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Comparator;

import javax.portlet.ClientDataRequest;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.lucene.search.IndexSearcher;

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.constants.AceItemType;
import nl.wur.alterra.cgi.ace.search.lucene.ACELuceneException;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;

import com.adasa.mayors_adapt.search.ClimateSearchEngine;
import com.google.gson.Gson;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.search.lucene.LuceneHelperUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;

/**
 * Provides access to search engine methods, for portlets. This class is the
 * only class in the SearchEngine library that has dependencies on
 * javax.portlet.* classes.
 *
 * @author heikki doeleman
 *	@author John Konstas - https://taskman.eionet.europa.eu/issues/70188
 */
public class ACESearchPortalInterface {
	private static Log _log = LogFactoryUtil
			.getLog(ACESearchPortalInterface.class);

	private boolean isEmpty(String[] array) {
		return array == null || array.length == 0;
	}
	
	/**
	 * The method that performs the final sorting on Measure items based on sortBy param
	 * @param results
	 * @param sortBy
	 * @return
	 */
	private List<AceItemSearchResult> getOrderedMeasureItems(List<AceItemSearchResult> results, String sortBy) {
		if (sortBy.equals("NAME")) {
			Collections.sort(results, new Comparator<AceItemSearchResult>() {
				@Override
				public int compare(final AceItemSearchResult result1, final AceItemSearchResult result2) {
					return result1.getName().compareTo(result2.getName());
				}
			});
			return results;
		} else if (sortBy.equals("YEAR")) {
			Collections.sort(results, new Comparator<AceItemSearchResult>() {
				@Override public int compare(AceItemSearchResult result1, AceItemSearchResult result2) {
					int year1 = (result1.getName() == null || result1.getYear().isEmpty()) ? 0 : Integer.parseInt(result1.getYear());
					int year2 = (result2.getName() == null || result2.getYear().isEmpty()) ? 0 : Integer.parseInt(result2.getYear());
					return year2 - year1; //Descending
				}
			});
			return results;
		} else {
			return results;
		}
		
	}
	
	/**
	 * The method that returns unique Ace Items based on their storedAt values after filtering process
	 * @param results
	 * @return
	 */
	private List<AceItemSearchResult> getUniqueMeasureItems(List<AceItemSearchResult> results) {
		SortedSet<AceItemSearchResult> uniqueResults = new TreeSet<AceItemSearchResult>(new Comparator<AceItemSearchResult>() {
			@Override
			public int compare(AceItemSearchResult arg0, AceItemSearchResult arg1) {
				return arg0.getStoredAt().compareTo(arg1.getStoredAt());
			}
		});
 		Iterator<AceItemSearchResult> iterator = results.iterator();
 		
 		while (iterator.hasNext()) {
 			uniqueResults.add(iterator.next());
 		}
 		
 		return new ArrayList<AceItemSearchResult>(uniqueResults);
	}
	
	/**
	 * This is the root method that gets the filtered items, gets rid of duplicates and sorts the items by sortBy,
	 * if this is not null
	 * @param results
	 * @param sortBy
	 * @return
	 */
	private List<AceItemSearchResult> getOrderedUniqueFilteredMeasureItems(List<AceItemSearchResult> results, String sortBy) {
		List <AceItemSearchResult> finalResults = new ArrayList<AceItemSearchResult>();
		
		if (results != null && results.size() > 0) {
			if (sortBy == null) {
				finalResults = getUniqueMeasureItems(getFilteredMeasureItems(results));
			} else {
				finalResults = getOrderedMeasureItems(getUniqueMeasureItems(getFilteredMeasureItems(results)), sortBy);
			}
		} else {
			finalResults = new ArrayList<AceItemSearchResult>();
		}
		
		return finalResults;
	}
	
	/**
	 * This method is used in order to return a list of Measure Items
	 *  according to issue https://taskman.eionet.europa.eu/issues/70188
	 * @param results
	 * @return
	 */
	private List<AceItemSearchResult> getFilteredMeasureItems(List<AceItemSearchResult> results) {
		
			System.out.println("list size:"+results.size());
			for (AceItemSearchResult result : results) {
				String storedAtBasic = "ace_measure_id=";
				String storedAt = result.getStoredAt();
				String measureId = storedAt.substring(storedAt.indexOf('=') + 1);
				long filteredMeasureId = AceSearchMeasureUtil.filterAdaptationOptionIds(Long.parseLong(measureId));
				
				if (filteredMeasureId != Long.parseLong(measureId)) {
					String filteredStoredAt = storedAtBasic+Long.toString(filteredMeasureId);
					
					AceItem aceItem = null;
					
					try {
						aceItem = AceItemLocalServiceUtil.getAceItemByStoredAt(filteredStoredAt);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					if (aceItem != null) { //the filtering is meaningless if there is no such AceItem in DB
						result.setStoredAt(filteredStoredAt);
						result.setName(aceItem.getName());
						result.setYear(aceItem.getYear());
						result.setShortdescription(aceItem.getDescription());
					}
					
				}
				
			}
		
		return results;
	}
	
	
	/**
	 *
	 * @param request
	 *            request
	 * @return keys to lists of results grouped by aceitemtype
	 * @throws ACELuceneException
	 *             hmm
	 */
	public List<String> handleSearchRequest(PortletRequest request,
			AceSearchFormBean formBean) throws Exception {
		
		long groupId = ParamUtil.getLong(request, "groupId");
		String structureName = "City Profile";
		String structureDescription = "Structure for a City Profile";
		List<DDMStructure> structures = DDMStructureLocalServiceUtil
				.getStructures();
		long structureId = 0;
		for (DDMStructure structure : structures) {
			if (structure.getName(LocaleUtil.getDefault()).equalsIgnoreCase(
					structureName))
				structureId = structure.getStructureId();
		}
		if (structureId == 0)
			_log.error("Structure with name:" + structureName
					+ ", description:" + structureDescription + " and group:"
					+ groupId + " -> Not found");

		List<String> keysAdded = new ArrayList<String>();
		List<String> jsonKeysAdded = new ArrayList<String>();
		long totalResults = 0;

		ACESearchEngine searchEngine = new ACESearchEngine();

		ClimateSearchEngine climateSearchEngine = new ClimateSearchEngine(
				ClimateSearchEngine.getIndexReader(null), request);

		// no aceItemTypes requested or "All" choosen: search for all of them
		if (isEmpty(formBean.getAceitemtype())
				|| (formBean.getDatainfo_type().equals("1") && formBean
						.getSortBy() == null)) {
			for (AceItemType aceItemType : AceItemType.values()) {
				List<AceItemSearchResult> results = null;

				if (aceItemType.name().equals("CITYPROFILE")
						|| aceItemType.name().equals("ARTICLE"))
					results = climateSearchEngine.searchLuceneByStructure(
							formBean, aceItemType.name(), structureId);
				else
					results = searchEngine.searchLuceneByType(formBean,
							aceItemType.name());
				
				//Call method to replace some measure items with new ones - https://taskman.eionet.europa.eu/issues/70188
				if (aceItemType.name().equals("MEASURE")) {
					results = getOrderedUniqueFilteredMeasureItems(results, formBean.getSortBy());
				}
				
				
				totalResults += results.size();

				// System.out.println("From all searchAceitem found #" +
				// results.size() + " results of type " + aceItemType.name());
				request.setAttribute(aceItemType.name() + "_"
						+ SearchRequestParams.SEARCH_RESULTS, results);

				keysAdded.add(aceItemType.name() + "_"
						+ SearchRequestParams.SEARCH_RESULTS);
				Gson gson = new Gson();
				String json = gson.toJson(results);

				request.setAttribute(aceItemType.name() + "_" + "JSON"
						+ SearchRequestParams.SEARCH_RESULTS, json);
				jsonKeysAdded.add(aceItemType.name() + "_" + "JSON"
						+ SearchRequestParams.SEARCH_RESULTS);
			}
		}
		// search only requested aceItemTypes
		else {
			for (String aceItemType : formBean.getAceitemtype()) {
				List<AceItemSearchResult> results = null;
				System.out.println("Searching for selected type: "
						+ aceItemType);

				if (aceItemType.equals("CITYPROFILE")
						|| aceItemType.equals("ARTICLE"))
					results = climateSearchEngine.searchLuceneByStructure(
							formBean, aceItemType, structureId);
				else
					results = searchEngine.searchLuceneByType(formBean,
							aceItemType);
				
				//Call method to replace some measure items with new ones - https://taskman.eionet.europa.eu/issues/70188
				if (aceItemType.equals("MEASURE")) {
					results = getOrderedUniqueFilteredMeasureItems(results, formBean.getSortBy());
				}
				
				totalResults += results.size();

				// System.out.println("Limited set seacrhAceitem found #" +
				// results.size() + " results of type " + aceItemType);
				request.setAttribute(aceItemType + "_"
						+ SearchRequestParams.SEARCH_RESULTS, results);
				keysAdded.add(aceItemType + "_"
						+ SearchRequestParams.SEARCH_RESULTS);
				Gson gson = new Gson();
				String json = gson.toJson(results);

				request.setAttribute(aceItemType + "_" + "JSON"
						+ SearchRequestParams.SEARCH_RESULTS, json);
				jsonKeysAdded.add(aceItemType + "_" + "JSON"
						+ SearchRequestParams.SEARCH_RESULTS);
			}
		}

		request.setAttribute(SearchRequestParams.TOTAL_RESULTS, totalResults);

		return keysAdded;
	}

	public List<String> handleSearchRequest(PortletRequest request) throws Exception {

		AceSearchFormBean formBean = prepareACESearchFormBean(request);
		request.setAttribute(SearchRequestParams.SEARCH_PARAMS, formBean);
		return handleSearchRequest(request, formBean);
	}

	/**
	 * Executes 'sorting' search requests issued by Ajax calls from search
	 * results.
	 *
	 * @param request
	 *            request
	 * @param response
	 *            response
	 * @throws nl.wur.alterra.cgi.ace.search.lucene.ACELuceneException
	 *             hmm
	 */
	public void handleAjaxSearchRequest(ResourceRequest request,
			ResourceResponse response) throws Exception {
		// System.out.println("handleAjaxSearchRequest start");
		// PortletUtils.logParams(request);
		List<String> resultKeys = handleSearchRequest(request);
		List<AceItemSearchResult> results = (List<AceItemSearchResult>) request
				.getAttribute(resultKeys.get(0));

		Gson gson = new Gson();
		String json = gson.toJson(results);
		response.setContentType("text/html");
		// the page that was calling...
		String resourceID = request.getResourceID();
		// System.out.println("resourceId was : " + resourceID);
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
		} catch (IOException x) {
			x.printStackTrace();
			throw new ACELuceneException(x);
		}
		writer.print(json);
	}

	/**
	 * Prepares ACESearchFormBean from search parameter values in the request.
	 *
	 * @param request
	 * @return formbean
	 */
	public AceSearchFormBean prepareACESearchFormBean(PortletRequest request) {
		Map<String, String[]> requestParams;
		String fuzziness = null;

		//
		// TODO: do this by checking actual pagename rather than request type ?
		//

		// request from search portlet
		if (request instanceof ClientDataRequest) {
			requestParams = request.getParameterMap();

			// Retrieve fuzziness from preferences
			PortletPreferences preferences = request.getPreferences();

			fuzziness = preferences.getValue(SearchRequestParams.FUZZINESS, "");
		}
		// request from adaptationtooljsp portlet or filteraceitemportlet
		else { // if(request instanceof RenderRequest) {
			PortletPreferences preferences = request.getPreferences();
			requestParams = preferences.getMap();

			fuzziness = preferences.getValue(SearchRequestParams.FUZZINESS, "");

		}
		ACESearchEngine searchEngine = new ACESearchEngine();
		return searchEngine.prepareACESearchFormBean(requestParams, fuzziness);
	}
}
