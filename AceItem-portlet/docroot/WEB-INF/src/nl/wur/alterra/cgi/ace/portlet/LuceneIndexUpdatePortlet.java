package nl.wur.alterra.cgi.ace.portlet;

import java.util.ArrayList;
import java.util.Date;

import com.liferay.util.mail.MailEngine;
import com.liferay.util.mail.MailEngineException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserModel;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact;
import nl.wur.alterra.cgi.ace.model.constants.AceItemCountry;
import nl.wur.alterra.cgi.ace.model.constants.AceItemElement;
import nl.wur.alterra.cgi.ace.model.constants.AceItemSector;
import nl.wur.alterra.cgi.ace.model.constants.AceItemScenario;
import nl.wur.alterra.cgi.ace.model.constants.AceItemTimePeriod;
import nl.wur.alterra.cgi.ace.model.constants.AceItemType;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexSynchronizer;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexUtil;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

import org.apache.commons.lang.StringUtils;

/**
 * Portlets that need to update the Lucene index extend this class.
 *
 * @author heikki doeleman
 */
public abstract class LuceneIndexUpdatePortlet extends MVCPortlet {

    private String username = "";
    private String useremail = "";

    private User requestUser;

    /**
     * Rebuilds complete index based on contents of database.
     *
     * @param request
     * @param response
     * @throws Exception
     */
    public void synchronizeIndex(ActionRequest request, ActionResponse response) throws Exception {
        // System.out.println("Synchronizing Lucene index with DBMS");
        ACEIndexSynchronizer aceIndexSynchronizer = new ACEIndexSynchronizer();
        aceIndexSynchronizer.synchronize();
        // System.out.println("Finished synchronizing Lucene index with DBMS");
    }

    /**
     * Re-builds Lucene index for a single AceItem.
     *
     */
    public void synchronizeIndexSingleAceItem(AceItem aceitem) {
        // System.out.println("Re-building Lucene index for single AceItem");
        ACEIndexSynchronizer aceIndexSynchronizer = new ACEIndexSynchronizer();
        aceIndexSynchronizer.reIndex(aceitem);
    }

