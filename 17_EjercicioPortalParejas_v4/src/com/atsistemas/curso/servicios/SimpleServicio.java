package com.atsistemas.curso.servicios;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atsistemas.curso.entidades.Persona;
import com.atsistemas.curso.negocio.Negocio;
import com.atsistemas.curso.persistencia.jpa.data.PersonaDao;

@Component
public class SimpleServicio implements Servicio {

	private PersonaDao dao;
	private Negocio negocio;

	@Autowired
	public SimpleServicio(PersonaDao dao, Negocio negocio) {
		super();
		this.dao = dao;
		this.negocio = negocio;
	}

	public void altaUsuario(Persona persona) {
		dao.save(persona);
	}

	public List<Persona> busquedaAfines(Persona persona) {

		Collection<Persona> candidatos = dao.findAll();

		List<Persona> afines = new LinkedList<Persona>();

		for (Persona candidata : candidatos) {
			if (negocio.esAfin(persona, candidata)) {
				afines.add(candidata);
			}
		}

		return afines;
	}

	public Persona busquedaIdeal(Persona persona) {
		Collection<Persona> candidatos = dao.findAll();

		for (Persona candidata : candidatos) {
			if (negocio.esIdeal(persona, candidata)) {
				return candidata;
			}
		}
		
		return null;
	}

	@Override
	public Persona buscarPersonaPorId(long id) {
		return dao.findOne(id);
	}

}
