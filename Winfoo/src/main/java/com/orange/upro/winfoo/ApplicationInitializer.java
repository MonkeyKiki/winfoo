package com.orange.upro.winfoo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;
import org.jboss.resteasy.plugins.server.servlet.ResteasyBootstrap;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.orange.upro.winfoo.configuration.RestEasyAnnotatedContextLoader;
import com.orange.upro.winfoo.configuration.WebApplicationConfiguration;

public class ApplicationInitializer implements WebApplicationInitializer {

	private static final String REST_API_PREFIX = "/rest/";

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(WebApplicationConfiguration.class);

		registerServlets(servletContext, rootContext);
		registerParams(servletContext);
		registerListeners(servletContext, rootContext);
	}

	private void registerListeners(ServletContext servletContext, AnnotationConfigWebApplicationContext rootContext) {
		servletContext.addListener(new ResteasyBootstrap());
		servletContext.addListener(new RestEasyAnnotatedContextLoader(rootContext));
	}

	private void registerServlets(ServletContext servletContext, AnnotationConfigWebApplicationContext rootContext) {
		ServletRegistration.Dynamic springDispatcher = servletContext.addServlet("SpringDispatcherServlet",
				new DispatcherServlet(rootContext));
		springDispatcher.setLoadOnStartup(1);
		springDispatcher.addMapping("/");

		ServletRegistration.Dynamic restEasyDispatcher = servletContext.addServlet("RestEasyHttpServletDispatcher",
				new HttpServletDispatcher());
		restEasyDispatcher.setLoadOnStartup(1);
		restEasyDispatcher.addMapping(REST_API_PREFIX + "*");
	}

	private void registerParams(ServletContext servletContext) {
		servletContext.setInitParameter("resteasy.media.type.mappings",
				"json : application/json, xml : application/xml");
		servletContext.setInitParameter("resteasy.servlet.mapping.prefix", REST_API_PREFIX);
	}

}