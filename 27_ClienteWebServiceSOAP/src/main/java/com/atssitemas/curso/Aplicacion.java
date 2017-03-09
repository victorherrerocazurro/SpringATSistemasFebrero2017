package com.atssitemas.curso;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atsistemas.curso.entidades.Persona;

public class Aplicacion {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		IServicio servicio = context.getBean(IServicio.class);
		
		Persona personaObtenida = servicio.metodo(new Persona());
		
		System.out.println(personaObtenida);
		
	}

}
