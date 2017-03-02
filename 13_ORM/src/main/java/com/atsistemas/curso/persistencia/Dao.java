package com.atsistemas.curso.persistencia;

import java.util.Collection;

public interface Dao<E> {
	void insertar(E entidad);
	E consultarPorId(long id);
	Collection<E> consultarTodos();
}
