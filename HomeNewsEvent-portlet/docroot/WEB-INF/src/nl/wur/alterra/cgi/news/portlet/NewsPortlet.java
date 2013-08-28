package nl.wur.alterra.cgi.news.portlet;

import java.io.IOException;
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
			
			System.out.println("inside Ace News portlet");
			long companyId = PortalUtil.getCompanyId(renderRequest);
			long groupId = DAOParamUtil.getLong(renderRequest, "groupId");
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			groupId = themeDisplay.getScopeGroupId();
			String articleId = null;
			Double version = null;
			String title = null;
			String description = null;
			String content = null;
			String type = "News";
			String[] structureIds = {"ACENEWS"};
			String[] templateIds = {"ACE-NEWS-TEMPLATE"};

			
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
			int end = ParamUtil.getInteger(renderRequest, "delta", 5);
			if (showParam != null && showParam.equalsIgnoreCase("full"))
			{
			   start = -1;
			   end = -1;
			   displayDateLT = null;
			}
			
			OrderByComparator obc = new ArticleModifiedDateComparator(false);
			
			List<JournalArticle> journalArticlesList = JournalArticleLocalServiceUtil.search(
				companyId, groupId, articleId, version, title, description, content,
				type, structureIds, templateIds, displayDateGT, displayDateLT,
				status, reviewDate, andOperator, start, end, obc);
			
			// we need to sort in descending based on the display date
			JournalComparator journalComparator = new JournalComparator(1);
			Collections.sort(journalArticlesList, journalComparator);
			
			List urlList = new ArrayList();
			List journalList = new ArrayList();
			
			for (JournalArticle article : journalArticlesList)
			{
				System.out.println("article title is " + article.getTitle());
				System.out.println("article id is " + article.getArticleId());
				System.out.println("article type is " + article.getType());
				System.out.println("article description is " + article.getDescription());
				System.out.println("article display date is " + article.getDisplayDate());
				System.out.println("article version is " + article.getVersion());
				
				
				String name = "url"; // The name of the custom field
				String value = ""; // The value of the custom field: remember that this will always be a java.lang.String
				//System.out.println("article locale is  " + article.getDefaultLocale());
				
				// since there is no api support for the custom field we are trying to do the other way
				Document document = SAXReaderUtil.read(article.getContentByLocale(article.getDefaultLocale()));
				Node node = document.selectSingleNode("/root/dynamic-element[@name='" + name + "']/dynamic-content");
				//System.out.println("xml is " + node.asXML());
				value = node.getText();
				System.out.println("url is " + value);
				
				// show only the latest version
				if(JournalArticleLocalServiceUtil.isLatestVersion(groupId,article.getArticleId(),article.getVersion())){
					journalList.add(article);
					urlList.add(value);
				}
			}
		
			renderRequest.setAttribute("newsList", journalList);
			renderRequest.setAttribute("urlList", urlList);
			if (showParam != null && showParam.equalsIgnoreCase("full"))
			{
				renderRequest.setAttribute("showall", "full");
			}
			
		}
        catch (Exception x) {
			x.printStackTrace();
            throw new PortletException(x);
		}

		super.doView(renderRequest, renderResponse);
	}
	
	

}
