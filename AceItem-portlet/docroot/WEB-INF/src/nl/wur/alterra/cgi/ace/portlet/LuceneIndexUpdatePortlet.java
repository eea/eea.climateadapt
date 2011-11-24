package nl.wur.alterra.cgi.ace.portlet;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact;
import nl.wur.alterra.cgi.ace.model.constants.AceItemElement;
import nl.wur.alterra.cgi.ace.model.constants.AceItemSector;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexSynchronizer;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

/**
 * Portlets that need to update the Lucene index extend this class.
 *
 * @author heikki doeleman
 */
public abstract class LuceneIndexUpdatePortlet extends MVCPortlet {


    /**
     * Rebuilds complete index based on contents of database.
     *
     * @param request
     * @param response
     * @throws Exception
     */
    public void synchronizeIndex(ActionRequest request, ActionResponse response) throws Exception {
        //System.out.println("Synchronizing Lucene index with DBMS");
        ACEIndexSynchronizer aceIndexSynchronizer = new ACEIndexSynchronizer();
        aceIndexSynchronizer.synchronize();
        //System.out.println("Finished synchronizing Lucene index with DBMS");
    }


    /**
     * Re-builds Lucene index for a single AceItem.
     *
     */
    public void synchronizeIndexSingleAceItem(AceItem aceitem) {
        //System.out.println("Re-building Lucene index for single AceItem");
        ACEIndexSynchronizer aceIndexSynchronizer = new ACEIndexSynchronizer();
        aceIndexSynchronizer.reIndex(aceitem);
        //System.out.println("Finished re-building Lucene index for single AceItem");
    }

    /**
     * Convenience method to create a AceItem object out of the request.
     *
     * @author hugo de groot
     *
     * @param request
     * @param aceitem
     * @return
     */
    protected AceItem aceitemFromRequest(PortletRequest request, AceItem aceitem) {
        ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

        aceitem.setCompanyId(themeDisplay.getCompanyId());
        aceitem.setGroupId(themeDisplay.getScopeGroupId());

        aceitem.setWxsharvesterId(ParamUtil.getLong(request, "wxsharvesterId"));
        aceitem.setName(ParamUtil.getString(request, "name"));
        aceitem.setDescription(ParamUtil.getString(request, "description"));
        
        String oldspecialtagging = aceitem.getSpecialtagging();
        aceitem.setSpecialtagging(ParamUtil.getString(request, "specialtagging"));

        aceitem.setDatatype(ParamUtil.getString(request, "datatype"));
        aceitem.setStoredAt(ParamUtil.getString(request, "storedAt"));
        aceitem.setStoragetype(ParamUtil.getString(request, "storagetype"));

        String choosensectors = "";
        for(AceItemSector aceitemsector : AceItemSector.values() ) {

            if( ParamUtil.getString(request, "chk_sectors_" + aceitemsector.toString()) != null )  {
                String s =  ParamUtil.getString(request, "chk_sectors_" + aceitemsector.toString());
                if(s.equalsIgnoreCase(aceitemsector.toString())) {
                    choosensectors +=  aceitemsector.toString() + ";";
                }
            }
        }
        aceitem.setSectors_(choosensectors);

        String choosenelements = "";
        for(AceItemElement aceitemelement : AceItemElement.values() ) {
            if( ParamUtil.getString(request, "chk_elements_" + aceitemelement) != null )  {
                String e =  ParamUtil.getString(request, "chk_elements_" + aceitemelement);
                if(e.equalsIgnoreCase(aceitemelement.toString())) {
                    choosenelements +=  aceitemelement.toString() + ";";
                }
            }
        }
        aceitem.setElements_(choosenelements);

        String choosenclimateimpacts = "";
        for(AceItemClimateImpact aceitemclimateimpact : AceItemClimateImpact.values() ) {
            if( ParamUtil.getString(request, "chk_climateimpacts_" + aceitemclimateimpact) != null )  {
                String e =  ParamUtil.getString(request, "chk_climateimpacts_" + aceitemclimateimpact);
                if(e.equalsIgnoreCase(aceitemclimateimpact.toString())) {
                    choosenclimateimpacts +=  aceitemclimateimpact.toString() + ";";
                }
            }
        }
        aceitem.setClimateimpacts_(choosenclimateimpacts);
        
        String oldtextsearch = ParamUtil.getString(request, "textSearch");
        if(oldspecialtagging != null && oldspecialtagging.trim().length() > 0 &&
        	oldtextsearch.startsWith(oldspecialtagging) ) {
        	
        	oldtextsearch = oldtextsearch.substring( oldspecialtagging.length()+1 );
        }
        
        aceitem.setTextSearch(ParamUtil.getString(request, "specialtagging") + " " 
        		            + oldtextsearch);
        aceitem.setKeyword(ParamUtil.getString(request, "keyword"));
        aceitem.setSpatialLayer(ParamUtil.getString(request, "spatialLayer"));
        aceitem.setSpatialValues(ParamUtil.getString(request, "spatialValues").replace("UK","GB"));
        aceitem.setCompanyId(themeDisplay.getCompanyId());
        aceitem.setGroupId(themeDisplay.getScopeGroupId());
/*
		int dateMonth = ParamUtil.getInteger(request, "startDateMonth");
		int dateDay = ParamUtil.getInteger(request, "startDateDay");
		int dateYear = ParamUtil.getInteger(request, "startDateYear");
		Date startdate = PortalUtil.getDate(dateMonth, dateDay, dateYear);
		aceitem.setStartDate(startdate);

		dateMonth = ParamUtil.getInteger(request, "endDateMonth");
		dateDay = ParamUtil.getInteger(request, "endDateDay");
		dateYear = ParamUtil.getInteger(request, "endDateYear");
		Date enddate = PortalUtil.getDate(dateMonth, dateDay, dateYear);
		aceitem.setEndDate(enddate);

		dateMonth = ParamUtil.getInteger(request, "publicationDateMonth");
		dateDay = ParamUtil.getInteger(request, "publicationDateDay");
		dateYear = ParamUtil.getInteger(request, "publicationDateYear");
		Date publicationdate = PortalUtil.getDate(dateMonth, dateDay, dateYear);
		aceitem.setEndDate(publicationdate);
*/
        String importance = ParamUtil.getString(request, "chk_importance");

        if(aceitem.getImportance() == 1) {
              aceitem.setImportance( aceitem.getImportance()-1 );
              aceitem.setRating( aceitem.getRating() - 100);
        }

        if( importance != null && importance.equalsIgnoreCase("1")) {
              aceitem.setImportance(aceitem.getImportance()+1);
              aceitem.setRating( aceitem.getRating() + 100);
        }

        aceitem.setSource(ParamUtil.getString(request, "source"));

        return aceitem;
    }




}