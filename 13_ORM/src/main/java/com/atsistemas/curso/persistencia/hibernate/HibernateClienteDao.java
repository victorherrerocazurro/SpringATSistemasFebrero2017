package com.atsistemas.curso.persistencia.hibernate;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.atsistemas.curso.entidades.Cliente;
import com.atsistemas.curso.persistencia.ClienteDao;

public class HibernateClienteDao implements ClienteDao {

	private Session session;

	public HibernateClienteDao(Session session) {
		super();
		this.session = session;
	}

	public void insertar(Cliente entidad) {
		session.persist(entidad);
		session.flush();
	}

	public Cliente consultarPorId(long id) {
		return session.find(Cliente.class, id);
	}

	public Collection<Cliente> consultarTodos() {
		return session.createQuery("from Cliente", Cliente.class)
													.getResultList();
	}

	public List<Cliente> consultarPorNombre(String nombre) {
		Query<Cliente> query = session.createQuery(
								"from Cliente c where c.nombre = :n", 
								Cliente.class);
		query.setParameter("n", nombre);

		return query.getResultList();
	}

}
