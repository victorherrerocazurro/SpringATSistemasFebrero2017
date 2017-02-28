package com.atsistemas.curso;

import java.util.Locale;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Aplicacion {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
						new AnnotationConfigApplicationContext("com.atsistemas.curso");
		
		System.out.println(
				context.getMessage(
						"page.index.welcome", 
						new Object[]{"Victor"}, 
						Locale.getDefault()));
		
		System.out.println(
				context.getMessage(
						"page.index.welcome", 
						new Object[]{"Victor"}, 
						new Locale("es")));
		
		System.out.println(
				context.getMessage(
						"page.index.welcome", 
						new Object[]{"Victor"}, 
						new Locale("it")));
		
		System.out.println(
				context.getMessage(
						"page.index.welcome", 
						new Object[]{"Victor"}, 
						Locale.US));
		
	}

}
