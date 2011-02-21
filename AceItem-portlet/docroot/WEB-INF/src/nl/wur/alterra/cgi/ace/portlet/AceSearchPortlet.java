package nl.wur.alterra.cgi.ace.portlet;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 *
 * Search AceItems.
 */
public class AceSearchPortlet extends MVCPortlet {

    public void searchAceitem(ActionRequest request, ActionResponse response) throws Exception {
        try {

            System.out.println("YES !!");
            System.out.println("YES !!");
            System.out.println("YES !!");
            System.out.println("YES !!");
            System.out.println("YES !!");
            System.out.println("YES !!");
            System.out.println("YES !!");

            SessionMessages.add(request, "acesearch-execution-success");
        }
        catch(Exception x) {
            SessionErrors.add(request, "acesearch-execution-failure");
            throw x;
        }
    }

}
