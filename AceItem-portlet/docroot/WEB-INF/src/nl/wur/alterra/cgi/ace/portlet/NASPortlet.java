package nl.wur.alterra.cgi.ace.portlet;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.bridges.mvc.MVCPortlet;
import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.NAS;
import nl.wur.alterra.cgi.ace.model.NASSource;
import nl.wur.alterra.cgi.ace.search.lucene.ACELuceneException;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;
import nl.wur.alterra.cgi.ace.service.NASLocalServiceUtil;
import nl.wur.alterra.cgi.ace.service.NASSourceLocalServiceUtil;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
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
    private static final String NASSOURCE_RESULTS = "nasSourceResults";
    private static final String ACEITEM_RESULTS = "aceItemResults";


    /**
     * Called by the portlet container to indicate to a portlet that the portlet is being placed into service.
     *
     *
     * @throws javax.portlet.PortletException hmm
     */
    public void init() throws PortletException {
        super.init();
    }

    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        try {
            retrieveNAS(renderRequest, renderResponse);
			super.doView(renderRequest, renderResponse);
        }
        catch (Exception x) {
            System.out.println(x.getMessage());
            x.printStackTrace();
            throw new PortletException(x);
        }
    }


    /**
     * Retrieves all NAS records and stores in request, and also retrieves related NASSource and AceItems that
     * Liferay Service Builder failed to create actual relations for.
     *
     * TODO find out how to get service builder to create the relations -- at the very least in Java, if not in DB
     *
     * @param request request request
     * @param response response response
     * @throws Exception hmm
     */
    public void retrieveNAS(PortletRequest request, PortletResponse response) throws Exception {
        try {
            PortletUtils.logParams(request);
            List<NAS> nasList = retrieveNAS();
            List<NASSource> nasSourceList = retrieveNASSource();
            List<AceItem> aceItemList = retrieveAceItems();
            aceItemList = filterAceItems(aceItemList);
            request.setAttribute(NAS_RESULTS, nasList);
            request.setAttribute(NASSOURCE_RESULTS, nasSourceList);
            request.setAttribute(ACEITEM_RESULTS, aceItemList);
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

    private List<NASSource> retrieveNASSource() throws SystemException {
        List<NASSource> results = new ArrayList<NASSource>();
        int nasSourceCount = NASSourceLocalServiceUtil.getNASSourcesCount();
        if(nasSourceCount > 0) {
            results = NASSourceLocalServiceUtil.getNASSources(0, nasSourceCount - 1);
        }
        System.out.println("NASPortlet retrieved # " + results.size() + " NASSources");
        return results;
    }

    private List<AceItem> retrieveAceItems() throws SystemException {
        List<AceItem> results = new ArrayList<AceItem>();
        int aceItemCount = AceItemLocalServiceUtil.getAceItemsCount();
        if(aceItemCount > 0) {
            results = AceItemLocalServiceUtil.getAceItems(0, aceItemCount - 1);
        }
        System.out.println("NASPortlet retrieved # " + results.size() + " AceItems");
        return results;
    }
    private List<AceItem> filterAceItems(List<AceItem> aceItemList) {
        List<AceItem> results = new ArrayList<AceItem>();
        for(AceItem aceItem : aceItemList){
            // must be related to NAS, but not the AceItems representing NASs themselves
            if(aceItem.getNasId() > 0 && !aceItem.getDatatype().equals("NAS")) {
                results.add(aceItem);
            }
        }
        System.out.println("NASPortlet filtered # " + results.size() + " AceItems");
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