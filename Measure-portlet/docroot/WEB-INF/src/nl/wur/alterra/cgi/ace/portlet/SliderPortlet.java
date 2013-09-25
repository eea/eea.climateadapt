package nl.wur.alterra.cgi.ace.portlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.Measure;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;
import nl.wur.alterra.cgi.ace.service.MeasureLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.search.DAOParamUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
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
public class SliderPortlet extends MVCPortlet {
 
	private Log log = LogFactoryUtil.getLog(SliderPortlet.class.getName());
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			// First we have to get the latest case study
			String mao_type = "A";
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(Measure.class);
			query.add(PropertyFactoryUtil.forName("controlstatus").eq(new Short((short)1)));
			query.add(PropertyFactoryUtil.forName("mao_type").eq(mao_type));
			query.add(PropertyFactoryUtil.forName("casestudyfeature").like("CASEHOME%"));
			query.addOrder(OrderFactoryUtil.desc("creationdate"));
			query.setLimit(0, 1);
			List results = MeasureLocalServiceUtil.dynamicQuery(query);
		
			Measure caseStudy = null;
			if (results != null && results.size() > 0)
			{
				List<Measure> listOfMeasure = (List<Measure>) results;
				caseStudy = listOfMeasure.get(0);
				log.info("latest case study obtained is " + caseStudy.getName());
				log.info("description is " + caseStudy.getDescription());
				renderRequest.setAttribute("casestudy", caseStudy);
				
			}
			
			// Second we have to get the latest adaptation option or the latest types
			mao_type = "M";
			query = DynamicQueryFactoryUtil.forClass(Measure.class);
			query.add(PropertyFactoryUtil.forName("controlstatus").eq(new Short((short)1)));
			query.add(PropertyFactoryUtil.forName("mao_type").eq(mao_type));
			query.addOrder(OrderFactoryUtil.desc("creationdate"));
			query.setLimit(0, 1);
			results = MeasureLocalServiceUtil.dynamicQuery(query);
		
		    System.out.println("going to process other types");
			Measure adaptationOption = null;
			if (results != null && results.size() > 0)
			{
				List<Measure> listOfMeasure = (List<Measure>) results;
				adaptationOption = listOfMeasure.get(0);
				log.info("latest adaptation option id is " + adaptationOption.getMeasureId());
				log.info("latest adaptation option is " + adaptationOption.getName());
				log.info("description is " + adaptationOption.getDescription());
				//renderRequest.setAttribute("adaptationoption", adaptationOption);
			}
			
			// get the latest ace item object
			AceItem aceItem = null;
			query = DynamicQueryFactoryUtil.forClass(AceItem.class);
			query.add(PropertyFactoryUtil.forName("controlstatus").eq(new Short((short)1)));
			String[] dataTypes = {"ORGANISATION", "RESEARCHPROJECT", "TOOL", "GUIDANCE", "DOCUMENT", "INFORMATIONSOURCE"};
			query.add(PropertyFactoryUtil.forName("datatype").in(dataTypes));
			query.addOrder(OrderFactoryUtil.desc("creationdate"));
			query.setLimit(0, 1);
			results = AceItemLocalServiceUtil.dynamicQuery(query);
			if (results != null && results.size() > 0)
			{
				List<AceItem> listOfMeasure = (List<AceItem>) results;
				aceItem = listOfMeasure.get(0);
				log.info("latest aceitem id is " + aceItem.getAceItemId());
				log.info("latest aceitem is " + aceItem.getName());
				log.info("description is " + aceItem.getDescription());
			}
			
			if (adaptationOption != null && aceItem != null)
			{
				Date adaptCreationDate = adaptationOption.getCreationdate();
				Date aceItemCreationDate = aceItem.getCreationdate();
				
				log.info("adaptation option creation date " + adaptCreationDate);
				log.info("ace item creation date " + aceItemCreationDate);
				
				if (adaptCreationDate.compareTo(aceItemCreationDate) >= 0)
				{
					renderRequest.setAttribute("type", "adaptationoption");
					renderRequest.setAttribute("aceadaptobject", adaptationOption);
				}
				else
				{
					renderRequest.setAttribute("type", "aceitem");
					renderRequest.setAttribute("aceadaptobject", aceItem);
				}
				
			}
			else if (adaptationOption != null)
			{
				renderRequest.setAttribute("type", "adaptationoption");
				renderRequest.setAttribute("aceadaptobject", adaptationOption);
			}
			else
			{
				renderRequest.setAttribute("type", "aceitemobject");
				renderRequest.setAttribute("aceadaptobject", aceItem);
			}
			
			
			// Third we have to get the latest event - we have to optimize the following code to get the latest event
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
			Date displayDateGT = null;
			int status = WorkflowConstants.STATUS_APPROVED;
			Date reviewDate = null;
			boolean andOperator = true;
			int start = -1;
			int end = -1;
			
			Calendar c = Calendar.getInstance();
		    c.setTime(new Date());
		    c.set(Calendar.HOUR_OF_DAY, 0);
		    c.set(Calendar.MINUTE, 0);
		    c.set(Calendar.SECOND, 0);
		    c.set(Calendar.MILLISECOND, 0);
		    c.add(Calendar.DATE, 1);
		    Date displayDateLT = c.getTime();
		    
            OrderByComparator obc = new ArticleModifiedDateComparator(false);
			
			List<JournalArticle> journalArticlesList = JournalArticleLocalServiceUtil.search(
				companyId, groupId, articleId, version, title, description, content,
				type, structureIds, templateIds, displayDateGT, displayDateLT,
				status, reviewDate, andOperator, start, end, obc);
		
			List<JournalEvent> journalList = new ArrayList<JournalEvent>();
			
			
			
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
			    c = Calendar.getInstance();
			    c.setTime(new Date());
			    c.set(Calendar.HOUR_OF_DAY, 0);
			    c.set(Calendar.MINUTE, 0);
			    c.set(Calendar.SECOND, 0);
			    c.set(Calendar.MILLISECOND, 0);
			    Date currentDt = c.getTime();
			    
			    boolean displayFlag = false;
			    
			    if (eventDt.compareTo(currentDt) >= 0 )
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
			
			log.info("the length of event articles is " + journalList.size());
			JournalEvent journalEvent = null;
			
			if (journalList.size() > 0 )
			{
				journalEvent = journalList.get(0);
				log.info("journal event is " + journalEvent);
			}
			// get the latest journal event
			renderRequest.setAttribute("event", journalEvent);
		}
		catch (Exception e)
		{
			throw new PortletException(e);
		}
		super.doView(renderRequest, renderResponse);
	}
	
	// Decorator for the JournalArticle
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
		
		public String toString()
		{
			StringBuffer buffer = new StringBuffer();
			buffer.append("Title: ").append(this.article.getTitle());
			buffer.append("Description: ").append(this.article.getDescription());
			buffer.append("Display Date: ").append(this.article.getDisplayDate());
			buffer.append("Url: ").append(this.url);
			buffer.append("Event Date: ").append(this.eventDt);
			return buffer.toString();
		}
		
	}
}

