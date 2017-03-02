package com.atsistemas.curso.persistencia;

import java.util.List;

import com.atsistemas.curso.entidades.Cliente;

public interface ClienteDao extends Dao<Cliente>{
	List<Cliente> consultarPorNombre(String nombre);
}
