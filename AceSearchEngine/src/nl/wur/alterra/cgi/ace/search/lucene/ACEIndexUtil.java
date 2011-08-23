package nl.wur.alterra.cgi.ace.search.lucene;

import java.util.Properties;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;

/**
 * Utility methods for Lucene index in ACE.
 *
 * @author jose garcia
 */
public class ACEIndexUtil {
	private static String indexFolderPath = "";
	
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
			
			// Adds final File.separator
			if (!indexFolderPath.equals("")) {
				if (!indexFolderPath.endsWith(File.separator)) indexFolderPath += File.separator;
			}
			
			System.out.println("---> Index folder path: "+ indexFolderPath);	
			
		} catch (IOException e) {
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
	 * Retrieves the folder path for the jar file containing the class
	 *
	 * @return Path for the jar file containing the class
	 */
	private static String getJarFolder() {
		// get name and path
		ACEIndexUtil a = new ACEIndexUtil();
		
		String name = a.getClass().getName().replace('.', '/');				
		name = a.getClass().getResource("/" + name + ".class").toString();			
		// remove junk
		name = name.substring(0, name.indexOf(".jar"));			
		name = name.substring(name.lastIndexOf(':')+1, name.lastIndexOf('/')+1).replace('%', ' ');	
		// remove escape characters
		String s = "";
		for (int k=0; k<name.length(); k++) {
		  s += name.charAt(k);
		  if (name.charAt(k) == ' ') k += 2;
		}
		// replace '/' with system separator char
		return s.replace('/', File.separatorChar);
  }
  
}