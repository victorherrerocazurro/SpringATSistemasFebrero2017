package com.atsistemas.curso;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Aplicacion {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		Servicio proxyServicio = context.getBean(Servicio.class);
		
		System.out.println(proxyServicio.metodoInterceptado("12"));
		
	}
}
