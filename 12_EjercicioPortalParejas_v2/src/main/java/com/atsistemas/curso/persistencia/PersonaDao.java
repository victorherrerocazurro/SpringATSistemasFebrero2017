package com.atsistemas.curso.persistencia;

import java.util.Collection;
import java.util.List;

import com.atsistemas.curso.entidades.Persona;

public interface PersonaDao {
	void insertar(Persona persona);
	List<Persona> consultarPorNombre(String nombre);
	Persona consultarPorId(long id);
	Collection<Persona> consultarTodos();
}
