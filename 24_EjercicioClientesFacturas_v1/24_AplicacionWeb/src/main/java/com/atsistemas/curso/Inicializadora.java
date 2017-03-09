package com.atsistemas.curso;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Inicializadora implements WebApplicationInitializer{

	//Cuando se levanta el servidor de aplicaciones se ejecuta este metodo
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		//Creamos un objeto que representa el contexto de Spring
		AnnotationConfigWebApplicationContext springContext = 
						new AnnotationConfigWebApplicationContext();
		
		//Configuramos el objeto de contexto de Spring, para que interprete las
		//clases con @Configuration dentro del paquete "com.atsistemas.curso.configuracion"
		springContext
			.setConfigLocation("com.atsistemas.curso");
		
		DispatcherServlet servlet = new DispatcherServlet(springContext);

		Dynamic dynamic = servletContext.addServlet("dispatcherServlet", servlet);

		dynamic.addMapping("/api/*");
		
	}

}