    private String coalesce(String aString) {
        String result = "";

        if (aString != null) {

            result = aString.trim();
        }

        return result;
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
    protected AceItem aceitemFromRequest(PortletRequest request, AceItem aceitem) throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        if (request.getRemoteUser() != null) {
            requestUser = UserServiceUtil.getUserById(Long.parseLong(request.getRemoteUser()));
            String moderator = aceitem.getModerator();

            username = requestUser.getFullName();
            useremail = requestUser.getEmailAddress();
            String newModerator = username + " (" + useremail + ")";

            if (moderator.indexOf(newModerator) == -1) {

                aceitem.setModerator(moderator + (moderator.length() == 0 ? "" : ", ") + newModerator);
            }
        }

        Date d = new Date();
        d.setTime(ParamUtil.getLong(request, "checkcreationdate"));
        aceitem.setLockdate(d); // hack optimistic locking!!! Check with
                                    // dbrecord in AceItemValidator

        aceitem.setCompanyId(themeDisplay.getCompanyId());
        aceitem.setGroupId(themeDisplay.getScopeGroupId());

        aceitem.setWxsharvesterId(ParamUtil.getLong(request, "wxsharvesterId"));
        aceitem.setName(ParamUtil.getString(request, "name"));
        aceitem.setDescription(ParamUtil.getString(request, "description"));

        aceitem.setSpecialtagging(ParamUtil.getString(request, "specialtagging"));

        aceitem.setDatatype(ParamUtil.getString(request, "datatype"));
        aceitem.setStoragetype(ParamUtil.getString(request, "storagetype"));

        if (aceitem.getStoragetype().equalsIgnoreCase("URL")) {
            String websites = ParamUtil.getString(request, "storedAt");
            // robust multiple website handling. Check for splitters space, ','
            // and ';'
            if (websites != null) {
                websites = websites.replace("  ", " ");
                websites = websites.replace(",", " ");
                websites = websites.replace(";", " ");
                websites = websites.replace("  ", " ");
                String[] site = websites.split(" ");
                if (site.length > 1) {
                    websites = "";
                    for (int i = 0; i < site.length; i++) {
                        site[i] = site[i].trim();
                        if (site[i].length() > 0) {
                            // end up with splitter '; '
                            websites += site[i];
                            if (i < site.length - 1) {
                                // not last
                                websites += "; ";
                            }
                        }
                    }
                }
            }
            aceitem.setStoredAt(websites);
        } else {

            aceitem.setStoredAt(ParamUtil.getString(request, "storedAt"));
        }

        aceitem.setKeyword(ParamUtil.getString(request, "keyword"));
        aceitem.setSpatialLayer(ParamUtil.getString(request, "spatialLayer"));

        aceitem.setSource(ParamUtil.getString(request, "source"));
        aceitem.setComments(ParamUtil.getString(request, "comments"));
        aceitem.setYear(ParamUtil.getString(request, "year"));
        //aceitem.setScenario(ParamUtil.getString(request, "scenario"));
        aceitem.setTimeperiod(ParamUtil.getString(request, "timeperiod"));

        String choosencountries = "";
        for (AceItemCountry aceitemcountry : AceItemCountry.values()) {

            if (ParamUtil.getString(request, "chk_countries_" + aceitemcountry.toString()) != null) {
                String s = ParamUtil.getString(request, "chk_countries_" + aceitemcountry.toString());
                if (s.equalsIgnoreCase(aceitemcountry.toString())) {
                    choosencountries += aceitemcountry.toString() + ";";
                }
            }
        }
        aceitem.setSpatialValues(choosencountries);
        // aceitem.setSpatialValues(ParamUtil.getString(request,
        // "spatialValues").replace("UK","GB"));

        String choosensectors = "";
        for (AceItemSector aceitemsector : AceItemSector.values()) {

            if (ParamUtil.getString(request, "chk_sectors_" + aceitemsector.toString()) != null) {
                String s = ParamUtil.getString(request, "chk_sectors_" + aceitemsector.toString());
                if (s.equalsIgnoreCase(aceitemsector.toString())) {
                    choosensectors += aceitemsector.toString() + ";";
                }
            }
        }
        aceitem.setSectors_(choosensectors);

        String choosenelements = "";
        for (AceItemElement aceitemelement : AceItemElement.values()) {
            if (ParamUtil.getString(request, "chk_elements_" + aceitemelement) != null) {
                String e = ParamUtil.getString(request, "chk_elements_" + aceitemelement);
                if (e.equalsIgnoreCase(aceitemelement.toString())) {
                    choosenelements += aceitemelement.toString() + ";";
                }
            }
        }
        aceitem.setElements_(choosenelements);

        String choosenclimateimpacts = "";
        for (AceItemClimateImpact aceitemclimateimpact : AceItemClimateImpact.values()) {
            if (ParamUtil.getString(request, "chk_climateimpacts_" + aceitemclimateimpact) != null) {
                String e = ParamUtil.getString(request, "chk_climateimpacts_" + aceitemclimateimpact);
                if (e.equalsIgnoreCase(aceitemclimateimpact.toString())) {
                    choosenclimateimpacts += aceitemclimateimpact.toString() + ";";
                }
            }
        }
        aceitem.setClimateimpacts_(choosenclimateimpacts);
        
        
        String choosenscenarios = "";
        for (AceItemScenario aceitemscenario : AceItemScenario.values()) {

            if (ParamUtil.getString(request, "chk_scenario_" + aceitemscenario.toString()) != null) {
                String s = ParamUtil.getString(request, "chk_scenario_" + aceitemscenario.toString());
                if (s.equalsIgnoreCase(aceitemscenario.toString())) {
                    choosenscenarios += aceitemscenario.toString() + ";";
                }
            }
        }
        aceitem.setScenario(choosenscenarios);
        
        String choosenTimePeriods = "";
        for (AceItemTimePeriod aceitemTimePeriod : AceItemTimePeriod.values()) {

            if (ParamUtil.getString(request, "chk_timeperiod_" + aceitemTimePeriod.toString()) != null) {
                String s = ParamUtil.getString(request, "chk_timeperiod_" + aceitemTimePeriod.toString());
                if (s.equalsIgnoreCase(aceitemTimePeriod.toString())) {
                    choosenTimePeriods += aceitemTimePeriod.toString() + ";";
                }
            }
        }
        aceitem.setTimeperiod(choosenTimePeriods);
        
        

        aceitem.setTextSearch(aceitem.getSpecialtagging() + " " + aceitem.getName() + " " + aceitem.getDescription() + " "
                + aceitem.getKeyword() + " " + aceitem.getSource() + " " + aceitem.getSpatialLayer() + " "
                + aceitem.getSpatialValues() + " " + aceitem.getTextwebpage());

        if (aceitem.getStoragetype().equalsIgnoreCase("MAPLAYER") || aceitem.getStoragetype().equalsIgnoreCase("PLAINMETADATA")
                || aceitem.getStoragetype().equalsIgnoreCase("SETOFMAPS")) {
            aceitem.setTextSearch(aceitem.getTextSearch() + ' ' + aceitem.getStoragetype());
        }
/* At free text searxh don't search any longer on Advanced Search Fields
        if ((coalesce(choosensectors).length() > 0) && (choosensectors.indexOf(";") == choosensectors.lastIndexOf(";"))) { // one
                                                                                                                           // sector

            aceitem.setTextSearch(aceitem.getTextSearch() + ' '
                    + coalesce(choosensectors.substring(0, choosensectors.indexOf(";"))));
        }

        if ((coalesce(choosenelements).length() > 0) && (choosenelements.indexOf(";") == choosenelements.lastIndexOf(";"))) { // one
                                                                                                                              // climate
                                                                                                                              // impact

            aceitem.setTextSearch(aceitem.getTextSearch() + ' '
                    + coalesce(choosenelements.substring(0, choosenelements.indexOf(";"))));
        }

        if ((coalesce(choosenclimateimpacts).length() > 0)
                && (choosenclimateimpacts.indexOf(";") == choosenclimateimpacts.lastIndexOf(";"))) { // one
                                                                                                     // climate
                                                                                                     // impact

            aceitem.setTextSearch(aceitem.getTextSearch() + ' '
                    + coalesce(choosenclimateimpacts.substring(0, choosenclimateimpacts.indexOf(";"))));
        }
*/        
        /*
         * int dateMonth = ParamUtil.getInteger(request, "startDateMonth"); int
         * dateDay = ParamUtil.getInteger(request, "startDateDay"); int dateYear
         * = ParamUtil.getInteger(request, "startDateYear"); Date startdate =
         * PortalUtil.getDate(dateMonth, dateDay, dateYear);
         * aceitem.setStartDate(startdate);
         *
         * dateMonth = ParamUtil.getInteger(request, "endDateMonth"); dateDay =
         * ParamUtil.getInteger(request, "endDateDay"); dateYear =
         * ParamUtil.getInteger(request, "endDateYear"); Date enddate =
         * PortalUtil.getDate(dateMonth, dateDay, dateYear);
         * aceitem.setEndDate(enddate);
         *
         * dateMonth = ParamUtil.getInteger(request, "publicationDateMonth");
         * dateDay = ParamUtil.getInteger(request, "publicationDateDay");
         * dateYear = ParamUtil.getInteger(request, "publicationDateYear"); Date
         * publicationdate = PortalUtil.getDate(dateMonth, dateDay, dateYear);
         * aceitem.setEndDate(publicationdate);
         */
        String importance = ParamUtil.getString(request, "chk_importance");

        if (aceitem.getImportance() == 1) {
            aceitem.setImportance(aceitem.getImportance() - 1);
            aceitem.setRating(aceitem.getRating() - 100);
        }

        if (importance != null && importance.equalsIgnoreCase("1")) {
            aceitem.setImportance(aceitem.getImportance() + 1);
            aceitem.setRating(aceitem.getRating() + 100);
        }

        String approved = ParamUtil.getString(request, "chk_controlstatus");
        if ((approved == null) || (approved.length() == 0)) {
            aceitem.setControlstatus((short) -1);
        } else {
            aceitem.setControlstatus(Short.parseShort(approved));
        }

        aceitem.setCreationdate(new Date());
        
        String choosenGeoChars = ParamUtil.getString(request, "rad_geo_chars");
        aceitem.setGeochars(choosenGeoChars);
        
        if (Validator.isNotNull(ParamUtil.getString(request, "feature")))
        {
        	aceitem.setFeature(ParamUtil.getString(request, "feature"));
        }

        return aceitem;
    }

