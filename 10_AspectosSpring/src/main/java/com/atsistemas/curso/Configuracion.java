package com.atsistemas.curso;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;

@Configuration
//Anotacion que activa las anotaciones @Aspect, @After, ....
@EnableAspectJAutoProxy
@ComponentScan("com.atsistemas.curso")
public class Configuracion {

	@Bean
	@Profile("ConAspectos")
	public Aspecto aspecto(){
		return new Aspecto();
	}
	
}
