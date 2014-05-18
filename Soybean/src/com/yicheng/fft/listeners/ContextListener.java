package com.yicheng.fft.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


import com.yicheng.fft.data.DataService;

/**
 * This class is used to listen for startup/shutdown of our web app
 */
public class ContextListener implements ServletContextListener {

    DataService dataService = null;
    /**
     * Called by the web server when our app is getting shutdown
     */
    public void contextDestroyed(ServletContextEvent event) {
        this.dataService.close();
        System.out.println("close the data service!");
    }

    /**
     * Called by the web server when our app is getting started
     */
    public void contextInitialized(ServletContextEvent event) {
        this.dataService = new DataService();
        ServletContext context = event.getServletContext();
        context.setAttribute("data", dataService);
        System.out.println("set the data service!");
    }
    
    /** FOR TESTING PURPOSES ONLY */
    public static void main(String args []) {
        ContextListener listener = new ContextListener();
        listener.contextInitialized(null);
        listener.contextDestroyed(null);
    }
}
