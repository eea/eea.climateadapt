package nl.wur.alterra.cgi.news.portlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import nl.wur.alterra.cgi.util.JournalComparator;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.util.comparator.ArticleModifiedDateComparator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class NewsPortlet
 */
public class NewsPortlet extends MVCPortlet {

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        try {
            long companyId = PortalUtil.getCompanyId(renderRequest);
            long groupId = DAOParamUtil.getLong(renderRequest, "groupId");
            ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
            groupId = themeDisplay.getScopeGroupId();
            String articleId = null;
            Double version = null;
            String title = null;
            String description = null;
            String content = null;
            String type = "news";
            String[] structureIds = {"ACENEWS"};
            String[] templateIds = {"ACE-NEWS-TEMPLATE"};
            long classNameId = 0;
            List<Long> folderIds = new ArrayList<Long>();
            folderIds.add( 0L );


            HttpServletRequest httpRequest =
                    PortalUtil.getOriginalServletRequest(
                    PortalUtil.getHttpServletRequest(renderRequest) ) ;

            String showParam = httpRequest.getParameter("show");

            Date displayDateGT = null;
            Date displayDateLT = new Date();

            int status = WorkflowConstants.STATUS_APPROVED;
            Date reviewDate = null;
            boolean andOperator = true;
            int start = 0;
            int end = ParamUtil.getInteger(renderRequest, "delta", 3);
            if (showParam != null && showParam.equalsIgnoreCase("full"))
            {
               start = -1;
               end = -1;
               displayDateLT = null;
            }

            OrderByComparator obc = new ArticleModifiedDateComparator(false);

/**
            List<JournalArticle> journalArticlesList = JournalArticleLocalServiceUtil.search(
                companyId, groupId, articleId, version, title, description, content,
                type, structureIds, templateIds, displayDateGT, displayDateLT,
                status, reviewDate, andOperator, start, end, obc);
**/
            List<JournalArticle> journalArticlesListRo = JournalArticleLocalServiceUtil.search(companyId, groupId, folderIds,  classNameId, articleId, version, title, description, content, type, structureIds, templateIds, displayDateGT, displayDateLT, status, reviewDate,  andOperator,  start,  end,  obc);
            List<JournalArticle> journalArticlesList = new ArrayList<JournalArticle>(journalArticlesListRo);

            // we need to sort in descending based on the display date
            JournalComparator journalComparator = new JournalComparator(1);
            Collections.sort(journalArticlesList, journalComparator);

            List urlList = new ArrayList();
            List journalList = new ArrayList();
            List titleList = new ArrayList();

            for (JournalArticle article : journalArticlesList)
            {
                // The name and values of the custom fields
                // The value of the custom field: remember that this will always be a java.lang.String
                String name = "url";
                String value = "";
                String titleName = "title";
                String titleValue = "";


                // since there is no api support for the custom field we are trying to do the other way
                // getting url
                Document document = SAXReaderUtil.read(article.getContentByLocale(article.getDefaultLocale()));
                Node node = document.selectSingleNode("/root/dynamic-element[@name='" + name + "']/dynamic-content");
                value = node.getText();

                //getting title
                node = document.selectSingleNode("/root/dynamic-element[@name='" + titleName + "']/dynamic-content");
                titleValue = node.getText();

                // show only the latest version
                if(JournalArticleLocalServiceUtil.isLatestVersion(groupId,article.getArticleId(),article.getVersion())){
                    journalList.add(article);
                    urlList.add(value);
                    titleList.add(titleValue);
                }
            }

            renderRequest.setAttribute("newsList", journalList);
            renderRequest.setAttribute("urlList", urlList);
            renderRequest.setAttribute("titleList", titleList);

            if (showParam != null && showParam.equalsIgnoreCase("full"))
            {
                renderRequest.setAttribute("showall", "full");
            }

        } catch (Exception x) {
            x.printStackTrace();
            throw new PortletException(x);
        }

        super.doView(renderRequest, renderResponse);
    }

}
