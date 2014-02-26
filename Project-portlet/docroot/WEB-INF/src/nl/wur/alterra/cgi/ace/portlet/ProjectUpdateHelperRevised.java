package nl.wur.alterra.cgi.ace.portlet;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.liferay.documentlibrary.DuplicateFileException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.ParamUtil;
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
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.mail.MailEngine;
import com.liferay.util.mail.MailEngineException;

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.Project;
import nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact;
import nl.wur.alterra.cgi.ace.model.constants.AceItemCountry;
import nl.wur.alterra.cgi.ace.model.constants.AceItemElement;
import nl.wur.alterra.cgi.ace.model.constants.AceItemSector;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexSynchronizer;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexUtil;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.PortletRequest;

/**
 * Portlets that need to update projects and synchronize with AceItems extend
 * this class.
 *
 * @author hugo de groot
 */
public abstract class ProjectUpdateHelperRevised extends MVCPortlet {

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
     * Convenience method to F I L L a Project object out of the request. Used
     * by the Add / Edit methods.
     *
     */
    protected Project projectFromRequest(PortletRequest request, Project project, UploadPortletRequest ureq, List errors) throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        
        UploadPortletRequest uploadRequest;
        if (ureq == null)
        {
           uploadRequest = PortalUtil.getUploadPortletRequest(request);
        }
        else
        {
        	uploadRequest = ureq;
        }

