package com.atsistemas.curso;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atsistemas.curso.entidades.Persona;
import com.atsistemas.curso.servicios.Servicio;

public class Aplicacion {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.atsistemas.curso");
		
		Servicio servicio = context.getBean(Servicio.class);
		
		Persona juan = new Persona(3,"Juan");
		servicio.altaUsuario(juan);
		servicio.altaUsuario(new Persona(4,"Juan"));
		servicio.altaUsuario(new Persona(5,"Jaime"));
		
		List<Persona> afinesdeJuan = servicio.busquedaAfines(juan);
		
		System.out.println("Y los afines son.......");
		
		for (Persona afin : afinesdeJuan) {
			System.out.println(afin);
		}

		Persona ideal = servicio.busquedaIdeal(juan);
		
		System.out.println("Y el ideal es.......");
		
		System.out.println(ideal);
		
		context.close();
		
	}

}
