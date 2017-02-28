package com.atsistemas.curso;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

import com.atsistemas.curso.entidades.Persona;

@Configuration
@ComponentScans({
	@ComponentScan("com.atsistemas.curso.negocio"),
	@ComponentScan("com.atsistemas.curso.persistencia.memoria"),
	@ComponentScan("com.atsistemas.curso.servicios")
})
public class Configuracion {

	@Bean
	public Map<Long,Persona> tablaPersonas(){
		HashMap<Long,Persona> map = new HashMap<Long,Persona>();
		
		map.put(1L, new Persona(1, "Victor"));
		map.put(2L, new Persona(2, "Maria"));
		
		return map;
	}
	
}
