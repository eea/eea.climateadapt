package nl.wur.alterra.restclient;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class RestClient {

	private static int seconds = 1000;
	
	private static int minutes = 60;
	
	protected static String methodDelete = "DELETE";

	protected static String methodGet = "GET";

	protected static String methodPost = "POST";

	protected static String methodPut = "PUT";

	protected static int deleteOKResponseCode = 200;

	protected static int getOKResponseCode = 200;

	protected static int postOKResponseCode00 = 200;

	protected static int postOKResponseCode01 = 201;

	protected static int putOKResponseCode = 200;

	private URL url;

	private String username = "admin";

	private String password = "geoserver";
	
	private static int timeout = 3 * seconds * minutes;
	
	private Logger logger = Logger.getLogger(this.getClass().getName());

	public RestClient(URL aURL, String aUsername, String aPassword) {
		super();

		setURL(aURL);

		setUsername(aUsername);

		setPassword(aPassword);
	}

	protected int get(HttpURLConnection aConnection) throws Exception {
		aConnection.setRequestMethod(methodGet);

		int responsecode = aConnection.getResponseCode();

		if (responsecode != getOKResponseCode) {
			throw createException(aConnection);
		}

		return responsecode;
	}

	protected int post(HttpURLConnection aConnection, String aPostData, String aContentType) throws Exception {
		aConnection.setRequestMethod(methodPost);

		aConnection.setDoOutput(true);

		if (aPostData != null) {
			writeData(aConnection, aPostData, aContentType);
		}

		int responsecode = aConnection.getResponseCode();
		
		if (responsecode != postOKResponseCode00 && responsecode != postOKResponseCode01) {
			throw createException(aConnection);
		}

		return responsecode;
	}

	protected int post(HttpURLConnection aConnection, File aPostData, String aContentType) throws Exception {
		aConnection.setRequestMethod(methodPost);

		aConnection.setDoOutput(true);

		if (aPostData != null) {
			writeData(aConnection, aPostData, aContentType);
		}

		int responsecode = aConnection.getResponseCode();
		
		if (responsecode != postOKResponseCode00 && responsecode != postOKResponseCode01) {
			throw createException(aConnection);
		}

		return responsecode;
	}

	protected int delete(HttpURLConnection aConnection) throws Exception {
		aConnection.setRequestMethod(methodDelete);
		
		aConnection.setDoOutput(false);

		int responsecode = aConnection.getResponseCode();

		if (responsecode != deleteOKResponseCode) {
			throw createException(aConnection);
		}

		return responsecode;
	}

	protected int put(HttpURLConnection aConnection, String aPutData, String aContentType) throws Exception {
		aConnection.setRequestMethod(methodPut);
		
		aConnection.setDoOutput(true);
		
		writeData(aConnection, aPutData, aContentType);

		int responsecode = aConnection.getResponseCode();

		if (responsecode != putOKResponseCode) {
			throw createException(aConnection);
		}

		return responsecode;
	}

	protected HttpURLConnection createConnection(String aFolder,
			String aAccept, String aUserName, String aPassword)
			throws Exception {
		URL url = new URL(getURL().toString() + aFolder);

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		if (aAccept != null && aAccept != "") {
			connection.setRequestProperty("Accept", aAccept);
		}
		
		String usernamepasswordencodedstring = encode(aUserName, aPassword);
		
		connection.setRequestProperty("Authorization", "Basic "	+ usernamepasswordencodedstring);
		
		connection.setConnectTimeout(timeout);
		
		connection.setReadTimeout(0);

		return connection;
	}

	private String encode(String aUserName, String aPassword) {
		String usernamepassword = aUserName + ":" + aPassword;
		
		byte[] usernamepasswordencoded = Base64.encodeBase64(usernamepassword.getBytes());
		
		String usernamepasswordencodedstring = new String(usernamepasswordencoded);
		
		return usernamepasswordencodedstring;
	}

	protected HttpURLConnection createConnection(String aQueryString) throws Exception {
		URL url;
		
		if (getURL().toString().indexOf("?") == -1) {
			url = new URL(StringUtils.checkAndAppend(getURL().toString(), "?") + aQueryString);
		} else {
			url = new URL(getURL().toString() + aQueryString);
		}
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		if (getUsername() != null && getPassword() != null) {
			String usernamepasswordencodedstring = encode(getUsername(), getPassword());
			
			connection.setRequestProperty("Authorization", "Basic "	+ usernamepasswordencodedstring);
		}
		
		return connection;
	}

	protected HttpURLConnection createConnection() throws Exception {
		HttpURLConnection connection = (HttpURLConnection) getURL().openConnection();

		if (getUsername() != null && getPassword() != null) {
			String usernamepasswordencodedstring = encode(getUsername(), getPassword());
			
			connection.setRequestProperty("Authorization", "Basic "	+ usernamepasswordencodedstring);
		}

		return connection;
	}

	private void writeData(URLConnection aURLConnection, String aPostData,
			String aContentType) throws IOException {
		aURLConnection.setRequestProperty("Content-type", aContentType);

		OutputStreamWriter writer = new OutputStreamWriter(aURLConnection.getOutputStream());

		writer.write(aPostData);

		writer.flush();
	}

	private void writeData(URLConnection aURLConnection, File aPostData, String aContentType) throws IOException {
		aURLConnection.setRequestProperty("Content-type", aContentType);

		OutputStreamWriter writer = new OutputStreamWriter(aURLConnection.getOutputStream());
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(aPostData)));

		char[] buffer = new char[1024];

		try {
			int n;
			
			while ((n = reader.read(buffer)) != -1) {
				writer.write(buffer, 0, n);
			}
		} finally {
			reader.close();
		}

		writer.flush();
	}

	protected JSONObject getJSONObject(URLConnection aURLConnection) throws Exception {
		JSONObject result = null;

		String response = getResponse(aURLConnection);

		Object object = JSONValue.parse(response);

		if (object instanceof JSONObject) {
			result = (JSONObject) object;
		}

		return result;
	}

	protected String getResponse (URLConnection aURLConnection) throws IOException {
		String result = "";

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				aURLConnection.getInputStream()));

		try {
			String line = "";

			while ((line = reader.readLine()) != null) {
				result += line;
			}
		} finally {
			reader.close();
		}

		return result;
	}
	
	protected File writeResponse(URLConnection aURLConnection, String aFileName) throws Exception {
		logger.info("Saving response from " + aURLConnection.getURL().getHost() + " to " + aFileName);
		
		File result = null;
		
		String contenttype = aURLConnection.getContentType();
		
		if (contenttype.indexOf("text") != -1) {
			logger.info("Text!");
			
			result = writeTextResponse(aURLConnection, aFileName);
		} else {
			logger.info("Binary!");
			
			result = writeBinaryResponse(aURLConnection, aFileName);
		}

		if (result != null) {
			logger.info("Response from " + aURLConnection.getURL().getHost() + " saved to " + aFileName);
		} else {
			logger.info("Response from " + aURLConnection.getURL().getHost() + " not saved.");
		}
		
		return result;
	}

	private File writeBinaryResponse(URLConnection aURLConnection,
			String aFileName) throws IOException, FileNotFoundException {
		File file = new File(aFileName);

		BufferedInputStream in = new BufferedInputStream(aURLConnection.getInputStream());
		
		try {
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
			
			try {
				int i;
				
				while ((i = in.read()) != -1) {
					out.write(i);
				}
				
				out.flush();
			} finally {
				out.close();
			}
		} finally {
			in.close();
		}
		
		return file;
	}

	private File writeTextResponse(URLConnection aURLConnection, String aFileName) throws IOException {
		BufferedWriter writer = null;
		
		try {
			logger.info("Create filewriter");

			FileWriter filewriter = new FileWriter(aFileName);
			  
			logger.info("Create writer");

			writer = new BufferedWriter(filewriter);
			  
			logger.info("Create reader");

			BufferedReader reader = new BufferedReader(new InputStreamReader(aURLConnection.getInputStream()));

			logger.info("Create buffer");

			char[] buffer = new char[1024];

			try {
				int n;
				
				while ((n = reader.read(buffer)) != -1) {
					logger.info("Read... n=" + n);
					
					writer.write(buffer, 0, n);
				}
			} finally {
				logger.info("Close reader");

				if (reader != null) {
					reader.close();
				}
			}
		} finally {
			logger.info("Close writer");

			if (writer != null) {
				writer.close();
			}
		}
		
		return new File(aFileName);
	}
	
	protected Image getImage(URLConnection aURLConnection) throws Exception {
		InputStream in = aURLConnection.getInputStream();

		Image result = ImageIO.read(in);
		
		return result;
	}
	
	private Exception createException(HttpURLConnection aConnection) throws Exception {
		return new Exception("Error from " + aConnection.getURL() + ": " 
				+ aConnection.getResponseMessage() 
				+ " (" + aConnection.getResponseCode() + ")");
	}

	public URL getURL() {
		return this.url;
	}

	public void setURL(URL aURL) {
		this.url = aURL;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
