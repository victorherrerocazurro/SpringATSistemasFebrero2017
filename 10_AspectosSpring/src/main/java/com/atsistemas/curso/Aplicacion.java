package com.atsistemas.curso;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;

public class Aplicacion {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		//System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "ConAspectos");
		
		//System.setProperty("spring.profiles.active", "ConAspectos");
		
		/*AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(Configuracion.class);*/
		
		Servicio proxyServicio = context.getBean(Servicio.class);
		
		System.out.println(proxyServicio.metodoInterceptado("12"));
		
		((Extension)proxyServicio).metodoNuevo();
		
	}
}
