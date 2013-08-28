package nl.wur.alterra.cgi.events.portlet;

import java.io.IOException;
import java.text.DateFormat;
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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
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
 * Portlet implementation class EventPortlet
 */
public class EventPortlet extends MVCPortlet {


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
			String type = "Events";
			String[] structureIds = {"ACEEVENT"};
			String[] templateIds = {"ACE-EVENT-TEMPLATE"};

			
			HttpServletRequest httpRequest = 
		    		PortalUtil.getOriginalServletRequest(
		    		PortalUtil.getHttpServletRequest(renderRequest) ) ;
			
			String showParam = httpRequest.getParameter("show");
			
			Date displayDateGT = new Date();
			Date displayDateLT = null;

			int status = WorkflowConstants.STATUS_APPROVED;
			Date reviewDate = null;
			boolean andOperator = true;
			int start = 0;
			int end = ParamUtil.getInteger(renderRequest, "delta", 5);
			
			if (showParam != null && showParam.equalsIgnoreCase("full"))
			{
			   start = -1;
			   end = -1;
			   displayDateGT = null;
			}
			
			OrderByComparator obc = new ArticleModifiedDateComparator(false);
			
			List<JournalArticle> journalArticlesList = JournalArticleLocalServiceUtil.search(
				companyId, groupId, articleId, version, title, description, content,
				type, structureIds, templateIds, displayDateGT, displayDateLT,
				status, reviewDate, andOperator, start, end, obc);
			
			// we need to sort in ascending based on the display date
			JournalComparator journalComparator = new JournalComparator(0);
			Collections.sort(journalArticlesList, journalComparator);
						
			
			List urlList = new ArrayList();
			List journalList = new ArrayList();
			List yearList = new ArrayList();
			List monthList = new ArrayList();
			List dayList = new ArrayList();
			List locationList = new ArrayList();
			
			for (JournalArticle article : journalArticlesList)
			{
				String name = "url"; // The name of the custom field
				String urlValue = ""; // The value of the custom field: remember that this will always be a java.lang.String
				
				// since there is no api support for the custom field we are trying to do the other way
				Document document = SAXReaderUtil.read(article.getContentByLocale(article.getDefaultLocale()));
				Node node = document.selectSingleNode("/root/dynamic-element[@name='" + name + "']/dynamic-content");
				urlValue = node.getText();
				
				
				name = "year";
				String yearValue = "";
				node = document.selectSingleNode("/root/dynamic-element[@name='" + name + "']/dynamic-content");
				yearValue = node.getText();
			
				
				name = "month";
				String monthValue = "";
				node = document.selectSingleNode("/root/dynamic-element[@name='" + name + "']/dynamic-content");
				monthValue = node.getText();
			
				
				name = "day";
				String dayValue = "";
				node = document.selectSingleNode("/root/dynamic-element[@name='" + name + "']/dynamic-content");
				dayValue = node.getText();
				
				
				name = "location";
				String locationValue = "";
				node = document.selectSingleNode("/root/dynamic-element[@name='" + name + "']/dynamic-content");
				locationValue = node.getText();
			
				
				
				// show only the latest version
				if(JournalArticleLocalServiceUtil.isLatestVersion(groupId,article.getArticleId(),article.getVersion())){
					journalList.add(article);
					urlList.add(urlValue);
					yearList.add(yearValue);
					monthList.add(monthValue);
					dayList.add(dayValue);
					locationList.add(locationValue);
				}
			}
		
			renderRequest.setAttribute("eventList", journalList);
			renderRequest.setAttribute("urlList", urlList);
			renderRequest.setAttribute("yearList", yearList);
			renderRequest.setAttribute("monthList", monthList);
			renderRequest.setAttribute("dayList", dayList);
			renderRequest.setAttribute("locationList", locationList);
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
