package nl.wur.alterra.cgi.ace;


import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import nl.wur.alterra.cgi.ace.Constants;
import nl.wur.alterra.cgi.ace.search.ACESearchEngine;
import nl.wur.alterra.cgi.ace.search.ACESearchPortalInterface;
import nl.wur.alterra.cgi.ace.search.AceSearchFormBean;
import nl.wur.alterra.cgi.ace.search.SearchRequestParams;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Portlet implementation class SimpleFilterPortlet
 */
public class SimpleFilterPortlet extends MVCPortlet {

	/*
	 *  param: datainfo_type '2' param: sector 'WATERMANAGEMENT' param: element
	 *  'OBSERVATIONS' param: anyOfThese 'Water' param: countries 'AT' param:
	 *  aceitemtype 'DOCUMENT' param: javax.portlet.action 'searchAceitem'
	 */

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
            ACESearchPortalInterface searchEngine = new ACESearchPortalInterface();

        	String sector[] = new String[1];
        	sector[0] = (String) renderRequest.getAttribute(Constants.USERSECTOR);
        	
        	if (sector[0] == null) {
        		
        		sector[0] = (String) renderRequest.getPortletSession().getAttribute(Constants.USERSECTOR);
        	}
        	
        	if (sector[0] != null) {
              	         		
            	//System.out.println("Sector: " + sector[0]);
            	String impact[] = new String[1];
            	impact[0] = (String) renderRequest.getAttribute(Constants.USERIMPACT);
            	if (impact[0] == null) {
            		
            		impact[0] = (String) renderRequest.getPortletSession().getAttribute(Constants.USERIMPACT);
            	}
            	//System.out.println("Impact: " + impact[0]);
            	       
                Map<String, String[]> requestParams;

                String fuzziness = null;
                String anyOfThese = null;
                String[] aceItemTypes = null; 
                PortletPreferences preferences = renderRequest.getPreferences();
                requestParams = preferences.getMap();

        		fuzziness = preferences.getValue(SearchRequestParams.FUZZINESS, "");
        		anyOfThese = preferences.getValue(SearchRequestParams.ANY, "");
        		aceItemTypes = preferences.getValues(SearchRequestParams.ACEITEM_TYPE, new String[] {} );
        			
                ACESearchEngine se = new ACESearchEngine();
                AceSearchFormBean formBean = se.prepareACESearchFormBean(requestParams, fuzziness);        	
                
                if( (anyOfThese != null) && (anyOfThese.length() > 0 )) {
                	formBean.setAnyOfThese( anyOfThese );
                }        	
                
                if( (aceItemTypes != null) && (aceItemTypes.length > 0 )) {
                	formBean.setAceitemtype( aceItemTypes );
                }  
                
                renderRequest.getPortletSession().setAttribute(Constants.USERSECTOR, sector[0]);
                if( !sector[0].equalsIgnoreCase("all") ) {
                	formBean.setSector( sector );
                }        	
                
                renderRequest.getPortletSession().setAttribute(Constants.USERIMPACT, impact[0]);
                if( !impact[0].equalsIgnoreCase("all") ) {
                	formBean.setImpact( impact );
                }
                
    			searchEngine.handleSearchRequest(renderRequest, formBean);
        	}
        	else {
            
        		searchEngine.handleSearchRequest(renderRequest);
        	}
		}
        catch (Exception x) {
			x.printStackTrace();
            throw new PortletException(x);
		}
		super.doView(renderRequest, renderResponse);
	}

	//override 
    protected void addSuccessMessage(
    // omit all success messages
            ActionRequest actionRequest, ActionResponse actionResponse) {

                return;
    }	


    public void searchAceitem(ActionRequest request, ActionResponse response) throws Exception {
        try {
        		request.setAttribute(Constants.USERSECTOR, ParamUtil.getString(request, "sector-selector"));
    			request.setAttribute(Constants.USERIMPACT, ParamUtil.getString(request, "risk-selector"));

        }
        catch(Exception x) {
            SessionErrors.add(request, "acesearch-execution-failure");
            x.printStackTrace();
            throw x;
        }

		sendRedirect(request, response);
    }
	
	public void setFilterAceItemPref(ActionRequest request, ActionResponse response) throws Exception {
        Map<String, String[]> requestParams = request.getParameterMap();

        if(requestParams == null || requestParams.get(SearchRequestParams.ANY) == null) {
            System.out.println("Search cannot be executed, it seems your portlet container failed to send the search form in this request.");
        }

        String[] datainfo_type = requestParams.get(SearchRequestParams.DATAINFO_TYPE);      
        String[] anyOfThese = requestParams.get(SearchRequestParams.ANY);
        String[] aceItemTypes = requestParams.get(SearchRequestParams.ACEITEM_TYPE);
        String[] sectors = requestParams.get(SearchRequestParams.SECTOR);
        String[] countries = requestParams.get(SearchRequestParams.COUNTRIES);
        String[] elements = requestParams.get(SearchRequestParams.ELEMENT);
        String[] impacts = requestParams.get(SearchRequestParams.IMPACT);
        String[] sortBys = requestParams.get(SearchRequestParams.SORTBY);
        if((sortBys == null) || (sortBys.length==0) || (sortBys[0].length()==0)) {
        	sortBys = new String[] {"RATING"} ; // sort by rating 
        }
		PortletPreferences prefs = request.getPreferences();
		
		prefs.setValue(Constants.FREEPAR, ParamUtil.getString(request, Constants.FREEPAR) );
		prefs.setValue(Constants.NRITEMSPAGE, ParamUtil.getString(request, Constants.NRITEMSPAGE) );
		prefs.setValue(Constants.FUZZINESS, ParamUtil.getString(request, Constants.FUZZINESS) );

		prefs.store();
		prefs.setValues(SearchRequestParams.FREETEXT_MODE, new String[] {"2"} ); // always search all of the words		
		prefs.setValues(SearchRequestParams.DATAINFO_TYPE, datainfo_type);
		prefs.setValues(SearchRequestParams.ANY, anyOfThese);
		prefs.setValues(SearchRequestParams.ACEITEM_TYPE, aceItemTypes);
		prefs.setValues(SearchRequestParams.SECTOR, sectors);
		prefs.setValues(SearchRequestParams.COUNTRIES, countries);
        prefs.setValues(SearchRequestParams.ELEMENT, elements);
        prefs.setValues(SearchRequestParams.IMPACT, impacts);
		prefs.setValues(SearchRequestParams.SORTBY, sortBys);
		
		prefs.store();
	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        ACESearchPortalInterface searchEngine = new ACESearchPortalInterface();
		AceSearchFormBean formBean = searchEngine.prepareACESearchFormBean(renderRequest);
		renderRequest.setAttribute(SearchRequestParams.SEARCH_PARAMS, formBean);
		super.doEdit(renderRequest, renderResponse);
	}

	/**
	 * Executes 'sorting' search requests issued by Ajax calls from search results.
	 * 
	 * @param request request
	 * @param response response
	 * @throws PortletException hmm
	 * @throws IOException hmm
	 */
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException {
        try {
            ACESearchPortalInterface searchEngine = new ACESearchPortalInterface();
            searchEngine.handleAjaxSearchRequest(request, response);
        }
        catch (Exception x) {
            x.printStackTrace();
            throw new PortletException(x);
        }
    }

}