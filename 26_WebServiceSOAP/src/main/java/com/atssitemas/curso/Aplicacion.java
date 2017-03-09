package com.atssitemas.curso;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Aplicacion {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context 
			= new ClassPathXmlApplicationContext("ApplicationContext.xml");
	}
}
