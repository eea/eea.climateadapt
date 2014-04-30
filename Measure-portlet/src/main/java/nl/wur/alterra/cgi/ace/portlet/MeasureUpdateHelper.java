package nl.wur.alterra.cgi.ace.portlet;

import java.util.ArrayList;
import java.util.Date;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.mail.MailEngine;
import com.liferay.util.mail.MailEngineException;

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.Measure;
import nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact;
import nl.wur.alterra.cgi.ace.model.constants.AceItemCountry;
import nl.wur.alterra.cgi.ace.model.constants.AceItemElement;
import nl.wur.alterra.cgi.ace.model.constants.AceItemSector;
import nl.wur.alterra.cgi.ace.model.constants.AceItemType;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexSynchronizer;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexUtil;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.PortletRequest;

/**
 * Portlets that need to update measures and synchronize with AceItems extend
 * this class.
 *
 * @author hugo de groot
 */
public abstract class MeasureUpdateHelper extends MVCPortlet {

    private String username = "";
    private String useremail = "";

    /**
     * Convenience method to F I L L a Measure object out of the request. Used
     * by the Add / Edit methods.
     *
     */
    protected void measureFromRequest(PortletRequest request, Measure measure) throws Exception {

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        if (request.getRemoteUser() != null) {
            User user = UserServiceUtil.getUserById(Long.parseLong(request.getRemoteUser()));
            String moderator = measure.getModerator();

            username = user.getFullName();
            useremail = user.getEmailAddress();
            String newModerator = username + " (" + useremail + ")";

            if (moderator.indexOf(newModerator) == -1) {

                measure.setModerator(moderator + (moderator.length() == 0 ? "" : ", ") + newModerator);
            }
        }

        Date d = new Date();
        d.setTime(ParamUtil.getLong(request, "checkcreationdate"));
        measure.setLockdate(d); // hack optimistic locking!!! Check with
                                    // dbrecord in MeasureValidator

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

        String websites = ParamUtil.getString(request, "website");
        // robust multiple website handling. Check for splitters space, ',' and
        // ';'
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
        measure.setWebsite(websites);

        measure.setCostbenefit(ParamUtil.getString(request, "costbenefit"));
        measure.setKeywords(ParamUtil.getString(request, "keywords"));
        measure.setComments(ParamUtil.getString(request, "comments"));
        /*
         * int dateMonth = ParamUtil.getInteger(request, "startdateMonth"); int
         * dateDay = ParamUtil.getInteger(request, "startdateDay"); int dateYear
         * = ParamUtil.getInteger(request, "startdateYear"); Date startdate =
         * PortalUtil.getDate(dateMonth, dateDay, dateYear);
         * measure.setStartdate(startdate);
         *
         * dateMonth = ParamUtil.getInteger(request, "enddateMonth"); dateDay =
         * ParamUtil.getInteger(request, "enddateDay"); dateYear =
         * ParamUtil.getInteger(request, "enddateYear"); Date enddate =
         * PortalUtil.getDate(dateMonth, dateDay, dateYear);
         * measure.setEnddate(enddate);
         *
         * dateMonth = ParamUtil.getInteger(request, "publicationdateMonth");
         * dateDay = ParamUtil.getInteger(request, "publicationdateDay");
         * dateYear = ParamUtil.getInteger(request, "publicationdateYear"); Date
         * publicationdate = PortalUtil.getDate(dateMonth, dateDay, dateYear);
         * measure.setEndDate(publicationdate);
         */
        measure.setSpecialtagging(ParamUtil.getString(request, "specialtagging"));

        String choosencountries = "";
        for (AceItemCountry aceitemcountry : AceItemCountry.values()) {

            if (ParamUtil.getString(request, "chk_countries_" + aceitemcountry.toString()) != null) {
                String s = ParamUtil.getString(request, "chk_countries_" + aceitemcountry.toString());
                if (s.equalsIgnoreCase(aceitemcountry.toString())) {
                    choosencountries += aceitemcountry.toString() + ";";
                }
            }
        }
        measure.setSpatialvalues(choosencountries);
        // measure.setSpatialvalues(ParamUtil.getString(request,
        // "spatialvalues").replace("UK","GB"));

        String choosensectors = "";
        for (AceItemSector aceitemsector : AceItemSector.values()) {

            if (ParamUtil.getString(request, "chk_sectors_" + aceitemsector.toString()) != null) {
                String s = ParamUtil.getString(request, "chk_sectors_" + aceitemsector.toString());
                if (s.equalsIgnoreCase(aceitemsector.toString())) {
                    choosensectors += aceitemsector.toString() + ";";
                }
            }
        }
        measure.setSectors_(choosensectors);

        String choosenelements = "";
        for (AceItemElement aceitemelement : AceItemElement.values()) {
            if (ParamUtil.getString(request, "chk_elements_" + aceitemelement) != null) {
                String e = ParamUtil.getString(request, "chk_elements_" + aceitemelement);
                if (e.equalsIgnoreCase(aceitemelement.toString())) {
                    choosenelements += aceitemelement.toString() + ";";
                }
            }
        }
        measure.setElements_(choosenelements);

        String choosenclimateimpacts = "";
        for (AceItemClimateImpact aceitemclimateimpact : AceItemClimateImpact.values()) {
            if (ParamUtil.getString(request, "chk_climateimpacts_" + aceitemclimateimpact) != null) {
                String e = ParamUtil.getString(request, "chk_climateimpacts_" + aceitemclimateimpact);
                if (e.equalsIgnoreCase(aceitemclimateimpact.toString())) {
                    choosenclimateimpacts += aceitemclimateimpact.toString() + ";";
                }
            }
        }
        measure.setClimateimpacts_(choosenclimateimpacts);

        measure.setMao_type(ParamUtil.getString(request, "mao_type"));
        measure.setSource(ParamUtil.getString(request, "source"));

        String importance = ParamUtil.getString(request, "chk_importance");
        if (measure.getImportance() == 1) {
            measure.setImportance(measure.getImportance() - 1);
            measure.setRating(measure.getRating() - 100);

        }
        if (importance != null && importance.equalsIgnoreCase("1")) {
            measure.setImportance(measure.getImportance() + 1);
            measure.setRating(measure.getRating() + 100);
        }

        String approved = ParamUtil.getString(request, "chk_controlstatus");
        if ((approved == null) || (approved.length() == 0)) {
            measure.setControlstatus((short) 0);
        } else {
            measure.setControlstatus(Short.parseShort(approved));
        }

        if (ParamUtil.getString(request, "lon") != null) {
            try {
                measure.setLon(Double.parseDouble(ParamUtil.getString(request, "lon")));
            } catch (NumberFormatException e) {
                // do nothing
            }
        }

        if (ParamUtil.getString(request, "lat") != null) {
            try {
                measure.setLat(Double.parseDouble(ParamUtil.getString(request, "lat")));
            } catch (NumberFormatException e) {
                // do nothing
            }
        }

        measure.setSatarea(ParamUtil.getString(request, "satarea"));

        measure.setCreationdate(new Date());
    }

