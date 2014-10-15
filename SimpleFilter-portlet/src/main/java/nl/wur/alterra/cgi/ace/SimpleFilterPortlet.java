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
            PortletPreferences preferences = renderRequest.getPreferences();
            
            String sector[] = new String[1];
            sector[0] = (String) renderRequest.getAttribute(Constants.USERSECTOR);

            if (sector[0] == null) {
                sector[0] = (String) renderRequest.getPortletSession().getAttribute(Constants.USERSECTOR);
                if ( sector[0] == null ) {
                	sector[0] = preferences.getValue(Constants.USERDEFAULTSECTOR, "all");
                }
            }

            String impact[] = new String[1];
            impact[0] = (String) renderRequest.getAttribute(Constants.USERIMPACT);
            if (impact[0] == null) {
                impact[0] = (String) renderRequest.getPortletSession().getAttribute(Constants.USERIMPACT);
                if ( impact[0] == null ) {
                	impact[0] = preferences.getValue(Constants.USERDEFAULTIMPACT, "all");
                }
            }

            String scenario[] = new String[1];
            scenario[0] = (String) renderRequest.getAttribute(Constants.USERSCENARIO);
            if (scenario[0] == null) {

                scenario[0] = (String) renderRequest.getPortletSession().getAttribute(Constants.USERSCENARIO);
                if ( scenario[0] == null ) {
                	scenario[0] = preferences.getValue(Constants.USERDEFAULTSCENARIO, "all");
                }
            }

            String timeperiod[] = new String[1];
            timeperiod[0] = (String) renderRequest.getAttribute(Constants.USERTIMEPERIOD);
            if (timeperiod[0] == null) {

                timeperiod[0] = (String) renderRequest.getPortletSession().getAttribute(Constants.USERTIMEPERIOD);
                if ( timeperiod[0] == null ) {
                	timeperiod[0] = preferences.getValue(Constants.USERDEFAULTPERIOD, "all");
                }
            }

            Map<String, String[]> requestParams;

            String fuzziness = null;
            String anyOfThese = null;
            String[] aceItemTypes = null;
            String isFeaturedItem = null;

            requestParams = preferences.getMap();

            fuzziness = preferences.getValue(SearchRequestParams.FUZZINESS, "");
            anyOfThese = preferences.getValue(SearchRequestParams.ANY, "");
            aceItemTypes = preferences.getValues(SearchRequestParams.ACEITEM_TYPE, new String[] {} );
            isFeaturedItem = preferences.getValue(Constants.USERISFEATUREDITEM, "");
            
            int nrOfCheckboxes = Integer.parseInt( preferences.getValue(Constants.NRCHECKBOXES, "2") );

            ACESearchEngine se = new ACESearchEngine();
            AceSearchFormBean formBean = se.prepareACESearchFormBean(requestParams, fuzziness);

            if( (anyOfThese != null) && (anyOfThese.length() > 0 )) {
                formBean.setAnyOfThese( anyOfThese );
            }

            if( (aceItemTypes != null) && (aceItemTypes.length > 0 )) {
                formBean.setAceitemtype( aceItemTypes );
            }
            if ( isFeaturedItem != null && isFeaturedItem.length() > 0 ) {
            	formBean.setFeaturedItem(isFeaturedItem);
            }
                
            
            renderRequest.getPortletSession().setAttribute(Constants.USERSECTOR, sector[0]);
            if( !sector[0].equalsIgnoreCase("all") ) {
                formBean.setSector( sector );
            }

            renderRequest.getPortletSession().setAttribute(Constants.USERIMPACT, impact[0]);
            if( !impact[0].equalsIgnoreCase("all") ) {
                formBean.setImpact( impact );
            }
            
            if(nrOfCheckboxes == 4) {
                renderRequest.getPortletSession().setAttribute(Constants.USERSCENARIO, scenario[0]);
                if( (scenario[0] != null && scenario[0].length() > 0) &&  !scenario[0].equalsIgnoreCase("all") ) {
                    formBean.setScenario( scenario );
                }

                renderRequest.getPortletSession().setAttribute(Constants.USERTIMEPERIOD, timeperiod[0]);
                if( timeperiod[0] != null && (timeperiod[0].length() > 0) &&  !timeperiod[0].equalsIgnoreCase("all") ) {
                    formBean.setTimePeriod( timeperiod );
                }
            }

            searchEngine.handleSearchRequest(renderRequest, formBean);
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
            request.setAttribute(Constants.USERSCENARIO, ParamUtil.getString(request, "scenario-selector"));
            request.setAttribute(Constants.USERTIMEPERIOD, ParamUtil.getString(request, "timeperiod-selector"));
        } catch(Exception x) {
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
/*        String[] sectors = requestParams.get(SearchRequestParams.SECTOR);
        String[] countries = requestParams.get(SearchRequestParams.COUNTRIES);
        String[] elements = requestParams.get(SearchRequestParams.ELEMENT);
        String[] impacts = requestParams.get(SearchRequestParams.IMPACT);
        String[] scenarios = requestParams.get(SearchRequestParams.SCENARIO);
        String[] timeperiods = requestParams.get(SearchRequestParams.TIMEPERIOD);
*/        String[] sortBys = requestParams.get(SearchRequestParams.SORTBY);
        if((sortBys == null) || (sortBys.length==0) || (sortBys[0].length()==0)) {
            sortBys = new String[] {"RATING"} ; // sort by rating
        }

        PortletPreferences prefs = request.getPreferences();
        
        prefs.setValue(Constants.FREEPAR, ParamUtil.getString(request, Constants.FREEPAR) );
        prefs.setValue(Constants.NRITEMSPAGE, ParamUtil.getString(request, Constants.NRITEMSPAGE) );
        prefs.setValue(Constants.FUZZINESS, ParamUtil.getString(request, Constants.FUZZINESS) );
        prefs.setValue(Constants.NRCHECKBOXES, ParamUtil.getString(request, Constants.NRCHECKBOXES) );
        prefs.setValue(Constants.USERDEFAULTIMPACT, ParamUtil.getString(request, Constants.USERDEFAULTIMPACT));
        prefs.setValue(Constants.USERDEFAULTSECTOR, ParamUtil.getString(request, Constants.USERDEFAULTSECTOR));
        prefs.setValue(Constants.USERDEFAULTSCENARIO, ParamUtil.getString(request, Constants.USERDEFAULTSCENARIO));
        prefs.setValue(Constants.USERDEFAULTPERIOD, ParamUtil.getString(request, Constants.USERDEFAULTPERIOD));
        prefs.setValue(Constants.USERISFEATUREDITEM, ParamUtil.getString(request, Constants.USERISFEATUREDITEM));
        
        prefs.store();
        prefs.setValues(SearchRequestParams.FREETEXT_MODE, new String[] {"2"} ); // always search all of the words
        prefs.setValues(SearchRequestParams.DATAINFO_TYPE, datainfo_type);
        prefs.setValues(SearchRequestParams.ANY, anyOfThese);
        prefs.setValues(SearchRequestParams.ACEITEM_TYPE, aceItemTypes);
/*      prefs.setValues(SearchRequestParams.SECTOR, sectors);
        prefs.setValues(SearchRequestParams.COUNTRIES, countries);
        prefs.setValues(SearchRequestParams.ELEMENT, elements);
        prefs.setValues(SearchRequestParams.IMPACT, impacts);
        prefs.setValues(SearchRequestParams.SCENARIO, scenarios);
        prefs.setValues(SearchRequestParams.TIMEPERIOD, timeperiods);
*/      prefs.setValues(SearchRequestParams.SORTBY, sortBys);

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
        } catch (Exception x) {
            x.printStackTrace();
            throw new PortletException(x);
        }
    }

}
