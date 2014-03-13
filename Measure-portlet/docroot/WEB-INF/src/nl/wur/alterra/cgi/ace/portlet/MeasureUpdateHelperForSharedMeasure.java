package nl.wur.alterra.cgi.ace.portlet;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.Measure;
import nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact;
import nl.wur.alterra.cgi.ace.model.constants.AceItemCountry;
import nl.wur.alterra.cgi.ace.model.constants.AceItemElement;
import nl.wur.alterra.cgi.ace.model.constants.AceItemGeos;
import nl.wur.alterra.cgi.ace.model.constants.AceItemRelevance;
import nl.wur.alterra.cgi.ace.model.constants.AceItemSector;
import nl.wur.alterra.cgi.ace.model.constants.AceItemType;
import nl.wur.alterra.cgi.ace.model.constants.MeasureCaseStudyFeature;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexSynchronizer;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexUtil;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;

//import com.liferay.documentlibrary.DuplicateFileException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ResourcePermissionServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
//import com.liferay.portlet.imagegallery.DuplicateImageNameException;
//import com.liferay.portlet.imagegallery.NoSuchFolderException;
//import com.liferay.portlet.imagegallery.model.IGFolder;
//import com.liferay.portlet.imagegallery.model.IGImage;
//import com.liferay.portlet.imagegallery.service.IGFolderLocalServiceUtil;
//import com.liferay.portlet.imagegallery.service.IGImageServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.mail.MailEngine;
import com.liferay.util.mail.MailEngineException;

/**
 * Portlets that need to update measures and synchronize with AceItems extend
 * this class.
 *
 * @author hugo de groot
 */
public abstract class MeasureUpdateHelperForSharedMeasure extends MVCPortlet {

    private String username = "";
    private String useremail = "";
    public static char[] INVALID_CHARACTERS = new char[] {
            '&', CharPool.APOSTROPHE, '@',
            '\\', ']', '}',
            ':', ',', '=', '>',
            '/', '<', '\n',
            '[', '{', '%',
            '|', '+', '#', '?',
            '\"', '\r', ';',
            '*', '~'
    };

    /**
     * Convenience method to F I L L a Measure object out of the request. Used
     * by the Add / Edit methods.
     *
     */
    protected void measureFromRequest(PortletRequest request, Measure measure, UploadPortletRequest req, List errors) throws Exception {

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);


        UploadPortletRequest uploadRequest;

        if (req == null)
        {
            uploadRequest = PortalUtil.getUploadPortletRequest(request);
        }
        else
        {
            uploadRequest = req;
        }

        //System.out.println("NAME IS MEASUREFROMREQUEST IS " + uploadRequest.getParameter("name"));
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

        if (uploadRequest.getParameter("checkcreationdate") != null)
        {
            d.setTime(Long.parseLong(uploadRequest.getParameter("checkcreationdate")));
        }
        else
        {
            d.setTime(0);
        }
        //d.setTime(ParamUtil.getLong(request, "checkcreationdate"));
        measure.setLockdate(d); // hack optimistic locking!!! Check with
        // dbrecord in MeasureValidator

        measure.setCompanyId(themeDisplay.getCompanyId());
        measure.setGroupId(themeDisplay.getScopeGroupId());

        measure.setName(uploadRequest.getParameter("name"));
        //System.out.println("uploadRequest parameter name is " + uploadRequest.getParameter("name"));
        //System.out.println("Name is " + measure.getName());
        measure.setAdmincomment(uploadRequest.getParameter( "admincomment"));
        measure.setDescription(uploadRequest.getParameter( "description"));
        //System.out.println("DESCRIPTION IS " + measure.getDescription());
        measure.setImplementationtype(uploadRequest.getParameter( "implementationtype"));
        measure.setImplementationtime(uploadRequest.getParameter( "implementationtime"));
        //System.out.println("Implementation time is " + measure.getImplementationtime());
        measure.setLifetime(uploadRequest.getParameter( "lifetime"));
        measure.setSpatiallayer(uploadRequest.getParameter( "spatiallayer"));
        measure.setLegalaspects(uploadRequest.getParameter( "legalaspects"));
        measure.setStakeholderparticipation(uploadRequest.getParameter( "stakeholderparticipation"));
        measure.setContact(uploadRequest.getParameter( "contact"));
        measure.setObjectives(uploadRequest.getParameter( "objectives"));
        measure.setChallenges(uploadRequest.getParameter( "challenges"));
        //System.out.println("CHALLENGES IS " + measure.getChallenges());
        measure.setSucceslimitations(uploadRequest.getParameter( "succeslimitations"));


