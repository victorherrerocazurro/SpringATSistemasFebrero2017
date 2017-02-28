package com.atsistemas.curso.persistencia.memoria;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.atsistemas.curso.entidades.Persona;
import com.atsistemas.curso.persistencia.PersonaDao;

@Component
public class MemoriaPersonaDao implements PersonaDao {

	private Map<Long, Persona> tablaPersonas;
	
	@Autowired
	public MemoriaPersonaDao(@Qualifier("tablaPersonas") Map<Long, Persona> tablaPersonas) {
		super();
		this.tablaPersonas = tablaPersonas;
	}

	public void insertar(Persona persona) {
		tablaPersonas.put(persona.getId(), persona);
	}

	public List<Persona> consultarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	public Persona consultarPorId(long id) {
		return tablaPersonas.get(id);
	}

	public Collection<Persona> consultarTodos() {
		return tablaPersonas.values();
	}

}
