package nl.wur.alterra.cgi.ace.mapviewer;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.wur.alterra.cgi.ace.mapviewer.mapstate.MapState;
import nl.wur.alterra.cgi.ace.mapviewer.mapstate.MapStateList;
import nl.wur.alterra.cgi.ace.portlet.Constants;

/**
 * Servlet implementation class MapViewerServlet
 */
public class MapViewerServlet extends HttpServlet {
	private static final long serialVersionUID = -3401856389897819125L;
	
	private static String anMapStateList = "mapstatelist";
	
	private static String defaultMapViewerAppId = "default";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String mapviewerappid = getMapViewerAppId(request);
			
			if (mapviewerappid == null || mapviewerappid.length() == 0) {
				throw new Exception("mapViewerAppId is undefined.");
			} else {
				String mapviewerwmcdirectory = request.getParameter(Constants.mapViewerWmcDirectoryParameterName);
				
				if (mapviewerwmcdirectory == null || mapviewerwmcdirectory.length() == 0) {
					throw new Exception("mapViewerWmcDirectory is undefined.");
				} else {
					if (! mapviewerwmcdirectory.endsWith("/")) {
						mapviewerwmcdirectory += "/";
					}
					
					HttpSession httpsession = request.getSession(true);
					
					MapState mapstate = getMapState(mapviewerappid, mapviewerwmcdirectory, httpsession);
					
					if (mapstate == null) {
						throw new Exception("MapState not found for " + mapviewerappid);
					}
					
					response.setContentType("text/xml");
					
					response.setContentLength(mapstate.getMapState().length());
					
					response.getWriter().println(mapstate.getMapState());
				}
			}
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}

	private String getMapViewerAppId(HttpServletRequest request) {
		String mapviewerappid = request.getParameter(Constants.mapViewerAppIdParameterName);
		
		if (mapviewerappid == null || mapviewerappid.length() == 0) {
			mapviewerappid = defaultMapViewerAppId;
		}
		
		return mapviewerappid;
	}
	
	private MapState getMapState(String aMapViewerAppId, String aMapViewerWmcDirectory, HttpSession aHttpSession) throws Exception {
		MapStateList mapstatelist = getMapStateList(aHttpSession);
		
		MapState mapstate = mapstatelist.getMapState(aMapViewerAppId, aMapViewerWmcDirectory);
		
		return mapstate;
	}

	private MapStateList getMapStateList(HttpSession aHttpSession) {
		MapStateList mapstatelist = null;
		
		Object object = aHttpSession.getAttribute(anMapStateList);
			
		if (object instanceof MapStateList) {
			mapstatelist = (MapStateList) object;
		} else {
			mapstatelist = new MapStateList();
			
			aHttpSession.setAttribute(anMapStateList, mapstatelist);
		}
		
		return mapstatelist;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mapviewerappid = getMapViewerAppId(request);
		
    	HttpSession httpsession = request.getSession(true);
    	
		MapState mapstate;
		
		try {
			mapstate = findMapState(mapviewerappid, httpsession);
			
			if (mapstate != null) {
				BufferedReader reader = request.getReader();
				
				try {
					StringBuilder stringbuilder = new StringBuilder();
					
					String line = reader.readLine();
					
					while (line != null) {
						stringbuilder.append(line + "\n");
						
						line = reader.readLine();
					}
					
					String mapstatestring = stringbuilder.toString();
					
					mapstate.setMapState(mapstatestring);
				} finally {
					reader.close();
				}
			} else {
				throw new Exception("MapState not found for " + mapviewerappid);
			}
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
	
	private MapState findMapState(String aMapViewerAppId, HttpSession aHttpSession) throws Exception {
		MapStateList mapstatelist = getMapStateList(aHttpSession);
		
		MapState mapstate = mapstatelist.findMapState(aMapViewerAppId);
		
		return mapstate;
	}
}
