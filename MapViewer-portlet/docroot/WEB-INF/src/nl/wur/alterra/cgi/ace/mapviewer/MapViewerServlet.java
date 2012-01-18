package nl.wur.alterra.cgi.ace.mapviewer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MapViewerServlet
 */
public class MapViewerServlet extends HttpServlet {
	private static final long serialVersionUID = -3401856389897819125L;
	
	private static String anMapState = "mapstate";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	    	HttpSession httpsession = request.getSession(true);
	    	
	    	String mapstate = getMapState(httpsession);
			
			response.setContentType("text/xml");
			
			response.setContentLength(mapstate.length());
			
			response.getWriter().println(mapstate);
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
	
	private String getMapState(HttpSession aHttpSession) throws Exception {
		String result = null;
		
		if (! aHttpSession.isNew()) {
			Object object = aHttpSession.getAttribute(anMapState);
			
			if (object instanceof String) {
				result = (String) object;
			}
		}
		
		if (result == null) {
			result = getDefaultMapState();
			
			aHttpSession.setAttribute(anMapState, result);
		}
				
		return result;
	}

	private String getDefaultMapState() throws Exception {
		String result = "";
		
		String filename = getServletContext().getRealPath("").concat("/wmc/default.xml");
		
		File file = new File(filename);
		
		if (file.exists()) {
			FileInputStream fileinputstream = new FileInputStream(filename);
			
			DataInputStream datainputstream = new DataInputStream(fileinputstream);
			
			try {
				BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(datainputstream));
				
				String line;
				
				while ((line = bufferedreader.readLine()) != null)   {
					result += line;
				}
			} finally {
				datainputstream.close();
				
				fileinputstream.close();
			}
		} else {
			throw new Exception("File not found: " + filename);
		}
		
		return result;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    BufferedReader reader = request.getReader();
	    
	    try {
	    	StringBuilder stringbuilder = new StringBuilder();
	    	
	    	String line = reader.readLine();
	    	
	    	while (line != null) {
	    		stringbuilder.append(line + "\n");
	    		
	    		line = reader.readLine();
	    	}
	    	
	    	String mapstate = stringbuilder.toString();
	    	
	    	HttpSession httpsession = request.getSession(true);
	    	
	    	httpsession.setAttribute(anMapState, mapstate);
		} finally {
			reader.close();
		}
	}
}
