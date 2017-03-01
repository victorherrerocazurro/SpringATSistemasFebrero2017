package com.atsistemas.curso;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;

@Configuration
public class Configuracion {

	//Tipologiaque permite al contexto de spring, leer de un properties 
	//con la sintaxis ${key}
	@Bean
	public PropertyPlaceholderConfigurer properties(){
		PropertyPlaceholderConfigurer placeholderConfigurer 
								= new PropertyPlaceholderConfigurer();
		
		placeholderConfigurer.setLocation(
				new ClassPathResource("Configuracion.properties"));
		
		return placeholderConfigurer;
	}
	
	@Bean
	public DataSource datasource(
			@Value("${db.user}") String user, 
			@Value("${db.password}") String password, 
			@Value("${db.url}") String url, 
			@Value("${db.driver.class.name}") String driverClassName){
		
		System.out.format("%s, %s, %s, %s", user, password, url, driverClassName);
		return null;
	}
	
}
