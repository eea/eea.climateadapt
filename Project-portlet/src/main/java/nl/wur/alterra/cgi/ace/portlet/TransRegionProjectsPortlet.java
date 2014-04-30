package nl.wur.alterra.cgi.ace.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import nl.wur.alterra.cgi.ace.model.Project;
import nl.wur.alterra.cgi.ace.model.constants.AceItemType;
import nl.wur.alterra.cgi.ace.search.ACESearchEngine;
import nl.wur.alterra.cgi.ace.search.ACESearchPortalInterface;
import nl.wur.alterra.cgi.ace.search.AceItemSearchResult;
import nl.wur.alterra.cgi.ace.search.AceSearchFormBean;
import nl.wur.alterra.cgi.ace.service.ProjectLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 *
 * @author jaanus
 *
 */
public class TransRegionProjectsPortlet extends MVCPortlet {

    /** */
    public static final String REGION_PROJECTS = "REGION_PROJECTS";
    public static final String REGION_ORGANISATIONS = "REGION_ORGANISATIONS";

    /**
     * @see com.liferay.util.bridges.mvc.MVCPortlet#doView(javax.portlet.RenderRequest,
     *      javax.portlet.RenderResponse)
     */
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

        // HttpServletRequest httpRequest =
        // PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest))
        // ;

        try {
            loadRegionProjects(renderRequest);
            loadRegionOrganisations(renderRequest);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PortletException(e);
        }

        super.doView(renderRequest, renderResponse);
    }

    /**
     *
     * @param renderRequest
     * @throws SystemException
     */
    private void loadRegionProjects(RenderRequest renderRequest) throws SystemException {

        String currentUrl = PortalUtil.getCurrentURL(renderRequest);
        java.util.List<Project> regionProjects = new java.util.ArrayList<Project>();

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        List<Project> projects = ProjectLocalServiceUtil.getProjectsByGroupId(themeDisplay.getScopeGroupId());
        for (Project project : projects) {
            System.out.println(project.getSpatiallayer());
            if (ProjectUtil.spatialLayerMatchesTransRegionUrl(project.getSpatiallayer(), currentUrl)) {
                regionProjects.add(project);
            }
        }

        Collections.sort(regionProjects, new Comparator<Project>() {
            public int compare(Project prj0, Project prj1) {
                return prj0.getTitle().compareToIgnoreCase(prj1.getTitle());
            }
        });

        renderRequest.setAttribute(REGION_PROJECTS, regionProjects);
    }

    /**
     *
     * @param renderRequest
     * @throws Exception
     */
    private void loadRegionOrganisations(RenderRequest renderRequest) throws Exception {

        String currentUrl = PortalUtil.getCurrentURL(renderRequest);
        AceSearchFormBean formBean = new AceSearchFormBean();
        formBean.setAnyOfThese("");

        ACESearchEngine aceSearchEngine = new ACESearchEngine();
        List<AceItemSearchResult> allOrganisations = aceSearchEngine.searchLuceneByType(formBean,
                AceItemType.ORGANISATION.toString());

        List<AceItemSearchResult> regionOrganisations = new ArrayList<AceItemSearchResult>();
        for (AceItemSearchResult item : allOrganisations) {

            String spatialLayer = item.getSpatialLayer();
            if (ProjectUtil.spatialLayerMatchesTransRegionUrl(spatialLayer, currentUrl)) {
                regionOrganisations.add(item);
            }
        }

        Collections.sort(regionOrganisations, new Comparator<AceItemSearchResult>() {
            public int compare(AceItemSearchResult item0, AceItemSearchResult item1) {
                return item0.getName().compareToIgnoreCase(item1.getName());
            }
        });

        renderRequest.setAttribute(REGION_ORGANISATIONS, regionOrganisations);
    }
}
