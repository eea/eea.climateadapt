package nl.wur.alterra.cgi.ace.portlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.Measure;
import nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact;
import nl.wur.alterra.cgi.ace.model.constants.AceItemCountry;
import nl.wur.alterra.cgi.ace.model.constants.AceItemElement;
import nl.wur.alterra.cgi.ace.model.constants.AceItemSector;
import nl.wur.alterra.cgi.ace.model.constants.AceItemType;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexSynchronizer;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;

import javax.portlet.PortletRequest;

/**
 * Portlets that need to update measures and synchronize with AceItems extend this class.
 *
 * @author hugo de groot
 */
public abstract class MeasureUpdateHelper extends MVCPortlet {

	/**
	 * Convenience method to   F I L L   a Measure object out of the request. Used
	 * by the Add / Edit methods.
	 *
	 */
	protected void measureFromRequest(PortletRequest request, Measure measure)  throws Exception  {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		
		if(request.getRemoteUser() != null) {
			User user = UserServiceUtil.getUserById( Long.parseLong(request.getRemoteUser()));
			String moderator = measure.getModerator();
			if(moderator.indexOf(user.getScreenName())==-1) {
				
				measure.setModerator( moderator + (moderator.length()==0 ? "" : ", ") + user.getScreenName());
			}
		}
		
		measure.setCompanyId(themeDisplay.getCompanyId());
		measure.setGroupId(themeDisplay.getScopeGroupId());
		
		measure.setName(ParamUtil.getString(request, "name"));
		measure.setDescription(ParamUtil.getString(request, "description"));
		measure.setImplementationtype(ParamUtil.getString(request, "implementationtype"));
		measure.setImplementationtime(ParamUtil.getString(request, "implementationtime"));
		measure.setLifetime(ParamUtil.getString(request, "lifetime"));
		measure.setSpatiallayer(ParamUtil.getString(request, "spatiallayer"));
		measure.setLegalaspects(ParamUtil.getString(request, "legalaspects"));
		measure.setStakeholderparticipation(ParamUtil.getString(request, "stakeholderparticipation"));
		measure.setContact(ParamUtil.getString(request, "contact"));
		measure.setSucceslimitations(ParamUtil.getString(request, "succeslimitations"));

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
		measure.setWebsite(websites);	
		
		measure.setCostbenefit(ParamUtil.getString(request, "costbenefit"));	
		measure.setKeywords(ParamUtil.getString(request, "keywords"));	
		measure.setComments(ParamUtil.getString(request, "comments"));			
		/*		
		int dateMonth = ParamUtil.getInteger(request, "startdateMonth");
		int dateDay = ParamUtil.getInteger(request, "startdateDay");
		int dateYear = ParamUtil.getInteger(request, "startdateYear");
		Date startdate = PortalUtil.getDate(dateMonth, dateDay, dateYear);
		measure.setStartdate(startdate);
		
		dateMonth = ParamUtil.getInteger(request, "enddateMonth");
		dateDay = ParamUtil.getInteger(request, "enddateDay");
		dateYear = ParamUtil.getInteger(request, "enddateYear");
		Date enddate = PortalUtil.getDate(dateMonth, dateDay, dateYear);
		measure.setEnddate(enddate);
		
		dateMonth = ParamUtil.getInteger(request, "publicationdateMonth");
		dateDay = ParamUtil.getInteger(request, "publicationdateDay");
		dateYear = ParamUtil.getInteger(request, "publicationdateYear");
		Date publicationdate = PortalUtil.getDate(dateMonth, dateDay, dateYear);
		measure.setEndDate(publicationdate);
*/	
		measure.setSpecialtagging(ParamUtil.getString(request, "specialtagging"));

		String choosencountries = "";
		for(AceItemCountry aceitemcountry : AceItemCountry.values() ) {
			
			if( ParamUtil.getString(request, "chk_countries_" + aceitemcountry.toString()) != null )  {
				String s =  ParamUtil.getString(request, "chk_countries_" + aceitemcountry.toString());
				if(s.equalsIgnoreCase(aceitemcountry.toString())) {				
					choosencountries +=  aceitemcountry.toString() + ";";
				}
			}
		}
		measure.setSpatialvalues(choosencountries);
		//measure.setSpatialvalues(ParamUtil.getString(request, "spatialvalues").replace("UK","GB"));		
		
		String choosensectors = "";
		for(AceItemSector aceitemsector : AceItemSector.values() ) {
			
			if( ParamUtil.getString(request, "chk_sectors_" + aceitemsector.toString()) != null )  {
				String s =  ParamUtil.getString(request, "chk_sectors_" + aceitemsector.toString());
				if(s.equalsIgnoreCase(aceitemsector.toString())) {				
					choosensectors +=  aceitemsector.toString() + ";";
				}
			}
		}
		measure.setSectors_(choosensectors);
		
		String choosenelements = "";
		for(AceItemElement aceitemelement : AceItemElement.values() ) {
			if( ParamUtil.getString(request, "chk_elements_" + aceitemelement) != null )  {
				String e =  ParamUtil.getString(request, "chk_elements_" + aceitemelement);
				if(e.equalsIgnoreCase(aceitemelement.toString())) {
					choosenelements +=  aceitemelement.toString() + ";";
				}
			}
		}		
		measure.setElements_(choosenelements);
		
		String choosenclimateimpacts = "";
		for(AceItemClimateImpact aceitemclimateimpact : AceItemClimateImpact.values() ) {
			if( ParamUtil.getString(request, "chk_climateimpacts_" + aceitemclimateimpact) != null )  {
				String e =  ParamUtil.getString(request, "chk_climateimpacts_" + aceitemclimateimpact);
				if(e.equalsIgnoreCase(aceitemclimateimpact.toString())) {
					choosenclimateimpacts +=  aceitemclimateimpact.toString() + ";";
				}
			}
		}		
		measure.setClimateimpacts_(choosenclimateimpacts);
		
		measure.setMao_type(ParamUtil.getString(request, "mao_type"));
		measure.setSource(ParamUtil.getString(request, "source"));

		String importance = ParamUtil.getString(request, "chk_importance");
		if(measure.getImportance() == 1) {
			measure.setImportance( measure.getImportance()-1 );
			measure.setRating( measure.getRating() - 100);

		}
		if( importance != null && importance.equalsIgnoreCase("1")) {
			measure.setImportance(measure.getImportance()+1);
			measure.setRating( measure.getRating() + 100);
		}
		
		String approved = ParamUtil.getString(request, "chk_controlstatus");
		if( (approved == null ) || (approved.length()==0) ) {
			measure.setControlstatus( (short) 0 );
		}
		else {
			measure.setControlstatus( Short.parseShort(approved));
		}

		if(ParamUtil.getString(request, "lon") != null) {
			try {
				measure.setLon(Double.parseDouble(ParamUtil.getString(request, "lon")));
			}
			catch (NumberFormatException e) {
				// do nothing
			}
		}
		
		if(ParamUtil.getString(request, "lat") != null) {
			try {
				measure.setLat(Double.parseDouble(ParamUtil.getString(request, "lat")));
			}
			catch (NumberFormatException e) {
				// do nothing
			}
		}
		
		measure.setSatarea(ParamUtil.getString(request, "satarea"));
	}

	
	private String coalesce(String aString) {
		String result = "";
		
		if(aString != null) {
			
			result = aString.trim();
		}
		
		return result;
	}
	
