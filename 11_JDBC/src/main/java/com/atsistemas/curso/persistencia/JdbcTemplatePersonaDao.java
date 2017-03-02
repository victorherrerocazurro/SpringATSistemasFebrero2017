package com.atsistemas.curso.persistencia;

import java.util.Collection;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.atsistemas.curso.entidades.Persona;

public class JdbcTemplatePersonaDao extends JdbcDaoSupport implements PersonaDao {
	
	private static final String INSERT_PERSONA = "INSERT INTO PERSONA(ID, NOMBRE) VALUES(?,?)";
	private static final String SELECT_TODAS_PERSONAS = "SELECT * FROM PERSONA";
	private static final String SELECT_PERSONAS_BY_NOMBRE = "SELECT * FROM PERSONA WHERE NOMBRE = ?";
	private static final String SELECT_PERSONAS_BY_ID = "SELECT * FROM PERSONA WHERE ID = ?";
	
	/*public JdbcTemplatePersonaDao(JdbcTemplate jdbcTemplate) {
		super();
		setJdbcTemplate(jdbcTemplate);
	}*/

	public void insertar(Persona persona) {
		getJdbcTemplate().update(INSERT_PERSONA, persona.getId(), persona.getNombre());
	}

	public List<Persona> consultarPorNombre(String nombre) {
		List<Persona> resultado = getJdbcTemplate().query(
								SELECT_PERSONAS_BY_NOMBRE, 
								new Object[]{nombre}, 
								new PersonaRowMapper());
		return resultado;
	}

	public Persona consultarPorId(long id) {
		Persona persona = getJdbcTemplate().queryForObject(
								SELECT_PERSONAS_BY_ID, 
								new Object[]{id}, 
								new PersonaRowMapper());
		return persona;
	}

	public Collection<Persona> consultarTodos() {
		List<Persona> resultado = getJdbcTemplate().query(
								SELECT_TODAS_PERSONAS, 
								new PersonaRowMapper());
		return resultado;
	}

}
