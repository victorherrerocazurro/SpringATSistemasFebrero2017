package com.atsistemas.curso;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracion {

	@Bean
	public Escuchador escuchador()
	{
		return new Escuchador();
	}
	
}
