package nl.wur.alterra.cgi.ace.mapviewer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.wur.alterra.cgi.ace.mapviewer.csw.CSW;
import nl.wur.alterra.cgi.ace.mapviewer.csw.CSWRecord;
import nl.wur.alterra.cgi.ace.portlet.Constants;

import com.google.gson.Gson;

/**
 * Servlet implementation class CSWServlet
 */
public class CSWServlet extends HttpServlet {

	private static final long serialVersionUID = -6410354887522194330L;

	private CSW csw;
	
	private Gson gson;
	
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);

        try {
			gson = new Gson();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = null;
		
		try {
        	String cswurl = request.getParameter(Constants.cswURLPreferenceName);
        	
        	if (csw == null || ! csw.getOnlineResource().equalsIgnoreCase(cswurl)) {
        		csw = new CSW(cswurl, null, null);
        	}
			
			String metadatarecordid = request.getParameter(Constants.metadataRecordIDParameterName);
			
			if (metadatarecordid != null && metadatarecordid.length() > 0) {
				CSWRecord cswrecord = csw.getRecordByID(metadatarecordid);
				
				String json = gson.toJson(cswrecord);
				
				response.setContentType("application/json");
				
				response.setContentLength(json.length());
				
				writer = response.getWriter();

				writer.print(json);
					
				writer.flush();
			}
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
}
