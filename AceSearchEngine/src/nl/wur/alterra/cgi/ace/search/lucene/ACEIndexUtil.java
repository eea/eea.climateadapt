package nl.wur.alterra.cgi.ace.search.lucene;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.CodeSource;
import java.util.Properties;

/**
 * Utility methods for Lucene index in ACE.
 *
 * @author jose garcia / hugo de Groot
 */
public class ACEIndexUtil {
	private static String indexFolderPath = "";
	
	private static int descriptionLength = 154;

	private static String notificationHostUrl = "";

	private static String notificationFromAddress = "";

	private static String notificationToAddressList = "";

	public static final short Status_SUBMITTED = 0; 
	
	public static final short Status_DRAFT = -1;
	
	public static final short Status_APPROVED = 1;
	
	/**
	 * Reads the index folder from a properties file (if exists), otherwise works as before using relative paths
	 *
	 * Create a file aceindex.properties in the same folder of AceSearchengine.jar with this property:
	 *
	 *		index.path=PATH_TO_INDEX
	 *
	 */
	static {
		Properties properties = new Properties();
		FileInputStream fis = null;
		
		try {
			// Use the jar file path to find the properties file
			String path = getJarFolder();
   			System.out.println("---> getJarFolder: "+ path);						

			fis = new FileInputStream
   				(new File( path + "/aceindex.properties"));
			
			properties.load(fis);

			indexFolderPath = properties.getProperty("index.path", "");
			
			notificationHostUrl = properties.getProperty("notification.host.url", "");
			
			notificationFromAddress = properties.getProperty("notification.from.address", "");
			
			notificationToAddressList = properties.getProperty("notification.to.address.list", "");

			try {
				descriptionLength = Integer.parseInt(properties.getProperty("totaldescription.length", "154")) ;
			}
			catch (Exception e) {
				descriptionLength = 154;
			}

			// Adds final File.separator
			if (!indexFolderPath.equals("")) {
				if (!indexFolderPath.endsWith(File.separator)) indexFolderPath += File.separator;
			}
			
			System.out.println("---> Index folder path: "+ indexFolderPath);	
			
		} catch (Exception e) {
			// Log error	
			indexFolderPath = "";
			System.out.println("---> Index folder path: "+ indexFolderPath);	
		
		} finally {
			if (fis != null) try { fis.close(); } catch (IOException e) { } 
		}
	}
	
	/**
	 * Reads the index folder from a properties file (if exists)
	 *
	 * Create a file aceindex.properties in the same folder of AceSearchengine.jar with this property:
	 *
	 *		index.path=PATH
	 *
	 * @return Lucene index folder
	 */
	public static String retrieveIndexFolder() {
		System.out.println("---> retrieveIndexFolder: "+ indexFolderPath);
		return indexFolderPath;	
	}
	
	/**
	 * Reads the description Length from a properties file (if exists)
	 *
	 * @return description Length
	 */
	public static int retrieveTotalDescriptionLength() {
		return descriptionLength;	
	}	
	
	/**
	 * Reads the notificationHostUrl from a properties file (if exists)
	 *
	 * @return notificationHostUrl
	 */
	public static String retrieveNotificationHostUrl() {
		return notificationHostUrl;	
	}	
	
	/**
	 * Reads the notificationHostUrl from a properties file (if exists)

	 *
	 * @return description Length
	 */
	public static String retrieveNotificationFromAddress() {
		return notificationFromAddress;	
	}	
	
	/**
	 * Reads the description Length from a properties file (if exists)
	 *
	 * @return description Length
	 */
	
	public static String retrieveNotificationToAddressList() {
		return notificationToAddressList;	
	}
	
	/**
	 * Retrieves the folder path for the jar file containing the class
	 *
	 * @return Path for the jar file containing the class
	 */
	private static String getJarFolder() throws Exception {
		ACEIndexUtil a = new ACEIndexUtil();
		
		CodeSource codeSource = a.getClass().getProtectionDomain().getCodeSource();
    	File jarFile = new File(codeSource.getLocation().toURI().getPath());
    	String jarDir = jarFile.getParentFile().getPath();
    	
		System.out.println("---> getJarFolder: "+ jarDir);	
		return jarDir;
  }
  
}