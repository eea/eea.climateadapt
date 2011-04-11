package nl.wur.alterra.cgi.ace.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ClientDataRequest;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.impl.AceItemType;
import nl.wur.alterra.cgi.ace.search.ACESearchEngine;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexSearcher;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexSynchronizer;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexWriter;
import nl.wur.alterra.cgi.ace.search.lucene.ACELuceneException;

import com.google.gson.Gson;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class FilterAceItemPortlet
 */
public class FilterAceItemPortlet extends MVCPortlet {

	/*
	 * *
	 * param: datainfo_type '2' param: sector 'WATERMANAGEMENT' param: element
	 * 'OBSERVATIONS' param: anyOfThese 'Water' param: countries 'AT' param:
	 * aceitemtype 'DOCUMENT' param: javax.portlet.action 'searchAceitem'
	 */
	private static final String ANY = "anyOfThese";
	private static final String INITIAL_DATE = "initial_date";
	private static final String FINAL_DATE = "final_date";
	private static final String SIMPLE_DATE = "simple_date";
	private static final String ACEITEM_TYPE = "aceitemtype";
	private static final String SORTBY = "sortBy";
	private static final String SECTOR = "sector";
	private static final String COUNTRIES = "countries";
	private static final String ELEMENT = "element";

	public static final String SEARCH_PARAMS = "searchParams";
	private static final String SEARCH_RESULTS = "searchResults";

	private static final String TOTAL_RESULTS = "total_results";

	/**
	 * Called by the portlet container to indicate to a portlet that the portlet
	 * is being placed into service.
	 * 
	 * Rebuilds the Lucene index.
	 * 
	 * @throws PortletException
	 *             hmm
	 */
	public void init() throws PortletException {
		super.init();
		ACEIndexSynchronizer aceIndexSynchronizer = new ACEIndexSynchronizer();
		aceIndexSynchronizer.synchronize();
	}

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		try {
			searchByPreferences(renderRequest);
		} catch (ACELuceneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		super.doView(renderRequest, renderResponse);
	}

	public void setFilterAceItemPref(ActionRequest request, ActionResponse response)
			throws Exception {
        Map<String, String[]> requestParams = request.getParameterMap();

        if(requestParams == null || requestParams.get(ANY) == null) {
            System.out.println("Search cannot be executed, it seems your portlet container failed to send the search form in this request.");
        }
        
        String[] anyOfThese = requestParams.get(ANY);
        String[] aceItemTypes = requestParams.get(ACEITEM_TYPE);
        String[] sectors = requestParams.get(SECTOR);
        String[] countries = requestParams.get(COUNTRIES);
        String[] elements = requestParams.get(ELEMENT);
        String[] sortBys = requestParams.get(SORTBY);
        
		PortletPreferences prefs = request.getPreferences();

		prefs.setValues(ANY, anyOfThese);
		prefs.setValues(ACEITEM_TYPE, aceItemTypes);
		prefs.setValues(SECTOR, sectors);
		prefs.setValues(COUNTRIES, countries);
		prefs.setValues(ELEMENT, elements);
		prefs.setValues(SORTBY, sortBys);
		
		prefs.store();
	}

	@Override
	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		PortletPreferences preferences = renderRequest.getPreferences();

		String[] anyOfThese = preferences.getValues(ANY, null);
		String[] aceItemTypes = preferences.getValues(ACEITEM_TYPE, null);
		String[] sectors = preferences.getValues(SECTOR, null);
		String[] countries = preferences.getValues(COUNTRIES, null);
		String[] elements = preferences.getValues(ELEMENT, null);
		String[] sortBys = preferences.getValues(SORTBY, null);
		String sortBy = null;
		if (sortBys != null && sortBys.length > 0) {
			sortBy = sortBys[0];
		}

		AceSearchFormBean aceSearchFormBean = new AceSearchFormBean();
		if (anyOfThese != null && anyOfThese.length > 0) {
			aceSearchFormBean.setAnyOfThese(anyOfThese[0]);
		} else {
			aceSearchFormBean.setAnyOfThese("");
		}
		aceSearchFormBean.setAceitemtype(aceItemTypes);
		aceSearchFormBean.setSector(sectors);
		aceSearchFormBean.setElement(elements);
		aceSearchFormBean.setCountries(countries);
		aceSearchFormBean.setSortBy(sortBy);

		renderRequest.setAttribute(SEARCH_PARAMS, aceSearchFormBean);
		
