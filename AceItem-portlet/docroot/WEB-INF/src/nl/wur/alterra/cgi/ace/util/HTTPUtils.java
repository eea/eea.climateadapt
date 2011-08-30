package nl.wur.alterra.cgi.ace.util;

import com.liferay.portal.kernel.exception.SystemException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Utility for doing HTTP requests.
 *
 * @author heikki doeleman
 */
public class HTTPUtils {

    private static final String POST = "POST";
    private static final String CONTENT_LENGTH = "Content-Length";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String CONTENT_TYPE_XML = "text/xml";
    private static final String CONNECTION = "Connection";
    private static final String CLOSE = "Close";
    private static final String UTF8 = "UTF-8";

    static {
        CookieManager cookieManager = new CookieManager(null, CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(cookieManager);
    }

    /**
     * Posts string content to a URL and returns the response.
     *
     * @param stringContent the string content to post
     * @param destination the destination url
     * @return response content as string
     * @throws com.liferay.portal.kernel.exception.SystemException hmm
     */
    public String post(String stringContent, String destination) throws SystemException {
        try {
            URL url = new URL(destination);
            HttpURLConnection x = (HttpURLConnection) url.openConnection();
            x.setDoInput(true);
            x.setDoOutput(true);
            x.setRequestMethod(POST);
            x.setRequestProperty(CONTENT_LENGTH, String.valueOf(stringContent.length()));
            x.setRequestProperty(CONTENT_TYPE, CONTENT_TYPE_XML);
            x.setRequestProperty(CONNECTION, CLOSE);
            x.setConnectTimeout(20000);
            x.setReadTimeout(20000);
            x.setUseCaches(false);
            x.setDefaultUseCaches(false);

            //
            // send HTTP request
            //
            OutputStream outputStream = null;
            try {
                outputStream = x.getOutputStream();
                outputStream.write(stringContent.getBytes(UTF8));
            }
            finally {
                if (outputStream != null) {
                    outputStream.close();
                }
            }

            //
            // handle HTTP response
            //
            InputStream responseStream;
            String response;
            if (x.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // could deal with response headers if necessary
                //for (Map.Entry<String, List<String>> header : x.getHeaderFields().entrySet()) {
                //    System.out.println("\n######### "+header.getKey() + " = " + header.getValue());
                //}
                responseStream = x.getInputStream();
                response = inputStream2String(responseStream);
            }
            else {
                responseStream = x.getErrorStream();
                response = inputStream2String(responseStream);
                System.out.println(response);
                // TODO do not throw SystemException in case of unsuccesful HTTP response
                throw new SystemException("Server returned response code: " + x.getResponseCode() + " with content:\n" + response);
            }
            System.out.println("\nresponse from server after POST to: "+ destination + "\n" + response + "\n");
            return response;
        }
        catch(MalformedURLException x) {
            x.printStackTrace();
            throw new SystemException(x.getMessage(), x);
        }
        catch (IOException x) {
            x.printStackTrace();
            throw new SystemException(x.getMessage(), x);
        }
    }

    /**
     * Converts an InputStream to String.
     *
     * @param inputStream inputStream
     * @return String
     * @throws java.io.IOException hmm
     */
    private String inputStream2String(InputStream inputStream) throws IOException {
        StringBuilder responseStringBuilder = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(inputStream, UTF8));
            for (String line; (line = reader.readLine()) != null;) {
                responseStringBuilder.append(line);
            }
            return responseStringBuilder.toString();
        }
        finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}