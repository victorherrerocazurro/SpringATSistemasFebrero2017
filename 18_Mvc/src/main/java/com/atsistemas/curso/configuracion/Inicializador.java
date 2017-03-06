package com.atsistemas.curso.configuracion;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Inicializador implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext contextoSpring 
						= new AnnotationConfigWebApplicationContext();

		contextoSpring
			.setConfigLocation("com.atsistemas.curso.configuracion");
		
		DispatcherServlet servlet 
						= new DispatcherServlet(contextoSpring);
		
		Dynamic dynamic = servletContext.addServlet("dispatcherServlet", servlet);
		
		dynamic.addMapping("/");

	}

}