        String websites = uploadRequest.getParameter( "website");
        // robust multiple website handling. Check for splitters space, ',' and
        // ';'
        if (websites != null) {
            websites = websites.replace(",", " ");
            websites = websites.replace(";", " ");
            websites = websites.replace("<p>", "");
            websites = websites.replace("</p>", "");
            websites = websites.replaceAll("http://", "");
            websites = websites.replaceAll("&nbsp;", "");
            websites = websites.replaceAll("&nbsp", "");
            websites = websites.replaceAll("[\r\n]", "");
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
                            websites += ";";
                        }
                    }
                }
            }
        }
        measure.setWebsite(websites);

        measure.setCostbenefit(uploadRequest.getParameter( "costbenefit"));
        measure.setKeywords(uploadRequest.getParameter( "keywords"));
        measure.setComments(uploadRequest.getParameter( "comments"));
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
        measure.setSpecialtagging(uploadRequest.getParameter( "specialtagging"));

        String choosencountries = "";
        for (AceItemCountry aceitemcountry : AceItemCountry.values()) {

            if (uploadRequest.getParameter( "chk_countries_" + aceitemcountry.toString()) != null) {
                String s = uploadRequest.getParameter( "chk_countries_" + aceitemcountry.toString());
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

            if (uploadRequest.getParameter( "chk_sectors_" + aceitemsector.toString()) != null) {
                String s = uploadRequest.getParameter( "chk_sectors_" + aceitemsector.toString());
                if (s.equalsIgnoreCase(aceitemsector.toString())) {
                    choosensectors += aceitemsector.toString() + ";";
                }
            }
        }
        measure.setSectors_(choosensectors);

        measure.setYear(uploadRequest.getParameter("year"));

        String choosenelements = "";
        for (AceItemElement aceitemelement : AceItemElement.values()) {
            if (uploadRequest.getParameter( "chk_elements_" + aceitemelement) != null) {
                String e = uploadRequest.getParameter( "chk_elements_" + aceitemelement);
                if (e.equalsIgnoreCase(aceitemelement.toString())) {
                    choosenelements += aceitemelement.toString() + ";";
                }
            }
        }
        measure.setElements_(choosenelements);

        // climate impacts - new
        String choosenclimateimpacts = "";
        for (AceItemClimateImpact aceitemclimateimpact : AceItemClimateImpact.values()) {
            if (uploadRequest.getParameter( "chk_climateimpacts_" + aceitemclimateimpact) != null) {
                String e = uploadRequest.getParameter( "chk_climateimpacts_" + aceitemclimateimpact);
                if (e.equalsIgnoreCase(aceitemclimateimpact.toString())) {
                    choosenclimateimpacts += aceitemclimateimpact.toString() + ";";
                }
            }
        }
        measure.setClimateimpacts_(choosenclimateimpacts);

        // case study feature - new 
        String choosenfeature = "";
        for (MeasureCaseStudyFeature feature : MeasureCaseStudyFeature.values()) {
            if (uploadRequest.getParameter( "chk_casestudyfeature_" + feature) != null) {
                String e = uploadRequest.getParameter( "chk_casestudyfeature_" + feature);
                if (e.equalsIgnoreCase(feature.toString())) {
                    choosenfeature += feature.toString() + ";";
                }
            }
        }
        measure.setCasestudyfeature(choosenfeature);

        String choosenoptions = uploadRequest.getParameter("chk_adaptoptions");
        measure.setAdaptationoptions(choosenoptions);

        measure.setMao_type(uploadRequest.getParameter( "mao_type"));

        String choosengeos = "";
        for (AceItemGeos geo : AceItemGeos.values())
        {
            //System.out.println("Geo is " + geo.toString());
            //System.out.println("Geo is " + geo.name());
            if (uploadRequest.getParameter( "chk_geos_trans") != null) {
                String e = uploadRequest.getParameter( "chk_geos_trans");
                if (measure.getMao_type().equalsIgnoreCase("A") && e.equalsIgnoreCase(geo.toString())) {
                    choosengeos = geo.toString();
                    break;
                }
            }
        }
        measure.setGeos_(choosengeos);

        if (uploadRequest.getParameter( "chk_geos_trans") != null && measure.getMao_type().equalsIgnoreCase("M"))
        {
            choosengeos = uploadRequest.getParameter("chk_geos_trans");
            measure.setGeos_(choosengeos);
        }

        String choosenGeoChars = uploadRequest.getParameter("rad_geo_chars");
        measure.setGeochars(choosenGeoChars);


        measure.setSolutions(uploadRequest.getParameter("solutions"));

        // adaptation relevance
        String choosenrelevance = "";
        for (AceItemRelevance relevance : AceItemRelevance.values()) {
            if (uploadRequest.getParameter( "chk_relevance_" + relevance) != null) {
                String e = uploadRequest.getParameter( "chk_relevance_" + relevance);
                if (e.equalsIgnoreCase(relevance.toString())) {
                    choosenrelevance += relevance.toString() + ";";
                }
            }
        }
        measure.setRelevance(choosenrelevance);


        measure.setSource(uploadRequest.getParameter( "source"));

        String importance = uploadRequest.getParameter( "chk_importance");
        if (measure.getImportance() == 1) {
            measure.setImportance(measure.getImportance() - 1);
            measure.setRating(measure.getRating() - 100);

        }
        if (importance != null && importance.equalsIgnoreCase("1")) {
            measure.setImportance(measure.getImportance() + 1);
            measure.setRating(measure.getRating() + 100);
        }

        String approved = uploadRequest.getParameter( "chk_controlstatus");
        //System.out.println("approved is " + approved);
        if ((approved == null) || (approved.length() == 0)) {
            measure.setControlstatus((short) -1);
        } else {
            measure.setControlstatus(Short.parseShort(approved));

            // set the approved date here
            if (measure.getControlstatus() == 1)
            {
                Date approvalDate = new Date();
                measure.setApprovaldate(approvalDate);
            }
        }



        if (uploadRequest.getParameter( "lon") != null) {
            try {
                measure.setLon(Double.parseDouble(uploadRequest.getParameter( "lon")));
            } catch (NumberFormatException e) {
                // do nothing

            }
        }

        if (uploadRequest.getParameter( "lat") != null) {
            try {
                measure.setLat(Double.parseDouble(uploadRequest.getParameter( "lat")));
            } catch (NumberFormatException e) {
                // do nothing

            }
        }

        if (Validator.isNotNull(uploadRequest.getParameter( "chk_categories"))) {
            measure.setCategory(uploadRequest.getParameter( "chk_categories"));
        }


        measure.setSatarea(uploadRequest.getParameter( "satarea"));

        if (Validator.isNull(measure.getCreationdate()))
        {
            // creation date is the time when case study is first saved
            measure.setCreationdate(new Date());
        }


        if (Validator.isNotNull(uploadRequest.getParameter("comments")))
        {
            measure.setComments(uploadRequest.getParameter("comments"));
        }

        //primary photo
        //UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
        ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
        String sourceFileName = uploadRequest.getFileName("primePhotoName");
        String primePhotoId = uploadRequest.getParameter( "primephoto");

        //System.out.println("sourceFileName is " + sourceFileName);
        //System.out.println("sourceFileName is not null" + Validator.isNotNull(sourceFileName));
        if (Validator.isNotNull(sourceFileName) && (sourceFileName.endsWith(".png") || sourceFileName.endsWith(".jpg") || sourceFileName.endsWith(".jpeg") || sourceFileName.endsWith(".png") ||
                sourceFileName.endsWith(".gif")))
        {
            FileEntry image;
            String extension ;

            int i = sourceFileName.lastIndexOf('.');
            extension = sourceFileName.substring(i+1);

            //System.out.println("Inside control");
            if (Validator.isNotNull(primePhotoId))
            {
                //System.out.println("primePhotoId is " + primePhotoId);
                image = DLAppLocalServiceUtil.getFileEntry( Long.parseLong( primePhotoId ) );
                long folderId = image.getFolderId();
                //System.out.println("image name is " + image.getNameWithExtension());
                if (! image.getTitle().equalsIgnoreCase(sourceFileName))
                {
                    try {
                        //looks like image replaced add the image now
                        File f = uploadRequest.getFile("primePhotoName");
                        DLAppLocalServiceUtil.addFileEntry( themeDisplay.getUserId(), image.getRepositoryId(), folderId, sourceFileName, "image/"+extension, null, "", "", f, serviceContext );

                        String primaryKey = String.valueOf(image.getPrimaryKey());
                        addPermissions(themeDisplay, primaryKey, "com.liferay.portal.kernel.repository.model.FileEntry");
                        measure.setPrimephoto(String.valueOf(image.getFileEntryId()));
                        request.setAttribute("primePhotoId", String.valueOf(image.getFileEntryId()));
                    }
//                    catch(DuplicateImageNameException e)
//                    {
//                        //get the image id
//                        //System.out.println("Duplicate image - getting image id");
//                        image = IGImageServiceUtil.getImageByFolderIdAndNameWithExtension(themeDisplay.getScopeGroupId(), folderId, sourceFileName);
//                        measure.setPrimephoto(String.valueOf(image.getImageId()));
//                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                        throw e;
                    }
                }

            }
            else
            {
                Folder imageFolder = null;
                try {
                    Folder rootFolder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, "casestudy");
                    File f = uploadRequest.getFile("primePhotoName");

                    // create case name folder
                    String folder = "case".concat("-").concat(String.valueOf(measure.getName().trim().replace(' ', '-')));
                    folder = escapeName(folder);
                    //System.out.println("folder name is " + folder);


                    try {
                        imageFolder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), rootFolder.getFolderId(), folder);
                    }
                    catch(PortalException e)
                    {
                        //System.out.println("image folder is null");
                        imageFolder = DLAppLocalServiceUtil.addFolder(themeDisplay.getUserId(),themeDisplay.getScopeGroupId(), rootFolder.getFolderId(), folder, "", serviceContext);
                        String primaryKey = String.valueOf(imageFolder.getPrimaryKey());
                        addPermissions(themeDisplay, primaryKey, "com.liferay.portal.kernel.repository.model.Folder");
                    }

                    image = DLAppLocalServiceUtil.addFileEntry( themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), imageFolder.getFolderId(), sourceFileName, "image/"+extension, null, "", "", f, serviceContext );
                    String primaryKey = String.valueOf(image.getPrimaryKey());
                    addPermissions(themeDisplay, primaryKey, "com.liferay.portal.kernel.repository.model.FileEntry");
                    measure.setPrimephoto(String.valueOf(image.getFileEntryId()));
                    //request.setAttribute("primePhotoId", String.valueOf(image.getImageId()));
                }