	/**
	 * Update the corresponding AceItem when updating a Measure.
	 *
	 */
	protected void updateAceItem(Measure measure, AceItem aceitem) throws Exception {

		aceitem.setName(measure.getName());
		
		aceitem.setDescription(measure.getDescription());
		
		if(measure.getMao_type().indexOf("A") >= 0) {

			aceitem.setDatatype(AceItemType.ACTION.toString());			
		}
		else {

			aceitem.setDatatype(AceItemType.MEASURE.toString());
		}
				
		aceitem.setKeyword(measure.getKeywords());
		
		aceitem.setSpatialLayer(measure.getSpatiallayer());
		
		aceitem.setSpatialValues(measure.getSpatialvalues());
		
		aceitem.setSectors_(measure.getSectors_());
		
		aceitem.setElements_(measure.getElements_());

		aceitem.setClimateimpacts_(measure.getClimateimpacts_());
		
		aceitem.setRating(measure.getRating());
		
		aceitem.setImportance(measure.getImportance());

		aceitem.setSource(measure.getSource());
		
		aceitem.setDeeplink(measure.getWebsite());
		
		aceitem.setSpecialtagging(measure.getSpecialtagging());
/*		
		aceitem.setControlstatus(measure.getControlstatus());
		
		if(measure.getCreator() != null) {
			aceitem.setCreator(measure.getCreator());
		}
		
		if(measure.getCreationdate() != null) {
			aceitem.setCreationdate(measure.getCreationdate());
		}
		
		if(measure.getModerator() != null) {
			aceitem.setModerator(measure.getModerator());
		}
		
		if(measure.getApprovaldate() != null) {
			aceitem.setApprovaldate(measure.getApprovaldate());
		}
*/		
		aceitem.setTextSearch( measure.getSpecialtagging() + ' ' +
 			   		aceitem.getName() + ' ' +
 			   		measure.getDescription() + ' ' +
 			   		measure.getContact() + ' ' +
 			   		measure.getKeywords()+ ' ' +
 			   		measure.getWebsite() + ' ' +
 			   		measure.getSpatiallayer().replace("_" , "") + ' ' +
 			   		measure.getSpatialvalues() + ' ' +
 			   		measure.getLegalaspects() + ' ' +
 			   		measure.getSucceslimitations() + ' ' +
 			   		measure.getCostbenefit() + ' ' +
 			   		measure.getStakeholderparticipation() + ' ' +
 			   		measure.getSource() + ' ' +
 			   		measure.getTextwebpage()
 			   	);
					
		String sctrs = measure.getSectors_();
		
		if( ( coalesce(sctrs).length() > 0 ) && ( sctrs.indexOf(";")  ==  sctrs.lastIndexOf(";") ) ) { // one sector
				
			aceitem.setTextSearch( aceitem.getTextSearch() + ' ' + coalesce( sctrs.substring(0, sctrs.indexOf(";") ) ) );
		}	
		
		String mpcts = measure.getClimateimpacts_();
		
		if( ( coalesce(mpcts).length() > 0 ) && ( mpcts.indexOf(";")  ==  mpcts.lastIndexOf(";") ) ) { // one climate impact
				
			aceitem.setTextSearch( aceitem.getTextSearch() + ' ' + coalesce( mpcts.substring(0, mpcts.indexOf(";") ) ) );
		}	
		
		AceItemLocalServiceUtil.updateAceItem(aceitem);

        new ACEIndexSynchronizer().reIndex(aceitem);		
	}
}
