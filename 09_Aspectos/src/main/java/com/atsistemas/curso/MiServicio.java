package com.atsistemas.curso;

public class MiServicio implements Servicio{

	public String metodoInterceptado(String numero) {
		return "prefijo " + numero + " sufijo!!!";
	}

	public String metodoNoInterceptado(String numero) {
		return "prefijo " + numero + " sufijo!!!";
	}

}
