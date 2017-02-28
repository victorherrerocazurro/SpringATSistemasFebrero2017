package com.atsistemas.curso;

public class SaludadorErrorImpl implements Saludador{

	@Override
	public void saludar() {
		System.err.println("Hola Mundo!!!!!");
		
	}

}
