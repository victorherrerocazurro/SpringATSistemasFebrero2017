package com.atsistemas.curso.negocio;

import org.springframework.stereotype.Component;

import com.atsistemas.curso.entidades.Persona;

@Component
public class BasadoEnNombreNegocio implements Negocio {

	public boolean esAfin(Persona target, Persona candidata) {
		return !target.equals(candidata) && target.getNombre().toUpperCase().charAt(0) 
						== candidata.getNombre().toUpperCase().charAt(0);
	}

	public boolean esIdeal(Persona target, Persona candidata) {
		return !target.equals(candidata) && target.getNombre().equals(candidata.getNombre());
	}

}
