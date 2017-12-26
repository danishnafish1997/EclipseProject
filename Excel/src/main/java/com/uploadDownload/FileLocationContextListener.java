package com.uploadDownload;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
/**
 * Application Lifecycle Listener implementation class FileLocationContextListener
 *
 */
@WebListener
public class FileLocationContextListener implements ServletContextListener  {

    
    public void contextInitialized(ServletContextEvent servletContextEvent)  { 
         // TODO Auto-generated method stub
    	String rootPath = System.getProperty("catalina.home");
    	ServletContext ctx = servletContextEvent.getServletContext();
    	String relativePath = ctx.getInitParameter("tempfile.dir");
    	File file = new File(rootPath + File.separator + relativePath);
    	if(!file.exists()) file.mkdirs();
    	ctx.setAttribute("FILES_DIR_FILE", file);
    	ctx.setAttribute("FILES_DIR", rootPath + File.separator + relativePath);
    }

	
	
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }



	
}


	
