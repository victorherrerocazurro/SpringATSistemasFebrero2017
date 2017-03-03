package com.atsistemas.curso;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class Inicializadora implements  WebApplicationInitializer{

	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext springContext = 
						new AnnotationConfigWebApplicationContext();
		
		springContext
			.setConfigLocation("com.atsistemas.curso.aplicacion.jpa");
		
		servletContext.addListener(
				new ContextLoaderListener(
						springContext));
		
	}

}
