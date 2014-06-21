package nl.wur.alterra.cgi.ace.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class SimpleSearchPortlet
 */
public class SimpleSearchPortlet extends MVCPortlet {

    /**
     * Stores the name for the input box
     *
     * @param request request
     * @param response response
     */
    public void setSimpleSearchPref(ActionRequest request, ActionResponse response) throws Exception {
        PortletPreferences prefs = request.getPreferences();

        prefs.setValue(Constants.searchBoxPreferenceName, ParamUtil.getString(request, Constants.searchBoxPreferenceName) );

        prefs.store();
    }

}
