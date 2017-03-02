package com.atsistemas.curso.persistencia.hibernate;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atsistemas.curso.entidades.Cliente;
import com.atsistemas.curso.persistencia.ClienteDao;

@Component
@Transactional
public class HibernateClienteDao implements ClienteDao {
	
	private SessionFactory sessionFactory;

	@Autowired
	public HibernateClienteDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public void insertar(Cliente entidad) {
		sessionFactory.getCurrentSession().persist(entidad);
		sessionFactory.getCurrentSession().flush();
	}

	public Cliente consultarPorId(long id) {
		return sessionFactory.getCurrentSession().find(Cliente.class, id);
	}

	public Collection<Cliente> consultarTodos() {
		return sessionFactory.getCurrentSession().createQuery("from Cliente", Cliente.class)
													.getResultList();
	}

	public List<Cliente> consultarPorNombre(String nombre) {
		Query<Cliente> query = sessionFactory.getCurrentSession().createQuery(
								"from Cliente c where c.nombre = :n", 
								Cliente.class);
		query.setParameter("n", nombre);

		return query.getResultList();
	}

}
