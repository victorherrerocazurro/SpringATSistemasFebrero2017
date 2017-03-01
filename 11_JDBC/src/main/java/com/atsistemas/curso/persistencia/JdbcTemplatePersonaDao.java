package com.atsistemas.curso.persistencia;

import java.util.Collection;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.atsistemas.curso.entidades.Persona;

public class JdbcTemplatePersonaDao extends JdbcDaoSupport implements PersonaDao {
	
	private static final String INSERT_PERSONA = "INSERT INTO PERSONA(ID, NOMBRE) VALUES(?,?)";
	private static final String SELECT_TODAS_PERSONAS = "SELECT * FROM PERSONA";
	
	public void insertar(Persona persona) {
		getJdbcTemplate().update(INSERT_PERSONA, persona.getId(), persona.getNombre());
	}

	public List<Persona> consultarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	public Persona consultarPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Persona> consultarTodos() {
		List<Persona> resultado = getJdbcTemplate().query(SELECT_TODAS_PERSONAS, new PersonaRowMapper());
		return resultado;
	}

}
