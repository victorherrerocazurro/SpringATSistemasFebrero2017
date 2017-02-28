package com.atsistemas.curso;

import java.util.List;

public interface PersonaDao {
	//Metodo que persistira en la BD el usuario
	void insertar(Persona persona);
	void borrar(Persona persona);
	void modificar(Persona persona);
	List<Persona> consultar();
	Persona consultar(Long pk);
	// ....
}