//                catch(DuplicateImageNameException e)
//                {
//                    //get the image id
//                    //System.out.println("Duplicate image - getting image id");
//                    image = IGImageServiceUtil.getImageByFolderIdAndNameWithExtension(themeDisplay.getScopeGroupId(), imageFolder.getFolderId(), sourceFileName);
//                    measure.setPrimephoto(String.valueOf(image.getImageId()));
//                }
                catch(Exception e)
                {
                    e.printStackTrace();
                    throw e;
                }
            }
            //System.out.println("image added image name is " + image.getNameWithExtension());
        }
        else
        {
            measure.setPrimephoto(primePhotoId);
        }

        //System.out.println("passing primary photo");


        // get how many photos are uploaded

        int photoCounter =  0;
        if (Validator.isNotNull(uploadRequest.getParameter("photocounter")))
        {
            photoCounter = Integer.parseInt(uploadRequest.getParameter("photocounter"));
        }

        boolean isPhotosValid = true;

        //System.out.println("photo counter is " + photoCounter);

        String supphotosStored = null;
        String[] supPhotoIdsStored = null;
        List<String> supPhotoListStored = null;

        if (photoCounter > 0)
        {
            if (Validator.isNotNull(uploadRequest.getParameter("supphotos")))
            {
                //System.out.println("supphotos is " + uploadRequest.getParameter("supphotos"));
                // split it
                supphotosStored = uploadRequest.getParameter("supphotos");
                supPhotoIdsStored = supphotosStored.split(";");
                supPhotoListStored = new LinkedList<String>();

                //populate the list with already loaded image names
                for (String photoId : supPhotoIdsStored)
                {
                    FileEntry image = DLAppLocalServiceUtil.getFileEntry( Long.parseLong( photoId ) );
                    String name = image.getTitle();
                    supPhotoListStored.add(name.toLowerCase());
                }
            }
        }

        //validate
        for(int counter=1; counter <= photoCounter; counter++)
        {
            String sup_photo_name = uploadRequest.getParameter("sup_photos_names" + counter);
            String sup_photo_description = uploadRequest.getParameter("sup_photos_description" + counter);
            String sup_photo_fileName = uploadRequest.getFileName("supphotofiles" + counter);

            // if (Validator.isNull(sup_photo_name) || Validator.isNull(sup_photo_description) || Validator.isNull(sup_photo_fileName))
            if (Validator.isNull(sup_photo_name) || Validator.isNull(sup_photo_fileName))
            {

                // before we declare invalid check it is just the document file missing and it was alreay uploaded
                if (Validator.isNotNull(sup_photo_fileName))
                {
                    //System.out.println("photo field missing");
                    isPhotosValid = false;
                    // add error message
                    errors.add("invalid-multiple-photo-upload");
                    SessionErrors.add(request, "invalid-multiple-photo-upload");
                    break;
                }
                else
                {
                    if (Validator.isNotNull(uploadRequest.getParameter("supphotos")))
                    {
                        // if (Validator.isNotNull(sup_photo_name) && Validator.isNotNull(sup_photo_description) && Validator.isNull(sup_photo_fileName) && supPhotoListStored.contains(sup_photo_name.toLowerCase()))
                        if (Validator.isNotNull(sup_photo_name) && Validator.isNull(sup_photo_fileName) && supPhotoListStored.contains(sup_photo_name.toLowerCase()))
                        {

                            //System.out.println("photo is already there so just skip");
                            continue;
                        }
                    }
                    else
                    {
                        isPhotosValid = false;

                        // if (counter > 1 || Validator.isNotNull(sup_photo_name) || Validator.isNotNull(sup_photo_description))
                        if (counter > 1 || Validator.isNotNull(sup_photo_name))
                        {
                            // add error message
                            errors.add("invalid-multiple-photo-upload");
                            SessionErrors.add(request, "invalid-multiple-photo-upload");
                        }
                        break;
                    }
                }
            }

            // check if the file name is jpg,jpeg,png,gif
            if (isPhotosValid && !(sup_photo_fileName.endsWith(".jpg") || sup_photo_fileName.endsWith(".jpeg") || sup_photo_fileName.endsWith(".png") ||
                    sup_photo_fileName.endsWith(".gif")))
            {
                isPhotosValid = false;
                // add error message
                errors.add("invalid-multiple-photo-upload");
                SessionErrors.add(request, "invalid-multiple-photo-upload");
                break;
            }
        }

        if (isPhotosValid && photoCounter > 0)
        {
            // now we have two options. if supphotos is not null then populate it in a data structure
            // iterate through the input fields and check the names already uploaded using supphotos
            // if names already uploaded then skip the image upload

            // get the root folder and form the folder for inserting images
            Folder rootFolder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, "casestudy");

            // create case name folder
            String folder = null;
            if (Validator.isNull(measure.getName()))
            {
                folder = "case".concat("-").concat("temp");
            }
            else
            {
                folder = "case".concat("-").concat(String.valueOf(measure.getName().trim().replace(' ', '-')));
            }

            folder = escapeName(folder);

            //System.out.println("folder name is " + folder);

            // try to see the folder exists otherwise add the folder to the root folder
            Folder imageFolder = null;

            try {
                imageFolder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), rootFolder.getFolderId(), folder);
            }
            catch(PortalException e)
            {
                //System.out.println("image folder is null");
                imageFolder = DLAppLocalServiceUtil.addFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), rootFolder.getFolderId(), folder, "", serviceContext);
                String primaryKey = String.valueOf(imageFolder.getPrimaryKey());
                addPermissions(themeDisplay, primaryKey, "com.liferay.portal.kernel.repository.model.FileEntry");
            }

            // we are ready to do the upload
            StringBuffer uploadedFiles = new StringBuffer("");

            if (Validator.isNotNull(uploadRequest.getParameter("supphotos")))
            {

                // iterate through each image and do the upload if the image already not uploaded
                for(int counter=1; counter <= photoCounter; counter++)
                {
                    String sup_photo_name = uploadRequest.getParameter("sup_photos_names" + counter);
                    String sup_photo_description = uploadRequest.getParameter("sup_photos_description" + counter);
                    String sup_photo_fileName = uploadRequest.getFileName("supphotofiles" + counter);

                    //check if the file has been already uploaded in the previous save

                    //System.out.println("supPhotoList stored is " + supPhotoListStored);
                    //System.out.println("sup_photo_name is " + sup_photo_name.toLowerCase());
                    if (supPhotoListStored.contains(sup_photo_name.toLowerCase()))
                    {
                        // get the index of the photo from the list
                        int index = supPhotoListStored.indexOf(sup_photo_name.toLowerCase());

                        //System.out.println("index is " + index);
                        if (uploadedFiles.toString().equalsIgnoreCase(""))
                        {
                            uploadedFiles.append(supPhotoIdsStored[index]);
                        }
                        else
                        {
                            uploadedFiles.append(";").append(supPhotoIdsStored[index]);
                        }
                    }
                    else
                    {
                        // upload the image
                        FileEntry image = insertImage(uploadRequest, counter, imageFolder, sup_photo_name, sup_photo_description, themeDisplay, serviceContext);


                        if (uploadedFiles.toString().equalsIgnoreCase(""))
                        {
                            uploadedFiles.append(image.getFileEntryId());
                        }
                        else
                        {
                            uploadedFiles.append(";").append(image.getFileEntryId());
                        }

                    }
                }
            }
            else
            {
                // first time we are uploading
                for(int counter=1; counter <= photoCounter; counter++)
                {
                    String sup_photo_name = uploadRequest.getParameter("sup_photos_names" + counter);
                    String sup_photo_description = uploadRequest.getParameter("sup_photos_description" + counter);
                    String sup_photo_fileName = uploadRequest.getFileName("supphotofiles" + counter);

                    FileEntry image = insertImage(uploadRequest, counter, imageFolder, sup_photo_name, sup_photo_description, themeDisplay, serviceContext);

                    if (image != null)
                    {
                        if (uploadedFiles.toString().equalsIgnoreCase(""))
                        {
                            uploadedFiles.append(image.getFileEntryId());
                        }
                        else
                        {
                            uploadedFiles.append(";").append(image.getFileEntryId());
                        }
                    }

                }
            }
            //System.out.println("uploaded files is " + uploadedFiles.toString());
            measure.setSupphotos(uploadedFiles.toString());
        }
        else
        {
            // preserve the old values
            if (photoCounter > 0)
            {
                measure.setSupphotos(uploadRequest.getParameter("supphotos"));
            }
            else
            {
                measure.setSupphotos("");
            }
        }


	    /* MULTIPLE DOC UPLOAD STARTS
	     * 
	     */

        // get how many documents are uploaded

        int docCounter =  0;
        if (Validator.isNotNull(uploadRequest.getParameter("doccounter")))
        {
            docCounter = Integer.parseInt(uploadRequest.getParameter("doccounter"));
        }

        boolean isDocsValid = true;

        //System.out.println("doc counter is " + docCounter);

        String supdocsStored = null;
        String[] supDocIdsStored = null;
        List<String> supDocListStored = null;

        if (docCounter > 0)
        {
            if (Validator.isNotNull(uploadRequest.getParameter("supdocs")))
            {
                //System.out.println("supdocs is " + uploadRequest.getParameter("supdocs"));
                // split it
                supdocsStored = uploadRequest.getParameter("supdocs");
                supDocIdsStored = supdocsStored.split(";");
                supDocListStored = new LinkedList<String>();

                //populate the list with already loaded document names
                for (String docId : supDocIdsStored)
                {
                    DLFileEntry file = DLFileEntryLocalServiceUtil.getDLFileEntry(Long.parseLong(docId));
                    String supFileName = file.getTitle();
                    supDocListStored.add(supFileName.toLowerCase());
                }
            }
        }

        //validate
        for(int counter=1; counter <= docCounter; counter++)
        {
            String sup_doc_name = uploadRequest.getParameter("sup_docs_names" + counter);
            String sup_doc_description = uploadRequest.getParameter("sup_docs_description" + counter);
            String sup_doc_fileName = uploadRequest.getFileName("supdocfiles" + counter);

            //System.out.println("name is " + sup_doc_name);
            //System.out.println("description is " + sup_doc_description);
            //System.out.println("filename is " + sup_doc_fileName);


            if (Validator.isNull(sup_doc_name) || Validator.isNull(sup_doc_description) || Validator.isNull(sup_doc_fileName))
            {

                // before we declare invalid check it is just the document file missing and it was alreay uploaded
                if (Validator.isNotNull(sup_doc_fileName))
                {
                    //System.out.println("document field missing");
                    isDocsValid = false;
                    // add error message
                    errors.add("invalid-multiple-doc-upload");
                    SessionErrors.add(request, "invalid-multiple-doc-upload");
                    break;
                }
                else
                {
                    if (Validator.isNotNull(uploadRequest.getParameter("supdocs")))
                    {
                        if (Validator.isNotNull(sup_doc_name) && Validator.isNotNull(sup_doc_description) && Validator.isNull(sup_doc_fileName) && supDocListStored.contains(sup_doc_name.toLowerCase()))
                        {

                            //System.out.println("document is already there so just skip");
                            continue;
                        }
                    }
                    else
                    {
                        isDocsValid = false;

                        if (counter > 1 || Validator.isNotNull(sup_doc_name) || Validator.isNotNull(sup_doc_description))
                        {
                            // add error message
                            errors.add("invalid-multiple-doc-upload");
                            SessionErrors.add(request, "invalid-multiple-doc-upload");
                        }
                        break;
                    }
                }
            }

            // check if the file name is pdf,doc,docx,xls
            if ( isDocsValid && !(sup_doc_fileName.endsWith(".pdf") || sup_doc_fileName.endsWith(".doc") || sup_doc_fileName.endsWith(".docx") ||
                    sup_doc_fileName.endsWith(".xls")))
            {
                isDocsValid = false;
                errors.add("invalid-multiple-doc-upload");
                SessionErrors.add(request, "invalid-multiple-doc-upload");
                break;
            }
        }

        if (isDocsValid && docCounter > 0)
        {
            // now we have two options. if docphotos is not null then populate it in a data structure
            // iterate through the input fields and check the names already uploaded using docphotos
            // if names already uploaded then skip the document upload

            // get the root folder and form the folder for inserting documents
            DLFolder rootFolder = null;
            try {
                rootFolder = DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, "casestudy");
            }
            catch(Exception e)
            {
                e.printStackTrace();
                throw e;
            }

            // create case name folder
            String folder = null;
            if (Validator.isNull(measure.getName()))
            {
                folder = "case".concat("-").concat("temp");
            }
            else
            {
                folder = "case".concat("-").concat(String.valueOf(measure.getName().trim().replace(' ', '-')));
            }
            folder = escapeName(folder);

            //System.out.println("folder name is " + folder);

            // try to see the folder exists otherwise add the folder to the root folder
            Folder docFolder = null;

            try {
                //docFolder = DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), rootFolder.getFolderId(), folder);
                docFolder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), rootFolder.getFolderId(), folder);
            }
            catch(PortalException e)
            {
                //System.out.println("document folder is null");
                try {
                    docFolder = DLAppLocalServiceUtil.addFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), rootFolder.getFolderId(), folder, "",  serviceContext);
                    String primaryKey = String.valueOf(docFolder.getPrimaryKey());
                    addPermissions(themeDisplay, primaryKey, "com.liferay.portal.kernel.repository.model.Folder");
                }
                catch(Exception ex)
                {
                    throw ex;
                }

            }
            catch(Exception e)
            {
                e.printStackTrace();
                throw e;
            }

            // we are ready to do the upload
            StringBuffer uploadedFiles = new StringBuffer("");

            if (Validator.isNotNull(uploadRequest.getParameter("supdocs")))
            {

                // iterate through each document and do the upload if the document already not uploaded
                for(int counter=1; counter <= docCounter; counter++)
                {
                    String sup_doc_name = uploadRequest.getParameter("sup_docs_names" + counter);
                    String sup_doc_description = uploadRequest.getParameter("sup_docs_description" + counter);
                    String sup_doc_fileName = uploadRequest.getFileName("supdocfiles" + counter);

                    //check if the file has been already uploaded in the previous save

                    //System.out.println("supDocList stored is " + supDocListStored);
                    //System.out.println("sup_doc_name is " + sup_doc_name.toLowerCase());

                    if (supDocListStored.contains(sup_doc_name.toLowerCase()))
                    {
                        // get the index of the photo from the list
                        int index = supDocListStored.indexOf(sup_doc_name.toLowerCase());

                        //System.out.println("index is " + index);
                        if (uploadedFiles.toString().equalsIgnoreCase(""))
                        {
                            uploadedFiles.append(supDocIdsStored[index]);
                        }
                        else
                        {
                            uploadedFiles.append(";").append(supDocIdsStored[index]);
                        }
                    }
                    else
                    {

                        // upload the file
                        FileEntry doc = insertFile(uploadRequest, counter, docFolder, sup_doc_name, sup_doc_description, themeDisplay, serviceContext);
                        //IGImage image = insertImage(uploadRequest, counter, imageFolder, sup_photo_name, sup_photo_description, themeDisplay, serviceContext);

                        if (uploadedFiles.toString().equalsIgnoreCase(""))
                        {
                            uploadedFiles.append(doc.getFileEntryId());
                        }
                        else
                        {
                            uploadedFiles.append(";").append(doc.getFileEntryId());
                        }

                    }
                }
            }
            else
            {
                // first time we are uploading
                for(int counter=1; counter <= docCounter; counter++)
                {
                    String sup_doc_name = uploadRequest.getParameter("sup_docs_names" + counter);
                    String sup_doc_description = uploadRequest.getParameter("sup_docs_description" + counter);
                    String sup_doc_fileName = uploadRequest.getFileName("supdocfiles" + counter);

                    //IGImage image = insertImage(uploadRequest, counter, imageFolder, sup_photo_name, sup_photo_description, themeDisplay, serviceContext);
                    FileEntry doc = insertFile(uploadRequest, counter, docFolder, sup_doc_name, sup_doc_description, themeDisplay, serviceContext);

                    if (doc != null)
                    {
                        if (uploadedFiles.toString().equalsIgnoreCase(""))
                        {
                            uploadedFiles.append(doc.getFileEntryId());
                        }
                        else
                        {
                            uploadedFiles.append(";").append(doc.getFileEntryId());
                        }
                    }
                }
            }
            //System.out.println("uploaded files is " + uploadedFiles.toString());
            measure.setSupdocs(uploadedFiles.toString());
        }
        else
        {
            // preserve the old values
            if (docCounter > 0)
            {
                measure.setSupdocs(uploadRequest.getParameter("supdocs"));
            }
            else
            {
                measure.setSupdocs("");
            }
        }

    }


    private FileEntry insertFile(UploadPortletRequest uploadRequest, int counter, Folder docFolder, String sup_doc_name, String sup_doc_description, ThemeDisplay themeDisplay, ServiceContext serviceContext)
            throws Exception
    {
        FileEntry doc = null;

        // upload the image
        try {
            File f = uploadRequest.getFile("supdocfiles" + counter);
            //System.out.println("inside method insertFile");
            String fileName = uploadRequest.getFileName("supdocfiles" + counter);
            //System.out.println("fileName is " + fileName);
            int i = fileName.lastIndexOf('.');
            String extension = fileName.substring(i+1);
            //System.out.println("extension is " + extension);
            //image = IGImageServiceUtil.addImage(themeDisplay.getScopeGroupId(), imageFolder.getFolderId(), sup_photo_name, sup_photo_description, f, "image/"+extension, serviceContext);

            doc = DLAppLocalServiceUtil.addFileEntry( themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), docFolder.getFolderId(), fileName,
                    "image/"+extension, sup_doc_name, sup_doc_description, "changeLog", f, serviceContext );
            String primaryKey = String.valueOf(doc.getPrimaryKey());
            addPermissions(themeDisplay, primaryKey, "com.liferay.portal.kernel.repository.model.FileEntry");
        }
