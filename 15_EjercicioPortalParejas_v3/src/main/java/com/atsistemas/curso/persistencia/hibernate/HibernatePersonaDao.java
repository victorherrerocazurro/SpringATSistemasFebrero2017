package com.atsistemas.curso.persistencia.hibernate;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atsistemas.curso.entidades.Persona;
import com.atsistemas.curso.persistencia.PersonaDao;

@Component
@Transactional
public class HibernatePersonaDao implements PersonaDao {

	private SessionFactory sessionFactory;

	@Autowired
	public HibernatePersonaDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public void insertar(Persona persona) {
		sessionFactory.getCurrentSession().persist(persona);
	}

	public List<Persona> consultarPorNombre(String nombre) {
		Query<Persona> query = sessionFactory.getCurrentSession()
					.createQuery("from Persona p where p.nombre = :n",
				Persona.class);
		query.setParameter("n", nombre);

		return query.getResultList();
	}

	public Persona consultarPorId(long id) {
		return sessionFactory.getCurrentSession().find(Persona.class, id);
	}

	public Collection<Persona> consultarTodos() {
		return sessionFactory.getCurrentSession().createQuery(
				"from Persona", 
				Persona.class).getResultList();
	}

}
