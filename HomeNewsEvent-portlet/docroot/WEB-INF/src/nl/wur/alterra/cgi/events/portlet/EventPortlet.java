package nl.wur.alterra.cgi.events.portlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
			String type = "events";
			String[] structureIds = {"ACEEVENT"};
			String[] templateIds = {"ACE-EVENT-TEMPLATE"};
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
			int start = -1;
			int end = -1;
			boolean showAllFlag = false;
			if (showParam != null && showParam.equalsIgnoreCase("full"))
			{
			   start = -1;
			   end = -1;
			   //displayDateLT = null;
			   showAllFlag = true;
			}
			
			if (displayDateLT != null)
			{
			   Calendar c = Calendar.getInstance();
			   c.setTime(displayDateLT);
			   c.add(Calendar.DATE, 1);
			   displayDateLT = c.getTime();
			}
			
			OrderByComparator obc = new ArticleModifiedDateComparator(false);

/**			
			List<JournalArticle> journalArticlesList = JournalArticleLocalServiceUtil.search(
				companyId, groupId, articleId, version, title, description, content,
				type, structureIds, templateIds, displayDateGT, displayDateLT,
				status, reviewDate, andOperator, start, end, obc);
**/
			List<JournalArticle> journalArticlesList = JournalArticleLocalServiceUtil.search(companyId, groupId, folderIds,  classNameId, articleId, version, title, description, content, type, structureIds, templateIds, displayDateGT, displayDateLT, status, reviewDate,  andOperator,  start,  end,  obc);
		
			List<JournalEvent> journalList = new ArrayList<JournalEvent>();
		
			int ctr = 0;
			for (JournalArticle article : journalArticlesList)
			{
				ctr ++;
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
				String monthInMMFormat = monthValue.substring(0, 3);
			
				
				name = "day";
				String dayValue = "";
				node = document.selectSingleNode("/root/dynamic-element[@name='" + name + "']/dynamic-content");
				dayValue = node.getText();
				
				
				name = "location";
				String locationValue = "";
				node = document.selectSingleNode("/root/dynamic-element[@name='" + name + "']/dynamic-content");
				locationValue = node.getText();
			
				SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM/dd/yyyy");
				String eventDate = monthInMMFormat + "/" + dayValue + "/" + yearValue;
				Date eventDt = dateFormatter.parse(eventDate);
			    Calendar c = Calendar.getInstance();
			    c.setTime(new Date());
			    c.set(Calendar.HOUR_OF_DAY, 0);
			    c.set(Calendar.MINUTE, 0);
			    c.set(Calendar.SECOND, 0);
			    c.set(Calendar.MILLISECOND, 0);
			    Date currentDt = c.getTime();
			    
			    boolean displayFlag = false;
			    
			    if (eventDt.compareTo(currentDt) >= 0 || showAllFlag)
			    {
			    	displayFlag = true;
			    }
			      
				
				// show only the latest version
				if(JournalArticleLocalServiceUtil.isLatestVersion(groupId,article.getArticleId(),article.getVersion()) && displayFlag){
					JournalEvent newEvent = new JournalEvent();
					newEvent.setArticle(article);
					newEvent.setDate(dayValue);
					newEvent.setMonth(monthValue);
					newEvent.setYear(yearValue);
					newEvent.setUrl(urlValue);
					newEvent.setLocation(locationValue);
					newEvent.setEventDt(eventDt);
					journalList.add(newEvent);
				}
			
			}
			
			Collections.sort(journalList); 
			// get the sublist for first 5 articles if it is not full page
			if (showParam == null || ! showParam.equalsIgnoreCase("full"))
			{
				if (journalList.size() > 3)
				{
				   journalList = journalList.subList(0, 3);
				}
			}
		
			renderRequest.setAttribute("eventList", journalList);
			
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
	
	
	public static class JournalEvent implements Comparable
	{
		String url;
		String year;
		String month;
		String date;
		String location;
		Date eventDt;
		JournalArticle article ;
		
		
		public JournalArticle getArticle() {
			return article;
		}
		public void setArticle(JournalArticle article) {
			this.article = article;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getYear() {
			return year;
		}
		public void setYear(String year) {
			this.year = year;
		}
		public String getMonth() {
			return month;
		}
		public void setMonth(String month) {
			this.month = month;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public Date getEventDt() {
			return eventDt;
		}
		public void setEventDt(Date eventDt) {
			this.eventDt = eventDt;
		}
		
		public int compareTo(Object o)
		{
			JournalEvent journal =(JournalEvent) o;
			if (this.eventDt.compareTo(journal.getEventDt()) <= 0)
			{
				return -1;
			}
			else
			{
				return 1;
			}
		}
		
	}
	

}
