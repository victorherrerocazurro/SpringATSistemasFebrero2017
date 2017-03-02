package com.atsistemas.curso.persistencia.jdbc.springtemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.atsistemas.curso.entidades.Persona;

public class PersonaRowMapper implements RowMapper<Persona> {

	public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Persona(
				rs.getLong("ID"),
				rs.getString("NOMBRE"),
				rs.getInt("EDAD"),
				rs.getFloat("ALTURA"),
				rs.getString("GENERO"));
	}

}