        if (request.getRemoteUser() != null) {
            User user = UserServiceUtil.getUserById(Long.parseLong(request.getRemoteUser()));
            String moderator = project.getModerator();

            username = user.getFullName();
            useremail = user.getEmailAddress();
            String newModerator = username + " (" + useremail + ")";

            if (moderator.indexOf(newModerator) == -1) {

                project.setModerator(moderator + (moderator.length() == 0 ? "" : ", ") + newModerator);
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
        project.setLockdate(d); // hack optimistic locking!!! Check with
                                    // dbrecord in ProjectValidator

        project.setAcronym(ParamUtil.getString(uploadRequest, "acronym"));
        project.setTitle(ParamUtil.getString(uploadRequest, "title"));
        project.setAdmincomment(ParamUtil.getString(uploadRequest, "admincomment"));
        /*
         * int dateMonth = ParamUtil.getInteger(request, "startdateMonth"); int
         * dateDay = ParamUtil.getInteger(request, "startdateDay"); int dateYear
         * = ParamUtil.getInteger(request, "startdateYear"); Date startdate =
         * PortalUtil.getDate(dateMonth, dateDay, dateYear);
         * project.setStartdate(startdate);
         *
         * dateMonth = ParamUtil.getInteger(request, "enddateMonth"); dateDay =
         * ParamUtil.getInteger(request, "enddateDay"); dateYear =
         * ParamUtil.getInteger(request, "enddateYear"); Date enddate =
         * PortalUtil.getDate(dateMonth, dateDay, dateYear);
         * project.setEnddate(enddate);
         */
        project.setLead(ParamUtil.getString(uploadRequest, "lead"));
        project.setPartners(ParamUtil.getString(uploadRequest, "partners"));
        project.setFunding(ParamUtil.getString(uploadRequest, "funding"));

        String choosencountries = "";
        for (AceItemCountry aceitemcountry : AceItemCountry.values()) {

            if (ParamUtil.getString(uploadRequest, "chk_countries_" + aceitemcountry.toString()) != null) {
                String s = ParamUtil.getString(uploadRequest, "chk_countries_" + aceitemcountry.toString());
                if (s.equalsIgnoreCase(aceitemcountry.toString())) {
                    choosencountries += aceitemcountry.toString() + ";";
                }
            }
        }
        project.setSpatialvalues(choosencountries);
        // project.setSpatialvalues(ParamUtil.getString(request,
        // "spatialvalues").replace("UK","GB"));

        String choosensectors = "";
        for (AceItemSector aceitemsector : AceItemSector.values()) {

            if (ParamUtil.getString(uploadRequest, "chk_sectors_" + aceitemsector.toString()) != null) {
                String s = ParamUtil.getString(uploadRequest, "chk_sectors_" + aceitemsector.toString());
                if (s.equalsIgnoreCase(aceitemsector.toString())) {
                    choosensectors += aceitemsector.toString() + ";";
                }
            }
        }
        project.setSectors(choosensectors);

        project.setSpatiallayer(ParamUtil.getString(uploadRequest, "spatiallayer"));
        project.setAbstracts(ParamUtil.getString(uploadRequest, "abstracts"));
        project.setComments(ParamUtil.getString(uploadRequest, "comments"));

        String choosenelements = "";
        for (AceItemElement aceitemelement : AceItemElement.values()) {
            if (ParamUtil.getString(uploadRequest, "chk_elements_" + aceitemelement) != null) {
                String e = ParamUtil.getString(uploadRequest, "chk_elements_" + aceitemelement);
                if (e.equalsIgnoreCase(aceitemelement.toString())) {
                    choosenelements += aceitemelement.toString() + ";";
                }
            }
        }
        project.setElement(choosenelements);

        String choosenclimateimpacts = "";
        for (AceItemClimateImpact aceitemclimateimpact : AceItemClimateImpact.values()) {
            if (ParamUtil.getString(request, "chk_climateimpacts_" + aceitemclimateimpact) != null) {
                String e = ParamUtil.getString(uploadRequest, "chk_climateimpacts_" + aceitemclimateimpact);
                if (e.equalsIgnoreCase(aceitemclimateimpact.toString())) {
                    choosenclimateimpacts += aceitemclimateimpact.toString() + ";";
                }
            }
        }
        project.setClimateimpacts(choosenclimateimpacts);

        String websites = ParamUtil.getString(uploadRequest, "website");
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
        project.setWebsite(websites);

        project.setKeywords(ParamUtil.getString(uploadRequest, "keywords"));
        project.setDuration(ParamUtil.getString(uploadRequest, "duration"));
        project.setSpecialtagging(ParamUtil.getString(uploadRequest, "specialtagging"));
        project.setSource(ParamUtil.getString(uploadRequest, "source"));

        String importance = ParamUtil.getString(request, "chk_importance");
        if (project.getImportance() == 1) {
            project.setImportance(project.getImportance() - 1);
            project.setRating(project.getRating() - 100);

        }
        if (importance != null && importance.equalsIgnoreCase("1")) {
            project.setImportance(project.getImportance() + 1);
            project.setRating(project.getRating() + 100);
        }

        String approved = ParamUtil.getString(uploadRequest, "chk_controlstatus");
        if ((approved == null) || (approved.length() == 0)) {
            project.setControlstatus((short) -1);
        } else {
            project.setControlstatus(Short.parseShort(approved));
            // set the approved date here
            if (project.getControlstatus() == 1)
            {
            	 Date approvalDate = new Date();
            	 project.setApprovaldate(approvalDate);
            }
        }

        project.setCompanyId(themeDisplay.getCompanyId());
        project.setGroupId(themeDisplay.getScopeGroupId());

        if (Validator.isNull(project.getCreationdate()))
        {
        	// creation date is the time when case study is first saved
        	project.setCreationdate(new Date());
        }
        
        String choosenGeoChars = ParamUtil.getString(uploadRequest, "rad_geo_chars");
        project.setGeochars(choosenGeoChars);
        
        if (Validator.isNotNull(ParamUtil.getString(uploadRequest, "feature")))
        {
        	project.setFeature(ParamUtil.getString(uploadRequest, "feature"));
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
	    ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
	    
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
	    	      rootFolder = DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, "aceitem");
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    		throw e;
	    	}
	    	    	
	    	// create case name folder
	    	String folder = null;
	    	if (Validator.isNull(project.getTitle()))
	    	{
	    		folder = "aceitem".concat("-").concat("temp");
	    	}
	    	else
	    	{
	    	   folder = "aceitem".concat("-").concat(String.valueOf(project.getTitle().trim().replace(' ', '-')));
	    	}
	    	folder = escapeName(folder);
	    	
	    	//System.out.println("folder name is " + folder);
	    	
	    	// try to see the folder exists otherwise add the folder to the root folder
	    	DLFolder docFolder = null;
	    	
	    	try {
	    	    docFolder = DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), rootFolder.getFolderId(), folder);
	    	}
	    	catch(com.liferay.portlet.documentlibrary.NoSuchFolderException e)
	    	{
	    		//System.out.println("document folder is null");
	    		try {
	    		docFolder = DLFolderLocalServiceUtil.addFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), rootFolder.getFolderId(), folder, "", serviceContext);
	    		String primaryKey = String.valueOf(docFolder.getPrimaryKey());
	    		addPermissions(themeDisplay, primaryKey, "com.liferay.portlet.documentlibrary.model.DLFolder");
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
	    		    		DLFileEntry doc = insertFile(uploadRequest, counter, docFolder, sup_doc_name, sup_doc_description, themeDisplay, serviceContext);
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
	    		    	DLFileEntry doc = insertFile(uploadRequest, counter, docFolder, sup_doc_name, sup_doc_description, themeDisplay, serviceContext);

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
	    	project.setSupdocs(uploadedFiles.toString());
	    }
	    else
	    {
	    	// preserve the old values
	    	if (docCounter > 0)
	    	{
	    	   project.setSupdocs(uploadRequest.getParameter("supdocs"));
	    	}
	    	else
	    	{
	    		project.setSupdocs("");
	    	}
	    }
        
        return project;
    }
    
	private DLFileEntry insertFile(UploadPortletRequest uploadRequest, int counter, DLFolder docFolder, String sup_doc_name, String sup_doc_description, ThemeDisplay themeDisplay, ServiceContext serviceContext) 
		            throws Exception
		{
		DLFileEntry doc = null;
		
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
		doc = DLFileEntryLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), docFolder.getFolderId(), f.getName(), sup_doc_name,
		       sup_doc_description, null, null,  f, serviceContext);
		String primaryKey = String.valueOf(doc.getPrimaryKey());
		   addPermissions(themeDisplay, primaryKey, "com.liferay.portlet.documentlibrary.model.DLFileEntry");
		}
		catch(DuplicateFileException e)
		{
		    //get the image id
			   //System.out.println("Duplicate file - getting file id");
			   try {
				   
		        List<DLFileEntry> docs = DLFileEntryLocalServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), docFolder.getFolderId());
		        for (DLFileEntry storedDoc : docs)
		        {
		     	   if (storedDoc.getTitle().equalsIgnoreCase(sup_doc_name))
		     	   {
		     		   //System.out.println("match occurred");
		     		   doc = storedDoc;
		     		   break;
		     	   }
		        }
			       //image = IGImageServiceUtil.getImageByFolderIdAndNameWithExtension(themeDisplay.getScopeGroupId(), imageFolder.getFolderId(), fileName);
			       //System.out.println("stored doc name is " + doc.getTitle());
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
		
		return doc;
	}



    private String coalesce(String aString) {
        String result = "";

        if (aString != null) {

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
        
        aceitem.setFeature(project.getFeature());

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

        aceitem.setTextSearch(project.getSpecialtagging() + ' ' + aceitem.getName() + ' ' + project.getTitle() + ' '
                + project.getLead() + ' ' + project.getPartners() + ' ' + project.getFunding() + ' '
                + project.getSpatiallayer().replace("_", "") + ' ' + project.getSpatialvalues() + ' ' + project.getAbstracts()
                + ' ' + project.getKeywords() + ' ' + project.getSource() + ' ' + project.getSpatialvalues() + ' '
                + project.getTextwebpage());

/* At free text searxh don't search any longer on Advanced Search Fields
        String sctrs = project.getSectors();

        if ((coalesce(sctrs).length() > 0) && (sctrs.indexOf(";") == sctrs.lastIndexOf(";"))) { // one
                                                                                                // sector

            aceitem.setTextSearch(aceitem.getTextSearch() + ' ' + coalesce(sctrs.substring(0, sctrs.indexOf(";"))));
        }
        String lmnt = project.getElement();

        if ((coalesce(lmnt).length() > 0) && (lmnt.indexOf(";") == lmnt.lastIndexOf(";"))) { // one
                                                                                                // element

            aceitem.setTextSearch(aceitem.getTextSearch() + ' ' + coalesce(lmnt.substring(0, lmnt.indexOf(";"))));
        }

        String mpcts = project.getClimateimpacts();

        if ((coalesce(mpcts).length() > 0) && (mpcts.indexOf(";") == mpcts.lastIndexOf(";"))) { // one
                                                                                                // climate
                                                                                                // impact

            aceitem.setTextSearch(aceitem.getTextSearch() + ' ' + coalesce(mpcts.substring(0, mpcts.indexOf(";"))));
        }
*/        
        AceItemLocalServiceUtil.updateAceItem(aceitem);

        new ACEIndexSynchronizer().reIndex(aceitem);
    }

    protected void sendSubmitNotification(Project project) {

        if (project.getControlstatus() == ACEIndexUtil.Status_SUBMITTED) {
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

                String subject = "Climate-adapt: A project is waiting for approval";
                String body = "Please have a look at the submitted ";
                body += "project at " + hosturl + "/projects1?ace_project_id=" + project.getProjectId();
                body += "\nEditor: " + username;
                body += "\nEmail: " + useremail;

                MailEngine.send(fromInternetAddress, toInternetAddresses, null, null, subject, body, false, null, null, null);

                // send second email to contributor
                InternetAddress[] contributorAddress = new InternetAddress[1];
                contributorAddress[0] = new InternetAddress(useremail);
                subject = "Your submission to Climate-ADAPT";
                body = "You have successfully submitted information to Climate-ADAPT regarding '" + project.getAcronym() + "'.\n";
                body += "This material will be reviewed prior to publication.\n";
                body += "As long as the item has not been approved you can still make changes by going to:\n\n";
                body += hosturl + "/share-your-info/research-and-knowledge-projects?submissionid=" + project.getProjectId();
                body += "\n\nWe thank you for your interest in Climate-ADAPT.";
                MailEngine.send(fromInternetAddress, contributorAddress, null, null, subject, body, false, null, null, null);
            } catch (Exception e) {
                // do nothing
                System.out.println("Sending submit notification for project failed.");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    /**
     * Sends e-mail notification to the editors of this project, that it has been approved.
     *
     * @param aceItem
     */
    protected void sendApprovalNotification(Project project) {

        // Get the item's moderators, if there is none, then return as there is
        // nothing to do here.

        String moderatorStr = project == null ? null : project.getModerator();
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
        body.append("Item: ").append(hosturl).append("/projects1?ace_project_id=").append(project.getProjectId()).append("\n");
        body.append("User: ").append(username).append(" (").append(useremail).append(")");

        try {
            MailEngine.send(fromAddress, toAddresses.toArray(new InternetAddress[toAddresses.size()]), null, null, subject,
                    body.toString(), false, null, null, null);
        } catch (MailEngineException e) {
            e.printStackTrace();
        }
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
    
    private void addPermissions(ThemeDisplay themeDisplay, String primaryKey, String resource ) throws Exception
    {
    	Role roleUser = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.COMMUNITY_MEMBER);
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
    
}
