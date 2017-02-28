package com.atsistemas.curso;

import java.util.Locale;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Aplicacion {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
						new AnnotationConfigApplicationContext("com.atsistemas.curso");
		
		context.publishEvent(new MiEvento("Mi evento personalizado"));
		
		context.close();
		
	}

}
