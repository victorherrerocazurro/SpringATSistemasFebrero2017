package com.atsistemas.curso.servicios;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.atsistemas.curso.negocio.Negocio;
import com.atsistemas.curso.persistencia.jpa.data.PersonaDao;

@Configuration
@ComponentScan("com.atsistemas.curso.servicios")
public class Configuracion {

	@Bean
	@Profile("test")
	public PersonaDao personaDao(){
		return Mockito.mock(PersonaDao.class);
	}
	
	@Bean
	@Profile("test")
	public Negocio negocio(){
		return Mockito.mock(Negocio.class);
	}
	
}
