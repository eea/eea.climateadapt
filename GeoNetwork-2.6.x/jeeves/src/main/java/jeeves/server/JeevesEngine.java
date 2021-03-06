//==============================================================================
//===
//===   JeevesEngine
//===
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

package jeeves.server;

import jeeves.constants.ConfigFile;
import jeeves.constants.Jeeves;
import jeeves.exceptions.BadInputEx;
import jeeves.interfaces.Activator;
import jeeves.interfaces.ApplicationHandler;
import jeeves.interfaces.Logger;
import jeeves.server.context.ServiceContext;
import jeeves.server.dispatchers.ServiceManager;
import jeeves.server.resources.ProviderManager;
import jeeves.server.sources.ServiceRequest;
import jeeves.server.sources.http.JeevesServlet;
import jeeves.utils.Log;
import jeeves.utils.SerialFactory;
import jeeves.utils.TransformerFactoryFactory;
import jeeves.utils.Util;
import jeeves.utils.Xml;
import org.apache.log4j.PropertyConfigurator;
import org.jdom.Element;

import javax.servlet.ServletException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

//=============================================================================

/** This is the main class. It handles http connections and inits the system
  */

public class JeevesEngine
{
	private String  defaultSrv;
	private String  profilesFile;
	private String  defaultLang;
	private String  defaultContType;
	private String  uploadDir;
	private int     maxUploadSize;
	private String  appPath;
	private boolean defaultLocal;
	private boolean debugFlag;

	/** true if the 'general' part has been loaded */
	private boolean generalLoaded;

	private ServiceManager  serviceMan  = new ServiceManager();
	private ProviderManager providerMan = new ProviderManager();
	private ScheduleManager scheduleMan = new ScheduleManager();
	private SerialFactory   serialFact  = new SerialFactory();

	private Logger appHandLogger = Log.createLogger(Log.APPHAND);
	private List   appHandList   = new ArrayList();
	private Vector vAppHandlers  = new Vector();
	private Vector vActivators   = new Vector();

	//---------------------------------------------------------------------------
	//---
	//--- Init
	//---
	//---------------------------------------------------------------------------

	/** Inits the engine, loading all needed data
	  */

	public void init(String appPath, String configPath, String baseUrl, JeevesServlet servlet) throws ServletException
	{
		try
		{
			this.appPath = appPath;

			long start   = System.currentTimeMillis();

			long maxMem  = Runtime.getRuntime().maxMemory()   / 1024;
			long totMem  = Runtime.getRuntime().totalMemory() / 1024;
			long freeMem = Runtime.getRuntime().freeMemory()  / 1024;

			long usedMem      = totMem - freeMem;
			long startFreeMem = maxMem - usedMem;

			PropertyConfigurator.configure(configPath +"log4j.cfg");

			// System.setProperty("javax.xml.transform.TransformerFactory",
			//						 "net.sf.saxon.TransformerFactoryImpl");
			// Do this using library meta-inf to avoid affecting other servlets
			// in the same container

			info("=== Starting system ========================================");

			//---------------------------------------------------------------------
			//--- init system

			info("Java version : "+ System.getProperty("java.vm.version"));
			info("Java vendor  : "+ System.getProperty("java.vm.vendor"));

            setupXSLTTransformerFactory();

			info("Path    : "+ appPath);
			info("BaseURL : "+ baseUrl);

			serviceMan.setAppPath(appPath);
			serviceMan.setProviderMan(providerMan);
			serviceMan.setSerialFactory(serialFact);
			serviceMan.setBaseUrl(baseUrl);
			serviceMan.setServlet(servlet);

			scheduleMan.setAppPath(appPath);
			scheduleMan.setProviderMan(providerMan);
			scheduleMan.setSerialFactory(serialFact);
			scheduleMan.setBaseUrl(baseUrl);

			loadConfigFile(configPath, Jeeves.CONFIG_FILE, serviceMan);

			info("Initializing profiles...");
			serviceMan.loadProfiles(profilesFile);

			//--- handlers must be started here because they may need the context
			//--- with the ProfileManager already loaded

			for(int i=0; i<appHandList.size(); i++)
				initAppHandler((Element) appHandList.get(i), servlet);

			info("Starting schedule manager...");
			scheduleMan.start();

			//---------------------------------------------------------------------

			long end      = System.currentTimeMillis();
			long duration = (end - start) / 1000;

			freeMem = Runtime.getRuntime().freeMemory()  / 1024;
			totMem  = Runtime.getRuntime().totalMemory() / 1024;
			usedMem = totMem - freeMem;

			long endFreeMem = maxMem - usedMem;
			long dataMem    = startFreeMem - endFreeMem;

			info("Memory used is  : " + dataMem  + " Kb");
			info("Total memory is : " + maxMem   + " Kb");
			info("Startup time is : " + duration + " (secs)");

			info("=== System working =========================================");
		}
		catch (Exception e)
		{
			fatal("Raised exception during init");
			fatal("   Exception : " +e);
			fatal("   Message   : " +e.getMessage());
			fatal("   Stack     : " +Util.getStackTrace(e));

			throw new ServletException("Exception raised", e);
		}
	}

