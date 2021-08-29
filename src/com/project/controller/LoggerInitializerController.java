package com.project.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Servlet implementation class LoggerInitializerController
 */
@WebServlet(value = { "/LoggerInitializerController" }, loadOnStartup = 1)
public class LoggerInitializerController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final Logger LOG = Logger.getLogger(LoggerInitializerController.class);

    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        String realPath = context.getRealPath("/");
        String logPropFile = realPath + "WEB-INF\\log4j.properties";
        PropertyConfigurator.configure(logPropFile);
        LOG.info("Application Initialized");
    }

}
