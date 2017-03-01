package com.atsistemas.curso.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.atsistemas.curso.entidades.Persona;

public class JdbcPersonaDao implements PersonaDao {

	private static final String DB_DRIVER = "org.apache.derby.jdbc.ClientDriver";
	private static final String DB_CONNECTION = "jdbc:derby://localhost:1527/PortalParejas";
	private static final String DB_USER = "admin";
	private static final String DB_PASSWORD = "admin";
	private static final String INSERT_PERSONA = "INSERT INTO PERSONA(ID, NOMBRE) VALUES(?,?)";
	private static final String SELECT_TODAS_PERSONAS = "SELECT * FROM PERSONA";

	public void insertar(Persona persona) {
		Connection dbConnection = null;

		try {
			Class.forName(DB_DRIVER);
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);

			PreparedStatement preparedStatement = dbConnection.prepareStatement(INSERT_PERSONA);

			preparedStatement.setLong(1, persona.getId());
			preparedStatement.setString(2, persona.getNombre());

			// execute insert SQL statement
			preparedStatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

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
		Connection dbConnection = null;

		List<Persona> resultado = new LinkedList<Persona>();
		
		try {
			Class.forName(DB_DRIVER);
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);

			PreparedStatement preparedStatement = dbConnection.prepareStatement(SELECT_TODAS_PERSONAS);

			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				Persona persona = new Persona(
						rs.getLong("ID"),
						rs.getString("NOMBRE"));
				
				resultado.add(persona);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultado;
	}

}
