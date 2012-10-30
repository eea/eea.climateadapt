package nl.wur.alterra.cgi.ace.portlet;

import java.util.Date;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.mail.MailEngine;

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.Project;
import nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact;
import nl.wur.alterra.cgi.ace.model.constants.AceItemCountry;
import nl.wur.alterra.cgi.ace.model.constants.AceItemElement;
import nl.wur.alterra.cgi.ace.model.constants.AceItemSector;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexSynchronizer;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexUtil;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;

import javax.mail.internet.InternetAddress;
import javax.portlet.PortletRequest;

/**
 * Portlets that need to update projects and synchronize with AceItems extend this class.
 *
 * @author hugo de groot
 */
public abstract class ProjectUpdateHelper extends MVCPortlet {
	
	private String username = "";	
	private String useremail = "";

	/**
	 * Convenience method to  F I L L  a Project object out of the request. Used
	 * by the Add / Edit methods.
	 *
	 */
	protected void projectFromRequest(PortletRequest request, Project project) throws Exception {
		ThemeDisplay themeDisplay =
			(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		
		if(request.getRemoteUser() != null) {
			User user = UserServiceUtil.getUserById( Long.parseLong(request.getRemoteUser()));
			String moderator = project.getModerator();
			
			username = user.getFullName();
			useremail = user.getEmailAddress();
			String newModerator = username + " (" + useremail + ")" ;  
			
			if(moderator.indexOf( newModerator )==-1) {
				
				project.setModerator( moderator + (moderator.length()==0 ? "" : ", ") + newModerator );
			}
		}
		
		Date d = new Date() ;
		d.setTime(ParamUtil.getLong(request, "checkcreationdate"));
		project.setApprovaldate(d);  // hack optimistic locking!!!  Check with dbrecord in ProjectValidator
		
		project.setAcronym(ParamUtil.getString(request, "acronym"));
		project.setTitle(ParamUtil.getString(request, "title"));
/*		
		int dateMonth = ParamUtil.getInteger(request, "startdateMonth");
		int dateDay = ParamUtil.getInteger(request, "startdateDay");
		int dateYear = ParamUtil.getInteger(request, "startdateYear");
		Date startdate = PortalUtil.getDate(dateMonth, dateDay, dateYear);
		project.setStartdate(startdate);
		
		dateMonth = ParamUtil.getInteger(request, "enddateMonth");
		dateDay = ParamUtil.getInteger(request, "enddateDay");
		dateYear = ParamUtil.getInteger(request, "enddateYear");
		Date enddate = PortalUtil.getDate(dateMonth, dateDay, dateYear);
		project.setEnddate(enddate);
*/		
		project.setLead(ParamUtil.getString(request, "lead"));
		project.setPartners(ParamUtil.getString(request, "partners"));
		project.setFunding(ParamUtil.getString(request, "funding"));
		
		String choosencountries = "";
		for(AceItemCountry aceitemcountry : AceItemCountry.values() ) {
			
			if( ParamUtil.getString(request, "chk_countries_" + aceitemcountry.toString()) != null )  {
				String s =  ParamUtil.getString(request, "chk_countries_" + aceitemcountry.toString());
				if(s.equalsIgnoreCase(aceitemcountry.toString())) {				
					choosencountries +=  aceitemcountry.toString() + ";";
				}
			}
		}
		project.setSpatialvalues(choosencountries);
		//project.setSpatialvalues(ParamUtil.getString(request, "spatialvalues").replace("UK","GB"));
		
		String choosensectors = "";
		for(AceItemSector aceitemsector : AceItemSector.values() ) {
			
			if( ParamUtil.getString(request, "chk_sectors_" + aceitemsector.toString()) != null )  {
				String s =  ParamUtil.getString(request, "chk_sectors_" + aceitemsector.toString());
				if(s.equalsIgnoreCase(aceitemsector.toString())) {				
					choosensectors +=  aceitemsector.toString() + ";";
				}
			}
		}
		project.setSectors(choosensectors);

		project.setSpatiallayer(ParamUtil.getString(request, "spatiallayer"));
		project.setAbstracts(ParamUtil.getString(request, "abstracts"));
		project.setComments(ParamUtil.getString(request, "comments"));
		
		String choosenelements = "";
		for(AceItemElement aceitemelement : AceItemElement.values() ) {
			if( ParamUtil.getString(request, "chk_elements_" + aceitemelement) != null )  {
				String e =  ParamUtil.getString(request, "chk_elements_" + aceitemelement);
				if(e.equalsIgnoreCase(aceitemelement.toString())) {
					choosenelements +=  aceitemelement.toString() + ";";
				}
			}
		}		
		project.setElement(choosenelements);
		
		String choosenclimateimpacts = "";
		for(AceItemClimateImpact aceitemclimateimpact : AceItemClimateImpact.values() ) {
			if( ParamUtil.getString(request, "chk_climateimpacts_" + aceitemclimateimpact) != null )  {
				String e =  ParamUtil.getString(request, "chk_climateimpacts_" + aceitemclimateimpact);
				if(e.equalsIgnoreCase(aceitemclimateimpact.toString())) {
					choosenclimateimpacts +=  aceitemclimateimpact.toString() + ";";
				}
			}
		}		
		project.setClimateimpacts(choosenclimateimpacts);
		
		String websites= ParamUtil.getString(request, "website");
		// robust multiple website handling. Check for splitters space, ',' and ';' 
		if(websites != null) {
			websites = websites.replace("  ", " ");
			websites = websites.replace(",", " ");
			websites = websites.replace(";", " ");
			websites = websites.replace("  ", " ");
			String[] site = websites.split(" ");
			if(site.length > 1)	{
				websites = "";
				for(int i=0; i < site.length; i++) {					
					site[i] = site[i].trim();
					if (site[i].length() > 0) {
					// end up with splitter '; '
						websites += site[i]  ;
						if( i < site.length-1) {
						// not last
							websites += "; " ;
						}
					}
				}
			}
		}
		project.setWebsite(websites);
		
		project.setKeywords(ParamUtil.getString(request, "keywords"));
		project.setDuration(ParamUtil.getString(request, "duration"));
		project.setSpecialtagging(ParamUtil.getString(request, "specialtagging"));
		project.setSource(ParamUtil.getString(request, "source"));
		
		String importance = ParamUtil.getString(request, "chk_importance");
		if(project.getImportance() == 1) {
			project.setImportance( project.getImportance()-1 );
			project.setRating( project.getRating() - 100);

		}
		if( importance != null && importance.equalsIgnoreCase("1")) {
			project.setImportance(project.getImportance()+1);
			project.setRating( project.getRating() + 100);
		}
		
		String approved = ParamUtil.getString(request, "chk_controlstatus");
		if( (approved == null ) || (approved.length()==0) ) {
			project.setControlstatus( (short) 0 );
		}
		else {
			project.setControlstatus( Short.parseShort(approved));
		}
		
		project.setCompanyId(themeDisplay.getCompanyId());
		project.setGroupId(themeDisplay.getScopeGroupId());
				
		project.setCreationdate( new Date() );
	}

	private String coalesce(String aString) {
		String result = "";
		
		if(aString != null) {
			
			result = aString.trim();
		}
		
		return result;
	}
	
	/**
	 * Update the corresponding AceItem when updating a Project.
	 *
	 */
	protected void updateAceItem(Project project, AceItem aceitem) throws Exception {

		aceitem.setName(project.getAcronym().trim() + " project");
		
		aceitem.setDescription(project.getTitle());
		
		aceitem.setKeyword(project.getKeywords());
		
		aceitem.setSpatialLayer(project.getSpatiallayer());
		
		aceitem.setSpatialValues(project.getSpatialvalues());
		
		aceitem.setSectors_(project.getSectors());
		
		aceitem.setElements_(project.getElement());
		
		aceitem.setClimateimpacts_(project.getClimateimpacts());
		
		aceitem.setRating(project.getRating());
		
		aceitem.setImportance(project.getImportance());
		
		aceitem.setSpecialtagging(project.getSpecialtagging());
		
		aceitem.setDeeplink(project.getWebsite());
		
		aceitem.setControlstatus(project.getControlstatus());
		
		aceitem.setCreator(project.getCreator());
		
		aceitem.setCreationdate(project.getCreationdate());
		
		aceitem.setModerator(project.getModerator());
		
		aceitem.setApprovaldate(project.getApprovaldate());
		
		aceitem.setTextSearch( project.getSpecialtagging() + ' ' +
	               			   aceitem.getName() + ' ' +
				               project.getTitle() + ' ' +
				               project.getLead() + ' ' +
				               project.getPartners() + ' ' +
				               project.getFunding() + ' ' +
			 			   	   project.getSpatiallayer().replace("_" , "") + ' ' +
			 			   	   project.getSpatialvalues() + ' ' +
				               project.getAbstracts() + ' ' +
				               project.getKeywords() + ' ' +
				               project.getSource() + ' ' +
				               project.getSpatialvalues() + ' ' +
				               project.getTextwebpage() 
				              );
		
		String sctrs = project.getSectors();
		
		if( ( coalesce(sctrs).length() > 0 ) && ( sctrs.indexOf(";")  ==  sctrs.lastIndexOf(";") ) ) { // one sector
			
			aceitem.setTextSearch( aceitem.getTextSearch() + ' ' + coalesce( sctrs.substring(0, sctrs.indexOf(";") ) ) );
		}
		
		AceItemLocalServiceUtil.updateAceItem(aceitem);

        new ACEIndexSynchronizer().reIndex(aceitem);
	}
	
    protected void sendSubmitNotification(Project project) {

    	  if(project.getControlstatus()==ACEIndexUtil.Status_SUBMITTED)  { 	
        	try {
        	InternetAddress fromInternetAddress = new InternetAddress(ACEIndexUtil.retrieveNotificationFromAddress());
        	String notificationaddresslist=ACEIndexUtil.retrieveNotificationToAddressList(); 
        	
        	String[] notificationaddresses = notificationaddresslist.split(";");
         	InternetAddress[] toInternetAddresses = new InternetAddress[notificationaddresses.length] ;
         	for(int i = 0 ; i < notificationaddresses.length; i++) { 		
         		if (notificationaddresses[i].trim().length() > 0 ) {
         			toInternetAddresses[i] = new InternetAddress(notificationaddresses[i]);
         		}
        	}
         	
         	String hosturl=ACEIndexUtil.retrieveNotificationHostUrl();
         	
        	String subject = "Climate-adapt: A project is waiting for approval";
        	String body = "Please have a look at the submitted ";
        	body += "project at " + hosturl + "/projects1?ace_project_id=" + project.getProjectId();
        	body += "\nEditor: " + username;
        	body += "\nEmail: " + useremail;
    		    	
        	MailEngine.send(fromInternetAddress, toInternetAddresses, null, null, subject, body, false, null, null, null);

          	// send second email to contributor
        	InternetAddress[] contributorAddress = new InternetAddress[1];
        	contributorAddress[0] = new InternetAddress(useremail);
        	subject = "Your contribution to Climate-Adapt" ; 
        	body = "Thank you for your contribution to Climate-Adapt regarding '" + project.getAcronym() + "'.\n\n" ; 
        	body += "Your contribution will be reviewed and handled by the website moderators." ; 
        	MailEngine.send(fromInternetAddress, contributorAddress, null, null, subject, body, false, null, null, null);
          }
          catch (Exception e) {
        	  // do nothing
        	  System.out.println("Sending submit notification for project failed.");
        	  System.out.println(e.getMessage());
        	  e.printStackTrace();
          }
        }
      }
}
