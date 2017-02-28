package com.atsistemas.curso;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfiguracionSpring {

	@Bean
	@Scope("prototype")
	public Saludador primerSaludador(){		
		return new SaludadorErrorImpl();
	}
	
	@Bean
	public Saludador segundoSaludador(){
		return new SaludadorErrorImpl();
	}
	
}