    protected void sendSubmitNotification(AceItem aceitem) {

        if (aceitem.getControlstatus() == ACEIndexUtil.Status_SUBMITTED) {
            try {
                InternetAddress fromInternetAddress = new InternetAddress(ACEIndexUtil.retrieveNotificationFromAddress());
                String notificationaddresslist = ACEIndexUtil.retrieveNotificationToAddressList();

                String[] notificationaddresses = notificationaddresslist.split(";");
                InternetAddress[] toInternetAddresses = new InternetAddress[notificationaddresses.length];
                for (int i = 0; i < notificationaddresses.length; i++) {
                    if (notificationaddresses[i].trim().length() > 0) {
                        toInternetAddresses[i] = new InternetAddress(notificationaddresses[i]);
                    }
                }

                String hosturl = ACEIndexUtil.retrieveNotificationHostUrl();

                String subject = "Climate-adapt: A database item is waiting for approval";
                String body = "Please have a look at the submitted ";

                if (aceitem.getDatatype().equalsIgnoreCase(AceItemType.DOCUMENT.toString())) {
                    body += "publication / report ";
                } else if (aceitem.getDatatype().equalsIgnoreCase(AceItemType.INFORMATIONSOURCE.toString())) {
                    body += "information portal ";
                } else if (aceitem.getDatatype().equalsIgnoreCase(AceItemType.GUIDANCE.toString())) {
                    body += "guidance document ";
                } else if (aceitem.getDatatype().equalsIgnoreCase(AceItemType.TOOL.toString())) {
                    body += "tool ";
                } else if (aceitem.getDatatype().equalsIgnoreCase(AceItemType.ORGANISATION.toString())) {
                    body += "organisation ";
                }

                body += "at " + hosturl + "/viewaceitem?aceitem_id=" + aceitem.getAceItemId();
                body += "\nEditor: " + username;
                body += "\nEmail: " + useremail;

                MailEngine.send(fromInternetAddress, toInternetAddresses, null, null, subject, body, false, null, null, null);

                // send second email to contributor
                InternetAddress[] contributorAddress = new InternetAddress[1];
                contributorAddress[0] = new InternetAddress(useremail);
                subject = "Your submission to Climate-ADAPT";
                body = "You have successfully submitted information to Climate-ADAPT regarding '" + aceitem.getName() + "'.\n";
                body += "This material will be reviewed prior to publication.\n";
                body += "As long as the item has not been approved you can still make changes by going to:\n\n";
                body += hosturl + "/share-your-info/" ;
                if (aceitem.getDatatype().equalsIgnoreCase(AceItemType.DOCUMENT.toString())) {
                    body += "publications-and-reports";
                } else if (aceitem.getDatatype().equalsIgnoreCase(AceItemType.INFORMATIONSOURCE.toString())) {
                    body += "information-portals";
                } else if (aceitem.getDatatype().equalsIgnoreCase(AceItemType.GUIDANCE.toString())) {
                    body += "guidance-documents";
                } else if (aceitem.getDatatype().equalsIgnoreCase(AceItemType.TOOL.toString())) {
                    body += "tools";
                } else if (aceitem.getDatatype().equalsIgnoreCase(AceItemType.ORGANISATION.toString())) {
                    body += "organisations";
                }
                body += "?submissionid=" + aceitem.getAceItemId();
                body += "\n\nWe thank you for your interest in Climate-ADAPT.";
                MailEngine.send(fromInternetAddress, contributorAddress, null, null, subject, body, false, null, null, null);
            } catch (Exception e) {
                // do nothing
                System.out.println("Sending submit notification for database item failed.");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    /**
     * Sends e-mail notification to the editors of this aceitem, that it has
     * been approved.
     *
     * @param aceItem
     */
    protected void sendApprovalNotification(AceItem aceItem) {

        // Get the item's moderators, if there is none, then return as there is
        // nothing to do here.

        String moderatorStr = aceItem == null ? null : aceItem.getModerator();
        if (moderatorStr == null || moderatorStr.trim().isEmpty()) {
            return;
        }

        ArrayList<String> receivers = new ArrayList<String>();
        ArrayList<InternetAddress> toAddresses = new ArrayList<InternetAddress>();
        String[] moderators = moderatorStr.split(",");
        for (int i = 0; i < moderators.length; i++) {
            String moderator = moderators[i].trim();
            if (!moderator.isEmpty() && !moderator.startsWith(username)) {

                // A moderator is given by its full name + e-mail address
                // between "(" and ")".
                // However, some moderators are given by their screen-name only,
                // in which case we cannot obtain their e-mail,
                // because Liferay's user service enables to query users by
                // "companyid and screenname", and we don't know
                // the companyid here.

                int idx1 = moderator.indexOf('(');
                int idx2 = moderator.indexOf(')');
                String email = idx1 >= 0 && idx2 > idx1 + 1 ? moderator.substring(idx1 + 1, idx2).trim() : null;
                if (email != null && !email.isEmpty()) {
                    try {
                        toAddresses.add(new InternetAddress(email));
                        receivers.add(email);
                    } catch (AddressException e) {
                        // Don't add an invalid e-mail address.
                    }
                }
            }
        }

        // If no addressees could be found, no point in continuing.
        if (toAddresses.isEmpty()) {
            return;
        }

        String hosturl = ACEIndexUtil.retrieveNotificationHostUrl();
        InternetAddress fromAddress = null;
        try {
            fromAddress = new InternetAddress(ACEIndexUtil.retrieveNotificationFromAddress());
        } catch (AddressException e) {
            try {
                fromAddress = new InternetAddress("no-reply@eea.europa.eu");
            } catch (AddressException e1) {
                // We can be sure that our hard-coded default mail address is
                // correct.
            }
        }
        String subject = "Climate-adapt: a database item of yours has been approved";
        StringBuilder body = new StringBuilder();
        body.append("The following Climate-adapt database item has been approved by the following user:\n\n");
        body.append("Item: ").append(hosturl).append("/viewaceitem?aceitem_id=").append(aceItem.getAceItemId()).append("\n");
        body.append("User: ").append(username).append(" (").append(useremail).append(")");

        try {
            MailEngine.send(fromAddress, toAddresses.toArray(new InternetAddress[toAddresses.size()]), null, null, subject,
                    body.toString(), false, null, null, null);
        } catch (MailEngineException e) {
            e.printStackTrace();
        }
    }
}