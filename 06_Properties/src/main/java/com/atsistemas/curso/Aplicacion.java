package com.atsistemas.curso;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Aplicacion {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
						new AnnotationConfigApplicationContext("com.atsistemas.curso");
		
		DataSource ds = context.getBean(DataSource.class);
		
	}

}
