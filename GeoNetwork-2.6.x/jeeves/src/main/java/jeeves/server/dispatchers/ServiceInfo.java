//=============================================================================
//===	Copyright (C) 2001-2005 Food and Agriculture Organization of the
//===	United Nations (FAO-UN), United Nations World Food Programme (WFP)
//===	and United Nations Environment Programme (UNEP)
//===
//===	This library is free software; you can redistribute it and/or
//===	modify it under the terms of the GNU Lesser General Public
//===	License as published by the Free Software Foundation; either
//===	version 2.1 of the License, or (at your option) any later version.
//===
//===	This library is distributed in the hope that it will be useful,
//===	but WITHOUT ANY WARRANTY; without even the implied warranty of
//===	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//===	Lesser General Public License for more details.
//===
//===	You should have received a copy of the GNU Lesser General Public
//===	License along with this library; if not, write to the Free Software
//===	Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
//===
//===	Contact: Jeroen Ticheler - FAO - Viale delle Terme di Caracalla 2,
//===	Rome - Italy. email: GeoNetwork@fao.org
//==============================================================================

package jeeves.server.dispatchers;

import java.util.Vector;
import jeeves.constants.ConfigFile;
import jeeves.constants.Jeeves;
import jeeves.interfaces.Service;
import jeeves.server.context.ServiceContext;
import jeeves.utils.Xml;
import org.jdom.Element;

//=============================================================================

/** A container class for a service. It collect the method and the filter
  */

public class ServiceInfo
{
	private String  appPath;
	private String  match;
	private String  sheet;
	private boolean cache = false;

	private Vector vServices= new Vector();
	private Vector vOutputs = new Vector();
	private Vector vErrors  = new Vector();

	//--------------------------------------------------------------------------
	//---
	//--- Constructor
	//---
	//--------------------------------------------------------------------------

	public ServiceInfo(String appPath)
	{
		this.appPath = appPath;
	}

	//--------------------------------------------------------------------------
	//---
	//--- API methods
	//---
	//--------------------------------------------------------------------------

	public void setMatch(String match)
	{
		if (match != null && match.trim().equals(""))
			match = null;

		this.match = match;
	}

	//--------------------------------------------------------------------------

	public void setSheet(String sheet)
	{
		if (sheet != null && sheet.trim().equals(""))
			sheet = null;

		this.sheet = sheet;
	}

	//--------------------------------------------------------------------------

	public void setCache(String cache)
	{
		this.cache = "yes".equals(cache);
	}

	//--------------------------------------------------------------------------

	public boolean isCacheSet() { return cache; }

	//--------------------------------------------------------------------------

	public void addService(Service s)
	{
		vServices.add(s);
	}

	//--------------------------------------------------------------------------
	/** Adds to the engine the output page of a service
	  */

	public void addOutputPage(OutputPage page)
	{
		vOutputs.add(page);
	}

	//--------------------------------------------------------------------------

	public void addErrorPage(ErrorPage page)
	{
		vErrors.add(page);
	}

	//--------------------------------------------------------------------------

	public Element execServices(Element params, ServiceContext context) throws Exception
	{
		if (params == null)
			params = new Element(Jeeves.Elem.REQUEST);

		//--- transform input request using a given stylesheet

		params = transformInput(params);

		if (vServices.size() == 0)
		{
			params.setName(Jeeves.Elem.RESPONSE);
			return params;
		}

		Element response = params;

		for(int i=0; i<vServices.size(); i++)
		{
			Service service = (Service) vServices.get(i);
			response = execService(service, response, context);
		}

		//--- we must detach the element from its parent because the output dispatcher
		//--- links it to the root element
		//--- note that caching is not allowed in any case

		response.detach();

		return response;
	}

	//--------------------------------------------------------------------------

	public OutputPage findOutputPage(Element response) throws Exception
	{
		for(int i=0; i<vOutputs.size(); i++)
		{
			OutputPage page = (OutputPage) vOutputs.get(i);

			if (page.matches(response))
				return page;
		}

		return null;
	}

	//--------------------------------------------------------------------------

	public ErrorPage findErrorPage(String id)
	{
		for(int i=0; i<vErrors.size(); i++)
		{
			ErrorPage page = (ErrorPage) vErrors.get(i);

			if (page.matches(id))
				return page;
		}

		return null;
	}

	//---------------------------------------------------------------------------
	/** Returns true if the service input has elements that match this page
	  */

	public boolean matches(Element request) throws Exception
	{
		if (match == null)	return true;
			else					return Xml.selectBoolean(request, match);
	}

	//---------------------------------------------------------------------------
	//---
	//--- Private methods
	//---
	//---------------------------------------------------------------------------

	private Element transformInput(Element request) throws Exception
	{
		if (sheet == null)
			return request;

		String styleSheet = appPath + Jeeves.Path.XSL + sheet;

		ServiceManager.info("Transforming input with stylesheet : " +styleSheet);

		try
		{
			Element result = Xml.transform(request, styleSheet);
			ServiceManager.info("End of input transformation");

			return result;
		}
		catch(Exception e)
		{
			ServiceManager.error("Exception during transformation");
			ServiceManager.error("  (C) message is : "+ e.getMessage());

			Throwable t = e;

			while(t.getCause() != null)
			{
				ServiceManager.error("  (C) message is : "+ t.getMessage());
				t = t.getCause();
			}

			throw e;
		}
	}

	//--------------------------------------------------------------------------

	private Element execService(Service service, Element params, ServiceContext context) throws Exception
	{
		try
		{
			Element response = service.exec(params, context);

			if (response == null)
				response = new Element(Jeeves.Elem.RESPONSE);

			//--- commit resources and return response

			context.getResourceManager().close();

			return response;
		}
		catch(Exception e)
		{
			//--- in case of exception we have to abort all resources

			context.getResourceManager().abort();
			ServiceManager.error("Exception when executing service");
			ServiceManager.error(" (C) Exc : " + e);

			throw e;
		}
	}
}

//=============================================================================

