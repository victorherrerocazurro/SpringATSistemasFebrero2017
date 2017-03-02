package com.atsistemas.curso.persistencia.jdbc.springtemplate;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.atsistemas.curso.entidades.Persona;
import com.atsistemas.curso.persistencia.PersonaDao;

@Component
public class JdbcTemplatePersonaDao implements PersonaDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcTemplatePersonaDao(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	private static final String INSERT_PERSONA = "INSERT INTO PERSONA(ID, NOMBRE, ALTURA, EDAD, GENERO) VALUES(?,?,?,?,?)";
	private static final String SELECT_TODAS_PERSONAS = "SELECT * FROM PERSONA";
	private static final String SELECT_PERSONAS_BY_NOMBRE = "SELECT * FROM PERSONA WHERE NOMBRE = ?";
	private static final String SELECT_PERSONAS_BY_ID = "SELECT * FROM PERSONA WHERE ID = ?";

	public void insertar(Persona persona) {
		getJdbcTemplate().update(INSERT_PERSONA, persona.getId(), persona.getNombre(), persona.getAltura(),
				persona.getEdad(), persona.getGenero());

	}

	public List<Persona> consultarPorNombre(String nombre) {
		List<Persona> resultado = getJdbcTemplate().query(SELECT_PERSONAS_BY_NOMBRE, new Object[] { nombre },
				new PersonaRowMapper());
		return resultado;
	}

	public Persona consultarPorId(long id) {
		Persona persona = getJdbcTemplate().queryForObject(SELECT_PERSONAS_BY_ID, new Object[] { id },
				new PersonaRowMapper());
		return persona;
	}

	public Collection<Persona> consultarTodos() {
		List<Persona> resultado = getJdbcTemplate().query(SELECT_TODAS_PERSONAS, new PersonaRowMapper());
		return resultado;
	}

}
