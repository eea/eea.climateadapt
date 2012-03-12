package nl.wur.alterra.cgi.ace.portlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Class to access custom properties defined in ace.custom.properties.
 *
 * @author heikki doeleman
 */
public class CustomProperties {

    private static Properties properties;
    private static boolean isInitialized = false;

    /**
     * Name of file containing custom properties.
     */
    private final static String CUSTOM_PROPERTIES_FILENAME = "/ace.custom.properties";

    /**
     * Base URL to GeoNetwork installation.
     */
    public final static String GEONETWORK_BASE_URL = "geonetwork.base.url";
    /**
     * Administrator username in GeoNetwork.
     */
    public final static String GEONETWORK_ADMIN_USERNAME = "geonetwork.admin.username";
    /**
     * Administrator password in GeoNetwork.
     */
    public final static String GEONETWORK_ADMIN_PASSWORD = "geonetwork.admin.password";
    
    /**
     * Notification mail: from address.
     */
    public final static String NOTIFICATIONMAIL_FROM_ADDRESS = "notificationmail.from.address";
    /**
     * Notification mail: to adresses.
     */
    public final static String NOTIFICATIONMAIL_TO_ADDRESSLIST = "notificationmail.to.addresslist";
    /**
     * Notification mail: website address.
     */
    public final static String NOTIFICATIONMAIL_HOSTURL = "notificationmail.hosturl";
    /**
     * Notification mail: viewprojectpage.
     */
    public final static String NOTIFICATIONMAIL_PROJECTPAGE = "notificationmail.projectpage";
    /**
     * Notification mail: viewmeasurepage.
     */
    public final static String NOTIFICATIONMAIL_MEASUREPAGE = "notificationmail.measurepage";
    /**
     * Notification mail: viewaceitempage.
     */
    public final static String NOTIFICATIONMAIL_ACEITEMPAGE = "notificationmail.aceitempage";

    /**
     * Initializes custom properties.
     *
     * @throws CustomPropertiesNotInitializedException hmm
     */
    public synchronized static void init() throws CustomPropertiesNotInitializedException {
        properties = new Properties();
        try {
            String customPropertiesFilename = Thread.currentThread().getContextClassLoader().getResource(CUSTOM_PROPERTIES_FILENAME).getFile();
            File customProperties = new File(customPropertiesFilename);
            properties.load(new FileInputStream(customProperties));
            isInitialized = true;
            //System.out.println("ACE custom properties succesfully initialized");
        }
        catch (FileNotFoundException x) {
            x.printStackTrace();
            throw new CustomPropertiesNotInitializedException("Failed to initialize ACE custom properties: " + x.getMessage());
        }
        catch (IOException x) {
            x.printStackTrace();
            throw new CustomPropertiesNotInitializedException("Failed to initialize ACE custom properties: " + x.getMessage());
        }
    }

    public static boolean isInitialized() {
        return isInitialized;
    }

    /**
     * Returns value for requested custom property key. Tries to initialize this class if it wasn't already.
     *
     * @param key custom property key
     * @return custom property value
     * @throws CustomPropertiesNotInitializedException hmm
     */
    public static String getProperty(String key) throws CustomPropertiesNotInitializedException {
        if(! isInitialized) {
            //System.out.println("WARNING: custom properties not initialized. Trying now");
            init();
            if(! isInitialized) {
                throw new CustomPropertiesNotInitializedException("ERROR: cannot initialize custom properties");
            }
        }
        return properties.getProperty(key);
    }

}
