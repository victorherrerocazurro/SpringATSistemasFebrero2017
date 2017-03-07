package com.atsistemas.curso.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.atsistemas.curso.controladores")
@EnableWebMvc
public class ConfiguracionWeb {
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver 
			= new InternalResourceViewResolver("/WEB-INF/Paginas/", ".jsp");		
		return viewResolver;
	}
}
