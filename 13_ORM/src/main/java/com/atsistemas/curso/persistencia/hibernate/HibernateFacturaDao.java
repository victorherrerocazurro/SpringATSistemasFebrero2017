package com.atsistemas.curso.persistencia.hibernate;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atsistemas.curso.entidades.Factura;
import com.atsistemas.curso.persistencia.FacturaDao;

@Component
@Transactional
public class HibernateFacturaDao implements FacturaDao{

	private SessionFactory sessionFactory;
	
	@Autowired
	public HibernateFacturaDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public void insertar(Factura entidad) {
		sessionFactory.getCurrentSession().persist(entidad);
	}

	public Factura consultarPorId(long id) {
		return sessionFactory.getCurrentSession().find(Factura.class, id);
	}

	public Collection<Factura> consultarTodos() {
		return sessionFactory.getCurrentSession().createQuery(
							"from Factura", 
							Factura.class).getResultList();
	}

	public List<Factura> consultarPorCantidad(float cantidad) {
		Query<Factura> query = sessionFactory.getCurrentSession().createQuery(
					"from Factura f where f.cantidad = :c", 
					Factura.class);
		query.setParameter("c", cantidad);
		
		return query.getResultList();
	}

}
