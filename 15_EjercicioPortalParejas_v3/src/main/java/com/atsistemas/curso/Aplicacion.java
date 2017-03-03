package com.atsistemas.curso;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atsistemas.curso.entidades.Persona;
import com.atsistemas.curso.persistencia.PersonaDao;
import com.atsistemas.curso.servicios.Servicio;

public class Aplicacion {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.atsistemas.curso");
		
		Servicio servicio = context.getBean(Servicio.class);
		
		Persona juan = new Persona(3, "Juan", 22, 1.80f, "Hombre");
		servicio.altaUsuario(juan);
		servicio.altaUsuario(new Persona(4, "Jaime", 22, 1.80f, "Hombre"));
		servicio.altaUsuario(new Persona(5, "Juan", 22, 1.80f, "Hombre"));
		
		List<Persona> afinesdeJuan = servicio.busquedaAfines(juan);
		
		System.out.println("Y los afines son.......");
		
		for (Persona afin : afinesdeJuan) {
			System.out.println(afin);
		}

		Persona ideal = servicio.busquedaIdeal(juan);
		
		System.out.println("Y el ideal es.......");
		
		System.out.println(ideal);
		
		PersonaDao personaDao = context.getBean(PersonaDao.class);
		
		Persona persona = personaDao.consultarPorId(3);
		
		System.out.println(persona);
		
		context.close();
		
	}

}
