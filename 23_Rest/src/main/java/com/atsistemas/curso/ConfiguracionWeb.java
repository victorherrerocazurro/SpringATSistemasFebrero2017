package com.atsistemas.curso;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.atsistemas.curso.controladores")
@EnableWebMvc
public class ConfiguracionWeb {
	
}