    /**
     * Looks up the implementation of XSLT factory defined in META-INF/services/javax.xml.transform.TransformerFactory and instantiates
     * that implementation. This way, a conflicting setting in System Properties is overridden for this application only.
     *
     * @throws IOException
     * @throws TransformerConfigurationException
     */
    private void setupXSLTTransformerFactory() throws IOException, TransformerConfigurationException {
        InputStream in = null;
        try {
            in = this.getClass().getClassLoader().getResourceAsStream("META-INF/services/javax.xml.transform.TransformerFactory");
            if(in != null) {
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = br.readLine()) != null)   {
                    if(line == null || line.length() == 0) {
                        warning("Malformed definition of XSLT transformer (in: META-INF/services/javax.xml.transform.TransformerFactory).");
                    }
                    TransformerFactoryFactory.init(line);
                    break;
                }
                in.close();
            }
            else {
                warning("Definition of XSLT transformer not found (tried: META-INF/services/javax.xml.transform.TransformerFactory)");
            }
        }
        catch(IOException x) {
            error(x.getMessage());
            x.printStackTrace();
        }
        finally {
            if(in != null) {
                in.close();
            }
        }
    }


	//---------------------------------------------------------------------------

	private void loadConfigFile(String path, String file, ServiceManager serviceMan) throws Exception
	{
		file = path + file;

		info("Loading : " + file);

		Element configRoot = Xml.loadFile(file);

		Element elGeneral = configRoot.getChild(ConfigFile.Child.GENERAL);
		Element elDefault = configRoot.getChild(ConfigFile.Child.DEFAULT);

		if (!generalLoaded)
		{
			if (elGeneral == null)
				throw new NullPointerException("Missing 'general' element in config file :" +file);

			if (elDefault == null)
				throw new NullPointerException("Missing 'default' element in config file :" +file);

			generalLoaded = true;

			initGeneral(elGeneral, serviceMan);
			initDefault(elDefault, serviceMan);
		}
		else
		{
			if (elGeneral != null)
				throw new IllegalArgumentException("Illegal 'general' element in secondary include");

			if (elDefault != null)
				throw new IllegalArgumentException("Illegal 'default' element in secondary include");
		}

		//--- init resources

		List resList = configRoot.getChildren(ConfigFile.Child.RESOURCES);

		for(int i=0; i<resList.size(); i++)
			initResources((Element) resList.get(i));

		//--- init app-handlers

		appHandList.addAll(configRoot.getChildren(ConfigFile.Child.APP_HANDLER));

		//--- init services

		List srvList = configRoot.getChildren(ConfigFile.Child.SERVICES);

		for(int i=0; i<srvList.size(); i++)
			initServices((Element) srvList.get(i));

		//--- init schedules

		List schedList = configRoot.getChildren(ConfigFile.Child.SCHEDULES);

		for(int i=0; i<schedList.size(); i++)
			initSchedules((Element) schedList.get(i));

		//--- recurse on includes

		List includes = configRoot.getChildren(ConfigFile.Child.INCLUDE);

		for(int i=0; i<includes.size(); i++)
		{
			Element include = (Element) includes.get(i);

			loadConfigFile(path, include.getText(), serviceMan);
		}
	}

	//---------------------------------------------------------------------------
	//---
	//--- 'general' element
	//---
	//---------------------------------------------------------------------------

	/** Setup parameters from config tag (config.xml)
	  */

	private void initGeneral(Element general, ServiceManager serviceMan) throws BadInputEx
	{
		info("Initializing general configuration...");

		profilesFile = Util.getParam(general, ConfigFile.General.Child.PROFILES);
		uploadDir    = Util.getParam(general, ConfigFile.General.Child.UPLOAD_DIR);
		try {
		    maxUploadSize = Integer.parseInt(Util.getParam(general, ConfigFile.General.Child.MAX_UPLOAD_SIZE));
		} 
		catch(Exception e){
		    maxUploadSize = 50;
		    error("Maximum upload size not properly configured in config.xml. Using default size of 50MB");
            error("   Exception : " +e);
            error("   Message   : " +e.getMessage());
            error("   Stack     : " +Util.getStackTrace(e));
	    }

		if (!new File(uploadDir).isAbsolute())
			uploadDir = appPath + uploadDir;

		if (!uploadDir.endsWith("/"))
			uploadDir += "/";

		new File(uploadDir).mkdirs();

		debugFlag = "true".equals(general.getChildText(ConfigFile.General.Child.DEBUG));

		serviceMan.setUploadDir(uploadDir);
		serviceMan.setMaxUploadSize(maxUploadSize);
	}

	//---------------------------------------------------------------------------
	//---
	//--- 'general' element
	//---
	//---------------------------------------------------------------------------

	/** Setup parameters from config tag (config.xml)
	  */

	private void initDefault(Element defaults, ServiceManager serviceMan) throws Exception
	{
		info("Initializing defaults...");

		defaultSrv     = Util.getParam(defaults, ConfigFile.Default.Child.SERVICE);
		defaultLang    = Util.getParam(defaults, ConfigFile.Default.Child.LANGUAGE);
		defaultContType= Util.getParam(defaults, ConfigFile.Default.Child.CONTENT_TYPE);

		defaultLocal = "true".equals(defaults.getChildText(ConfigFile.Default.Child.LOCALIZED));

		info("   Default local is :" +defaultLocal);

		serviceMan.setDefaultLang(defaultLang);
		serviceMan.setDefaultLocal(defaultLocal);
		serviceMan.setDefaultContType(defaultContType);

		List errorPages = defaults.getChildren(ConfigFile.Default.Child.ERROR);

		for(int i=0; i<errorPages.size(); i++)
			serviceMan.addErrorPage((Element) errorPages.get(i));

		Element gui = defaults.getChild(ConfigFile.Default.Child.GUI);

		if (gui != null)
		{
			List guiElems = gui.getChildren();

			for(int i=0; i<guiElems.size(); i++)
				serviceMan.addDefaultGui((Element) guiElems.get(i));
		}
	}

	//---------------------------------------------------------------------------
	//---
	//--- 'resources' element
	//---
	//---------------------------------------------------------------------------

	/** Setup resources from the resource element (config.xml)
	  */

	private void initResources(Element resources)
	{
		info("Initializing resources...");

		List resList = resources.getChildren(ConfigFile.Resources.Child.RESOURCE);

		for(int i=0; i<resList.size(); i++)
		{
			Element res = (Element) resList.get(i);

			String  name      = res.getChildText(ConfigFile.Resource.Child.NAME);
			String  provider  = res.getChildText(ConfigFile.Resource.Child.PROVIDER);
			Element config    = res.getChild    (ConfigFile.Resource.Child.CONFIG);
			Element activator = res.getChild    (ConfigFile.Resource.Child.ACTIVATOR);

			String enabled = res.getAttributeValue(ConfigFile.Resource.Attr.ENABLED);

			if ((enabled == null) || enabled.equals("true"))
			{
				info("   Adding resource : " + name);

				try
				{
					if (activator != null)
					{
						String clas = activator.getAttributeValue(ConfigFile.Activator.Attr.CLASS);

						info("      Loading activator  : "+ clas);
						Activator activ = (Activator) Class.forName(clas).newInstance();

						info("      Starting activator : "+ clas);
						activ.startup(appPath, activator);

						vActivators.add(activ);
					}

					providerMan.register(provider, name, config);
				}
				catch(Exception e)
				{
					error("Raised exception while initializing resource. Skipped.");
					error("   Resource  : " +name);
					error("   Provider  : " +provider);
					error("   Exception : " +e);
					error("   Message   : " +e.getMessage());
					error("   Stack     : " +Util.getStackTrace(e));
				}
			}
		}
	}

	//---------------------------------------------------------------------------
	//---
	//--- 'appHandler' element
	//---
	//---------------------------------------------------------------------------

	private void initAppHandler(Element handler, JeevesServlet servlet) throws Exception
	{
		if (handler == null)
			info("Handler not found");
		else
		{
			String className = handler.getAttributeValue(ConfigFile.AppHandler.Attr.CLASS);

			if (className == null)
				throw new IllegalArgumentException("Missing '"        +ConfigFile.AppHandler.Attr.CLASS+
															  "' attribute in '" +ConfigFile.Child.APP_HANDLER+
															  "' element");

			info("Found handler : " +className);

			Class c = Class.forName(className);

			ApplicationHandler h = (ApplicationHandler) c.newInstance();

			ServiceContext srvContext = serviceMan.createServiceContext("AppHandler");
			srvContext.setLanguage(defaultLang);
			srvContext.setLogger(appHandLogger);
			srvContext.setServlet(servlet);

			try
			{
				info("--- Starting handler --------------------------------------");

				Object context = h.start(handler, srvContext);

				srvContext.getResourceManager().close();
				vAppHandlers.add(h);
				serviceMan .registerContext(h.getContextName(), context);
				scheduleMan.registerContext(h.getContextName(), context);

				info("--- Handler started ---------------------------------------");
			}
			catch (Exception e)
			{
				error("Raised exception while starting appl handler. Skipped.");
				error("   Handler   : " +className);
				error("   Exception : " +e);
				error("   Message   : " +e.getMessage());
				error("   Stack     : " +Util.getStackTrace(e));

				srvContext.getResourceManager().abort();
			}
		}
	}

	//---------------------------------------------------------------------------
	//---
	//--- 'services' element
	//---
	//---------------------------------------------------------------------------

	/** Setup services found in the services tag (config.xml)
	  */

	private void initServices(Element services) throws Exception
	{
		info("Initializing services...");

		//--- get services root package
		String pack = services.getAttributeValue(ConfigFile.Services.Attr.PACKAGE);

		//--- scan services elements
		List srvList = services.getChildren(ConfigFile.Services.Child.SERVICE);

		for(int i=0; i<srvList.size(); i++)
		{
			Element service = (Element) srvList.get(i);
			String  name    = service.getAttributeValue(ConfigFile.Service.Attr.NAME);

			info("   Adding service : " + name);

			try
			{
				serviceMan.addService(pack, service);
			}
			catch(Exception e)
			{
				warning("Raised exception while registering service. Skipped.");
				warning("   Service   : " +name);
				warning("   Package   : " +pack);
				warning("   Exception : " +e);
				warning("   Message   : " +e.getMessage());
				warning("   Stack     : " +Util.getStackTrace(e));
			}
		}
	}

	//---------------------------------------------------------------------------
	//---
	//--- 'schedules' element
	//---
	//---------------------------------------------------------------------------

	/** Setup schedules found in the 'schedules' element (config.xml)
	  */

	private void initSchedules(Element schedules) throws Exception
	{
		info("Initializing schedules...");

		//--- get schedules root package
		String pack = schedules.getAttributeValue(ConfigFile.Schedules.Attr.PACKAGE);

		//--- scan schedules elements
		List schedList = schedules.getChildren(ConfigFile.Schedules.Child.SCHEDULE);

		for(int i=0; i<schedList.size(); i++)
		{
			Element schedule = (Element) schedList.get(i);
			String  name    = schedule.getAttributeValue(ConfigFile.Schedule.Attr.NAME);

			info("   Adding schedule : " + name);

			try
			{
				scheduleMan.addSchedule(pack, schedule);
			}
			catch(Exception e)
			{
				error("Raised exception while registering schedule. Skipped.");
				error("   Schedule  : " +name);
				error("   Package   : " +pack);
				error("   Exception : " +e);
				error("   Message   : " +e.getMessage());
				error("   Stack     : " +Util.getStackTrace(e));
			}
		}
	}

	//---------------------------------------------------------------------------
	//---
	//--- Destroy
	//---
	//---------------------------------------------------------------------------

	public void destroy()
	{
		try
		{
			info("=== Stopping system ========================================");

			info("Stopping schedule manager...");
			scheduleMan.exit();

			info("Stopping handlers...");
			stopHandlers();

			info("Stopping resources...");
			stopResources();

			info("=== System stopped ========================================");
		}
		catch (Exception e)
		{
			error("Raised exception during destroy");
			error("  Exception : " +e);
			error("  Message   : " +e.getMessage());
			error("  Stack     : " +Util.getStackTrace(e));
		}
	}

	//---------------------------------------------------------------------------
	/** Stop handlers
	  */

	private void stopHandlers() throws Exception
	{
		for (int i = 0; i < vAppHandlers.size(); i++)
		{
			ApplicationHandler h = (ApplicationHandler) vAppHandlers.get(i);

			h.stop();
		}
	}

	//---------------------------------------------------------------------------
	/** Stop resources
	  */

	private void stopResources()
	{
		providerMan.end();

		for(Iterator i=vActivators.iterator(); i.hasNext();)
		{
			Activator a = (Activator) i.next();

			info("   Stopping activator : "+ a.getClass().getName());
			a.shutdown();
		}
	}

	//---------------------------------------------------------------------------
	//---
	//--- API methods
	//---
	//---------------------------------------------------------------------------

	public String getUploadDir() { return uploadDir; }

	//---------------------------------------------------------------------------

    public int getMaxUploadSize() { return maxUploadSize; }

    //---------------------------------------------------------------------------

	public void dispatch(ServiceRequest srvReq, UserSession session)
	{
		if (srvReq.getService() == null || srvReq.getService().length() == 0)
			srvReq.setService(defaultSrv);

		if (srvReq.getLanguage() == null || srvReq.getLanguage().length() == 0)
			srvReq.setLanguage(defaultLang);

		srvReq.setDebug(srvReq.hasDebug() && debugFlag);

		//--- normal dispatch pipeline

		serviceMan.dispatch(srvReq, session);
	}

	//---------------------------------------------------------------------------
	//---
	//--- Other private methods
	//---
	//---------------------------------------------------------------------------

	private void debug  (String message) { Log.debug  (Log.ENGINE, message); }
	private void info   (String message) { Log.info   (Log.ENGINE, message); }
	private void warning(String message) { Log.warning(Log.ENGINE, message); }
	private void error  (String message) { Log.error  (Log.ENGINE, message); }
	private void fatal  (String message) { Log.fatal  (Log.ENGINE, message); }
}

//=============================================================================


