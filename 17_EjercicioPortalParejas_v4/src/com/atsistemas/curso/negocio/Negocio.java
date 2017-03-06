package com.atsistemas.curso.negocio;

import com.atsistemas.curso.entidades.Persona;

public interface Negocio {
	boolean esAfin(Persona target, Persona candidata);
	boolean esIdeal(Persona target, Persona candidata);
}
