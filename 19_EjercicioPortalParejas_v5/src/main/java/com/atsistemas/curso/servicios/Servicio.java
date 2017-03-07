package com.atsistemas.curso.servicios;

import java.util.List;

import com.atsistemas.curso.entidades.Persona;

public interface Servicio {
	void altaUsuario(Persona persona);
	List<Persona> busquedaAfines(Persona persona);
	Persona busquedaIdeal(Persona persona);
	Persona buscarPersonaPorId(long parseLong);
}
