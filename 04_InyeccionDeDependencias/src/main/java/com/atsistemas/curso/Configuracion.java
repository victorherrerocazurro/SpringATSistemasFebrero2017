package com.atsistemas.curso;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.atsistemas.curso")
public class Configuracion {

	@Bean
	public Servicio otroServicio(PersonaDao dao){
		Servicio servicio = new Servicio();
		servicio.setDao(dao);
		return servicio;
	}
	
	@Bean
	public Servicio servicio(PersonaDao dao){
		return new Servicio(dao, null);
	}
	
	@Bean
	public PersonaDao dao(){
		return new MemoriaPersonaDao();
	}
}