		super.doEdit(renderRequest, renderResponse);
	}

	private List<String> searchByPreferences(PortletRequest request)
			throws ACELuceneException {
		PortletPreferences preferences = request.getPreferences();

		String[] anyOfThese = preferences.getValues(ANY, null);
		String[] aceItemTypes = preferences.getValues(ACEITEM_TYPE, null);
		String[] sectors = preferences.getValues(SECTOR, null);
		String[] countries = preferences.getValues(COUNTRIES, null);
		String[] elements = preferences.getValues(ELEMENT, null);
		String[] sortBys = request.getParameterMap().get(SORTBY);
		String sortBy = null;
		if (sortBys != null && sortBys.length > 0) {
			sortBy = sortBys[0];
		}

		AceSearchFormBean aceSearchFormBean = new AceSearchFormBean();
		if (anyOfThese != null && anyOfThese.length > 0) {
			aceSearchFormBean.setAnyOfThese(anyOfThese[0]);
		} else {
			aceSearchFormBean.setAnyOfThese("");
		}
		aceSearchFormBean.setAceitemtype(aceItemTypes);
		aceSearchFormBean.setSector(sectors);
		aceSearchFormBean.setElement(elements);
		aceSearchFormBean.setCountries(countries);
		aceSearchFormBean.setSortBy(sortBy);

		request.setAttribute(SEARCH_PARAMS, aceSearchFormBean);

		ACESearchEngine aceSearchEngine = new ACESearchEngine();

		List<String> keysAdded = new ArrayList<String>();
		List<String> jsonKeysAdded = new ArrayList<String>();

		long totalResults = 0;

		// no aceItemTypes requested: search for all of them
		if (aceItemTypes == null || aceItemTypes.length == 0) {
			for (AceItemType aceItemType : AceItemType.values()) {
				List<AceItem> results = aceSearchEngine.searchLuceneByType(
						aceSearchFormBean, aceItemType.name());
				totalResults += results.size();

				System.out.println("searchAceitem found #" + results.size()
						+ " results of type " + aceItemType.name());
				request.setAttribute(aceItemType.name() + "_" + SEARCH_RESULTS,
						results);

				for (AceItem result : results) {
					result.setDescription(result.getDescription().replaceAll(
							"'", "\'"));
					result.setKeyword(result.getKeyword().replaceAll("'", "\'"));
					result.setName(result.getName().replaceAll("'", "\'"));
					result.setSpatialValues(result.getSpatialValues()
							.replaceAll("'", "\'"));
					result.setSpatialLayer(result.getSpatialLayer().replaceAll(
							"'", "\'"));
					result.setElements_(result.getElements_().replaceAll("'",
							"\'"));
					result.setSectors_(result.getSectors_().replaceAll("'",
							"\'"));
					result.setStoredAt(result.getStoredAt().replaceAll("'",
							"\'"));
					result.setTextSearch(result.getTextSearch().replaceAll("'",
							"\'"));
					result.setDatatype(result.getDatatype().replaceAll("'",
							"\'"));

					result.setDescription(result.getDescription().replaceAll(
							"\"", "\"\""));
					result.setKeyword(result.getKeyword().replaceAll("\"",
							"\"\""));
					result.setName(result.getName().replaceAll("\"", "\"\""));
					result.setSpatialValues(result.getSpatialValues()
							.replaceAll("\"", "\"\""));
					result.setSpatialLayer(result.getSpatialLayer().replaceAll(
							"\"", "\"\""));
					result.setElements_(result.getElements_().replaceAll("\"",
							"\"\""));
					result.setSectors_(result.getSectors_().replaceAll("\"",
							"\"\""));
					result.setStoredAt(result.getStoredAt().replaceAll("\"",
							"\"\""));
					result.setStoragetype(result.getStoragetype().replaceAll(
							"\"", "\"\""));
					result.setTextSearch(result.getTextSearch().replaceAll(
							"\"", "\"\""));
					result.setDatatype(result.getDatatype().replaceAll("\"",
							"\"\""));
				}

				keysAdded.add(aceItemType.name() + "_" + SEARCH_RESULTS);
				Gson gson = new Gson();
				String json = gson.toJson(results);

				// escape double quotes

				System.out.println("\n\njson LIST is: " + json);
				request.setAttribute(aceItemType.name() + "_" + "JSON"
						+ SEARCH_RESULTS, json);
				jsonKeysAdded.add(aceItemType.name() + "_" + "JSON"
						+ SEARCH_RESULTS);
			}
		}
		// search only requested aceItemTypes
		else {
			for (String aceItemType : aceItemTypes) {
				List<AceItem> results = aceSearchEngine.searchLuceneByType(
						aceSearchFormBean, aceItemType);
				totalResults += results.size();

				System.out.println("searchAceitem found #" + results.size()
						+ " results of type " + aceItemType);
				request.setAttribute(aceItemType + "_" + SEARCH_RESULTS,
						results);
				keysAdded.add(aceItemType + "_" + SEARCH_RESULTS);
				Gson gson = new Gson();
				String json = gson.toJson(results);
				System.out.println("\n\njson LIST is: " + json);
				request.setAttribute(aceItemType + "_" + "JSON"
						+ SEARCH_RESULTS, json);
				jsonKeysAdded.add(aceItemType + "_" + "JSON" + SEARCH_RESULTS);
			}
		}

		request.setAttribute(TOTAL_RESULTS, totalResults);

		return keysAdded;
	}

	/**
	 * Executes 'sorting' search requests issued by Ajax calls from search
	 * results.
	 * 
	 * @param request
	 *            request
	 * @param response
	 *            response
	 * @throws PortletException
	 *             hmm
	 * @throws IOException
	 *             hmm
	 */
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response)
			throws PortletException, IOException {
		try {
			System.out.println("In serveResource code");
			PortletUtils.logParams(request);
			List<String> resultKeys = searchByPreferences(request);
			List<AceItem> results = (List<AceItem>) request
					.getAttribute(resultKeys.get(0));
			Gson gson = new Gson();
			String json = gson.toJson(results);
			System.out.println("\n\njson LIST is: " + json);
			response.setContentType("text/html");
			// the page that was calling...
			String resourceID = request.getResourceID();
			System.out.println("resourceId was : " + resourceID);
			PrintWriter writer = response.getWriter();
			writer.print(json);
		} catch (ACELuceneException x) {
			throw new PortletException(x.getMessage(), x);
		}
	}

	@Override
	public void destroy() {
		try {
			System.out.println("destroying FilterAceItemsPortlet");
			ACEIndexWriter.getACEIndexWriter().close();
			ACEIndexSearcher.getACEIndexSearcher().close();
		} catch (ACELuceneException x) {
			System.out.println(x.getMessage());
			x.printStackTrace();
		}
		super.destroy();
	}
}
