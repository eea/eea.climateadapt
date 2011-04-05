package nl.wur.alterra.cgi.ace.portlet;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.bridges.mvc.MVCPortlet;
import nl.wur.alterra.cgi.ace.model.NAS;
import nl.wur.alterra.cgi.ace.search.lucene.ACELuceneException;
import nl.wur.alterra.cgi.ace.service.NASLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Portlet for National Adaptation Strategies.
 *
 * @author heikki doeleman
 */
public class NASPortlet extends MVCPortlet {

    private static final String NAS_RESULTS = "nasResults";


    /**
     * Called by the portlet container to indicate to a portlet that the portlet is being placed into service.
     *
     *
     * @throws javax.portlet.PortletException hmm
     */
    public void init() throws PortletException {
        super.init();
    }

    /**
     * Retrieves all NAS records and stores in request.
     *
     * @param request request request
     * @param response response response
     * @throws Exception hmm
     */
    public void retrieveNAS(ActionRequest request, ActionResponse response) throws Exception {
        try {
            PortletUtils.logParams(request);
            List<NAS> nasList = retrieveNAS();
            request.setAttribute(NAS_RESULTS, nasList);
            //PortalUtil.copyRequestParameters(request, response);
            //SessionMessages.add(request, "acesearch-execution-success");
        }
        catch(Exception x) {
            //SessionErrors.add(request, "acesearch-execution-failure");
            x.printStackTrace();
            throw x;
        }
    }

    /**
     * Retrieves all NAS records.
     *
     * @return List of NAS, which is empty if none were retrieved
     * @throws ACELuceneException hmm
     */
    private List<NAS> retrieveNAS() throws SystemException {
        List<NAS> results = new ArrayList<NAS>();
        int nasCount = NASLocalServiceUtil.getNASsCount();
        if(nasCount > 0) {
            results = NASLocalServiceUtil.getNASs(0, nasCount - 1);
        }
        System.out.println("NASPortlet retrieved # " + results.size() + " NAS");
        return results;
    }

    /**
     * Implement in case Ajax requests are issued to this portlet.
     *
     * @param request request
     * @param response response
     * @throws javax.portlet.PortletException hmm
     * @throws java.io.IOException hmm
     */
    @Override
	public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException {}

    @Override
    public void destroy() {
        System.out.println("destroying NASPortlet");
        super.destroy();
    }

}