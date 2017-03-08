package com.atsistemas.curso.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.atsistemas.curso.controladores.interceptores.CustomInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan("com.atsistemas.curso.controladores")
public class Configuracion extends WebMvcConfigurerAdapter{
	
	//Son aspectos (ServletFilter del mundo de Spring)
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		registry.addInterceptor(new CustomInterceptor());
		registry.addInterceptor(new LocaleChangeInterceptor());
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler( "/js/**").addResourceLocations("/js/");
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//super.addViewControllers(registry);
		registry.addViewController("/").setViewName("inicio");
		registry.addViewController("/inicio.jsp").setViewName("inicio");
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver 
			= new InternalResourceViewResolver("/WEB-INF/Paginas/", ".jsp");
		
		//viewResolver.setOrder(order);
		
		return viewResolver;
	}

}
