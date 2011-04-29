/**
 * Copyright (c) 2000-2008 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package nl.wur.alterra.cgi.ace.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.*;

import com.google.gson.Gson;
import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.impl.AceItemType;
import nl.wur.alterra.cgi.ace.search.ACESearchEngine;
import nl.wur.alterra.cgi.ace.search.lucene.ACELuceneException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <a href="AdaptationToolJSPPortlet.java.html"><b><i>View Source</i></b></a>
 *
 *
 */
public class AdaptationToolJSPPortlet extends GenericPortlet {
    private static final String AND_CONDITION = "AND";
    private static final String OR_CONDITION = "OR";

    public static final String SEARCH_PARAMS = "searchParams";
    private static final String SEARCH_RESULTS = "searchResults";

    private static final String TOTAL_RESULTS = "total_results";

	public void init() throws PortletException {
		editJSP = getInitParameter("edit-jsp");
		helpJSP = getInitParameter("help-jsp");
		viewJSP = getInitParameter("view-jsp");
	}

	public void doDispatch(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		String jspPage = renderRequest.getParameter("jspPage");

		if (jspPage != null) {
			include(jspPage, renderRequest, renderResponse);
		}
		else {
			super.doDispatch(renderRequest, renderResponse);
		}
	}

	public void doEdit(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		if (renderRequest.getPreferences() == null) {
			super.doEdit(renderRequest, renderResponse);
		}
		else {
			include(editJSP, renderRequest, renderResponse);
		}
	}

	public void doHelp(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		include(helpJSP, renderRequest, renderResponse);
	}

	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {


        try {
            search(renderRequest);
            include(viewJSP, renderRequest, renderResponse);

        } catch (Exception ex)  {
            throw new PortletException(ex.getMessage());
        }
	}

	public void processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {
	}

	protected void include(
			String path, RenderRequest renderRequest,
			RenderResponse renderResponse)
		throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher =
			getPortletContext().getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			_log.error(path + " is not a valid include");
		}
		else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}

    private List<String> search(RenderRequest request)
            throws ACELuceneException {

        String[] anyOfThese = null;
        String[] aceItemTypes = {AceItemType.MEASURE.toString()};
        String[] sectors = null;
        String[] countries = null;
        String[] elements = null;
        String[] sortBys = null;
        String sortBy = null;
        if (sortBys != null && sortBys.length > 0) {
            sortBy = sortBys[0];
        }

        String[] conditionAdaptationSector = {"AND"};
        String[] conditionAdaptationElement = {"AND"};

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

        if (conditionAdaptationSector != null && conditionAdaptationSector[0].equalsIgnoreCase(OR_CONDITION)) {
            aceSearchFormBean.setConditionAdaptationSector(OR_CONDITION);
        } else {
            aceSearchFormBean.setConditionAdaptationSector(AND_CONDITION);
        }


        if (conditionAdaptationElement != null && conditionAdaptationElement[0].equalsIgnoreCase(OR_CONDITION)) {
            aceSearchFormBean.setConditionAdaptationElement(OR_CONDITION);
        } else {
            aceSearchFormBean.setConditionAdaptationElement(AND_CONDITION);
        }

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

                //System.out.println("\n\njson LIST is: " + json);
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
                //System.out.println("\n\njson LIST is: " + json);
                request.setAttribute(aceItemType + "_" + "JSON"
                        + SEARCH_RESULTS, json);
                jsonKeysAdded.add(aceItemType + "_" + "JSON" + SEARCH_RESULTS);
            }
        }

        request.setAttribute(TOTAL_RESULTS, totalResults);

        return keysAdded;
    }


	protected String editJSP;
	protected String helpJSP;
	protected String viewJSP;

	private static Log _log = LogFactory.getLog(nl.wur.alterra.cgi.ace.portlet.AdaptationToolJSPPortlet.class);

}