    private String coalesce(String aString) {
        String result = "";

        if (aString != null) {

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

        if (measure.getMao_type().indexOf("A") >= 0) {

            aceitem.setDatatype(AceItemType.ACTION.toString());
        } else {

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

        aceitem.setControlstatus(measure.getControlstatus());

        if (measure.getCreator() != null) {
            aceitem.setCreator(measure.getCreator());
        }

        if (measure.getCreationdate() != null) {
            aceitem.setCreationdate(measure.getCreationdate());
        }

        if (measure.getModerator() != null) {
            aceitem.setModerator(measure.getModerator());
        }

        if (measure.getApprovaldate() != null) {
            aceitem.setApprovaldate(measure.getApprovaldate());
        }

        aceitem.setTextSearch(measure.getSpecialtagging() + ' ' + aceitem.getName() + ' ' + measure.getDescription() + ' '
                + measure.getContact() + ' ' + measure.getKeywords() + ' ' + measure.getWebsite() + ' '
                + measure.getSpatiallayer().replace("_", "") + ' ' + measure.getSpatialvalues() + ' ' + measure.getLegalaspects()
                + ' ' + measure.getSucceslimitations() + ' ' + measure.getCostbenefit() + ' '
                + measure.getStakeholderparticipation() + ' ' + measure.getSource() + ' ' + measure.getTextwebpage());

/* At free text searxh don't search any longer on Advanced Search Fields
        String sctrs = measure.getSectors_();
        if ((coalesce(sctrs).length() > 0) && (sctrs.indexOf(";") == sctrs.lastIndexOf(";"))) { // one
                                                                                                // sector

            aceitem.setTextSearch(aceitem.getTextSearch() + ' ' + coalesce(sctrs.substring(0, sctrs.indexOf(";"))));
        }
        
        String lmnts = measure.getElements_();

        if ((coalesce(lmnts).length() > 0) && (lmnts.indexOf(";") == lmnts.lastIndexOf(";"))) { // one
                                                                                                // element

            aceitem.setTextSearch(aceitem.getTextSearch() + ' ' + coalesce(lmnts.substring(0, lmnts.indexOf(";"))));
        }

        String mpcts = measure.getClimateimpacts_();

        if ((coalesce(mpcts).length() > 0) && (mpcts.indexOf(";") == mpcts.lastIndexOf(";"))) { // one
                                                                                                // climate
                                                                                                // impact

            aceitem.setTextSearch(aceitem.getTextSearch() + ' ' + coalesce(mpcts.substring(0, mpcts.indexOf(";"))));
        }
*/
        AceItemLocalServiceUtil.updateAceItem(aceitem);

        new ACEIndexSynchronizer().reIndex(aceitem);
    }

    protected void sendSubmitNotification(Measure measure) {

        if (measure.getControlstatus() == ACEIndexUtil.Status_SUBMITTED) {
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

                String subject = "Climate-adapt: A measure is waiting for approval";
                String body = "Please have a look at the submitted ";

                if (measure.getMao_type().equalsIgnoreCase("A")) {
                    body += "case study ";
                } else {
                    body += "adaptation option ";
                }
                body += "at " + hosturl + "/viewmeasure?ace_measure_id=" + measure.getMeasureId();
                body += "\nEditor: " + username;
                body += "\nEmail: " + useremail;

                MailEngine.send(fromInternetAddress, toInternetAddresses, null, null, subject, body, false, null, null, null);

                // send second email to contributor
                InternetAddress[] contributorAddress = new InternetAddress[1];
                contributorAddress[0] = new InternetAddress(useremail);
                subject = "Your submission to Climate-ADAPT";
                body = "You have successfully submitted information to Climate-ADAPT regarding '" + measure.getName() + "'.\n";
                body += "This material will be reviewed prior to publication.\n";
                body += "As long as the item has not been approved you can still make changes by going to:\n\n";
                body += hosturl + "/share-your-info/" ;
                if (measure.getMao_type().equalsIgnoreCase("A")) {
                    body += "case-studies";
                } else {
                    body += "adaptation-options";
                }
                body += "?submissionid=" + measure.getMeasureId();
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
     * Sends e-mail notification to the editors of this measure, that it has been approved.
     * @param aceItem
     */
    protected void sendApprovalNotification(Measure measure) {

        // Get the item's moderators, if there is none, then return as there is
        // nothing to do here.

        String moderatorStr = measure == null ? null : measure.getModerator();
        if (moderatorStr == null || moderatorStr.trim().isEmpty()) {
            return;
        }

        ArrayList<String> receivers = new ArrayList<String>();
        ArrayList<InternetAddress> toAddresses = new ArrayList<InternetAddress>();
        String[] moderators = moderatorStr.split(",");
        for (int i = 0; i < moderators.length; i++) {
            String moderator = moderators[i].trim();
            if (!moderator.isEmpty() && !moderator.startsWith(username)) {

                // A moderator is given by its full name + e-mail address between "(" and ")".
                // However, some moderators are given by their screen-name only, in which case we cannot obtain their e-mail,
                // because Liferay's user service enables to query users by "companyid and screenname", and we don't know
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
        body.append("Item: ").append(hosturl).append("/viewmeasure?ace_measure_id=").append(measure.getMeasureId()).append("\n");
        body.append("User: ").append(username).append(" (").append(useremail).append(")");

        try {
            MailEngine.send(fromAddress, toAddresses.toArray(new InternetAddress[toAddresses.size()]), null, null, subject,
                    body.toString(), false, null, null, null);
        } catch (MailEngineException e) {
            e.printStackTrace();
        }
    }
}
