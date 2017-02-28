package com.atsistemas.curso;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProgramaHolaMundo {

	public static void main(String[] args) {
		// Tiene que instaciar el contexto de Spring 
			
		AnnotationConfigApplicationContext context 
				= new AnnotationConfigApplicationContext(ConfiguracionSpring.class);
		
		// y acceder a el para buscar los Beans
		
		//Saludador saludador = context.getBean(Saludador.class);
		//Saludador bean2 = (Saludador) context.getBean("primerSaludador");
		Saludador saludador = context.getBean("primerSaludador", Saludador.class);
		
		// usamos el bean obtenido del contenedor
		
		saludador.saludar();

	}

}
