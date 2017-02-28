package com.atsistemas.curso;

public class Aplicacion {

	public static void main(String[] args) {
		Contexto contexto = new Contexto();
		
		Servicio servicio = (Servicio) contexto.getBean("servicio");
		
		System.out.println(servicio.metodoInterceptado("23"));
		System.out.println(servicio.metodoNoInterceptado("23"));

		((Extension)servicio).metodoNuevo();
		
	}

}