//        catch(DuplicateFileException e)
//        {
//            //get the image id
//            //System.out.println("Duplicate file - getting file id");
//            try {
//
//                List<DLFileEntry> docs = DLFileEntryLocalServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), docFolder.getFolderId());
//                for (DLFileEntry storedDoc : docs)
//                {
//                    if (storedDoc.getTitle().equalsIgnoreCase(sup_doc_name))
//                    {
//                        //System.out.println("match occurred");
//                        doc = storedDoc;
//                        break;
//                    }
//                }
//                //image = IGImageServiceUtil.getImageByFolderIdAndNameWithExtension(themeDisplay.getScopeGroupId(), imageFolder.getFolderId(), fileName);
//                //System.out.println("stored doc name is " + doc.getTitle());
//            }
//            catch(Exception ex)
//            {
//                throw ex;
//            }
//        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }

        return doc;


    }


    /**
     * Helper method to insert multiple images
     * @param uploadRequest - UploadPortalRequest object
     * @param counter - counter which tracks the position of the image being uploaded
     * @param imageFolder - the image folder where the image is uploaded to
     * @param sup_photo_name - the name of the image
     * @param themeDisplay - the Liferay ThemeDisplay object
     * @param serviceContext - the Liferay ServiceContext object
     * @return
     * @throws Exception
     */
    private FileEntry insertImage(UploadPortletRequest uploadRequest, int counter, Folder imageFolder, String sup_photo_name, String sup_photo_description, ThemeDisplay themeDisplay, ServiceContext serviceContext)
            throws Exception
    {
        FileEntry image = null;
        // upload the image
        try {
            File f = uploadRequest.getFile("supphotofiles" + counter);
            //System.out.println("inside method insertImage");
            String fileName = uploadRequest.getFileName("supphotofiles" + counter);
            //System.out.println("fileName is " + fileName);
            int i = fileName.lastIndexOf('.');
            String extension = fileName.substring(i+1);
            //System.out.println("extension is " + extension);
            image = DLAppLocalServiceUtil.addFileEntry( themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), imageFolder.getFolderId(), fileName,
                    "image/"+extension, sup_photo_name, sup_photo_description, "changeLog", f, serviceContext );


            String primaryKey = String.valueOf(image.getPrimaryKey());
            addPermissions(themeDisplay, primaryKey, "com.liferay.portal.kernel.repository.model.FileEntry");
        }
