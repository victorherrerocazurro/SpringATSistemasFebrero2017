package com.atsistemas.curso;

import java.util.Collection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atsistemas.curso.entidades.Persona;
import com.atsistemas.curso.persistencia.PersonaDao;

public class Aplicacion {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
					new AnnotationConfigApplicationContext(Configuracion.class);
		
		PersonaDao personaDao = context.getBean(PersonaDao.class);
		
		personaDao.insertar(new Persona(1L, "Victor"));
		personaDao.insertar(new Persona(2L, "Juan"));
		personaDao.insertar(new Persona(3L, "Maria"));
		
		Collection<Persona> todos = personaDao.consultarTodos();
		
		for (Persona persona : todos) {
			System.out.println(persona);
		}

		context.close();
		
	}

}
