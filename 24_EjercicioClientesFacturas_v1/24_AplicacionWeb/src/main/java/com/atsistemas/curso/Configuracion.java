package com.atsistemas.curso;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan("com.atsistemas.curso.servicios")
public class Configuracion {
	@Bean
	public PropertyPlaceholderConfigurer properties(){
		PropertyPlaceholderConfigurer placeholderConfigurer 
								= new PropertyPlaceholderConfigurer();
		
		placeholderConfigurer.setLocations(
				new ClassPathResource("Configuracion.properties"),
				new ClassPathResource("Configuracion-db.properties"));
		
		return placeholderConfigurer;
	}
}