//        catch(DuplicateImageNameException e)
//        {
//            //get the image id
//            //System.out.println("Duplicate image - getting image id");
//            try {
//
//                List<IGImage> images = IGImageServiceUtil.getImages(themeDisplay.getScopeGroupId(), imageFolder.getFolderId());
//                for (IGImage storedImage : images)
//                {
//                    if (storedImage.getName().equalsIgnoreCase(sup_photo_name))
//                    {
//                        //System.out.println("match occurred");
//                        image = storedImage;
//                        break;
//                    }
//                }
//                //image = IGImageServiceUtil.getImageByFolderIdAndNameWithExtension(themeDisplay.getScopeGroupId(), imageFolder.getFolderId(), fileName);
//                //System.out.println("image name is " + image.getName());
//            }
//            catch(Exception ex)
//            {
//                throw ex;
//            }
//        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }

        return image;
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

        aceitem.setFeature(measure.getCasestudyfeature());

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

        if (measure.getYear() != null) {
            aceitem.setYear(measure.getYear());
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
                //System.out.println("Sending submit notification for database item failed.");
                //System.out.println(e.getMessage());
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

    private void addPermissions(ThemeDisplay themeDisplay, String primaryKey, String resource ) throws Exception
    {
        Role roleUser = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.SITE_MEMBER);
        long roleId = roleUser.getRoleId();

        String actionIds[] = {"VIEW"};

        // View permissions to the Community Member
        ResourcePermissionServiceUtil.setIndividualResourcePermissions(
                themeDisplay.getScopeGroupId(), themeDisplay.getCompanyId(),
                resource, primaryKey, roleId, actionIds);

        // View permissions to the Guest
        roleUser = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.GUEST);
        roleId = roleUser.getRoleId();
        ResourcePermissionServiceUtil.setIndividualResourcePermissions(
                themeDisplay.getScopeGroupId(), themeDisplay.getCompanyId(),
                resource, primaryKey, roleId, actionIds);
    }

    public static String escapeName(String word) {
        if (word == null) {
            return null;
        }
        else {
            char[] wordCharArray = word.toCharArray();

            int i = 0;
            for (char c : wordCharArray) {
                for (char invalidChar : INVALID_CHARACTERS) {
                    //System.out.println("char is " + invalidChar);
                    if (c == invalidChar) {
                        wordCharArray[i] = '-';
                    }
                }
                i++;
            }

            String retString = new String(wordCharArray);

            if (retString.length() >= 75)
            {
                retString = retString.substring(0, 75);
            }
            return new String(wordCharArray);
        }

    }

}