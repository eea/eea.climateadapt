package nl.wur.alterra.cgi.ace.listener;

import nl.wur.alterra.cgi.ace.harvester.HarvesterExecutionService;

import javax.servlet.ServletContextEvent;

/**
 * Application listener for AceItem web application.
 *
 * @author heikki doeleman
 */
public class AceItemApplicationListener extends com.liferay.portal.kernel.servlet.PortletContextListener { //implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //System.out.println("AceItem Web Application Context initialized");
    }

    @Override
    protected void doPortalInit() {
        super.doPortalInit();
        //System.out.println("AceItem doPortalInit");
    }

    @Override
    public void portalInit() {
        //System.out.println("AceItem portalInit");
        super.portalInit();
    }

    /**
     * Shuts down harvester execution service. TODO not tested.
     *
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //System.out.println("destroying AceItem Web Application Context");
        // TODO ungraceful shutdown, is ok? Otherwise shutdown can take an arbitrary time to complete
        HarvesterExecutionService.getExecutionService().shutdownNow();
    }



}