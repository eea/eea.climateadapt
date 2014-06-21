package nl.wur.alterra.cgi.ace.mapviewer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.wur.alterra.cgi.ace.portlet.Constants;
import nl.wur.alterra.quickanddirtyows.csw.CSW;

public class CSWServlet extends HttpServlet {

    private static final long serialVersionUID = 5894797036317729493L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cswurl = request.getParameter(Constants.cswUrlParameterName);

        String cswpassword = request.getParameter(Constants.cswPasswordParameterName);

        String cswusername = request.getParameter(Constants.cswUserNameParameterName);

        String cswrecordfileidentifier = request.getParameter(Constants.cswRecordFileIdentifierParameterName);

        try {
            if (cswurl != null && cswrecordfileidentifier != null) {
                CSW csw = new CSW(cswurl, cswusername, cswpassword, false);

                String cswrecordstring = csw.getRecordByIDString(cswrecordfileidentifier);

                response.setContentType("text/xml");

                response.setContentLength(cswrecordstring.length());

                response.getWriter().write(cswrecordstring);
            } else {
                throw new Exception("cswurl and/or cswrecordfileidentifier undefined. ");
            }
        } catch (Exception e) {
            response.sendError(500);
        }
    }
}
