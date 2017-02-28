package com.atsistemas.curso;

import org.springframework.context.ApplicationListener;

public class Escuchador implements ApplicationListener<MiEvento>{

	public void onApplicationEvent(MiEvento event) {
		//Logica a ejecutar cuando se produca el evento
		System.out.println(event.getSource());
		
	}

}
