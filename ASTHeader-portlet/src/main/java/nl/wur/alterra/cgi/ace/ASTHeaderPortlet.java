package nl.wur.alterra.cgi.ace;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ASTHeaderPortlet
 */
public class ASTHeaderPortlet extends MVCPortlet {
    /**
     * Sets the preferences for image and headertext info
     *
     */
    public void setASTHeaderPref(ActionRequest request, ActionResponse response)
        throws Exception {

        String step = ParamUtil.getString(request, "step");

        String headertext = ParamUtil.getString(request, "headertext");

        PortletPreferences prefs = request.getPreferences();

        prefs.setValue("step", step);

        prefs.setValue("headertext", headertext);

        prefs.store();
    }

}
