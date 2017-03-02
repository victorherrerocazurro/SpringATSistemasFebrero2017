package com.atsistemas.curso.persistencia.hibernate;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.atsistemas.curso.entidades.Factura;
import com.atsistemas.curso.persistencia.FacturaDao;

public class HibernateFacturaDao implements FacturaDao{

	private Session session;
	
	public HibernateFacturaDao(Session session) {
		super();
		this.session = session;
	}

	public void insertar(Factura entidad) {
		session.persist(entidad);
	}

	public Factura consultarPorId(long id) {
		return session.find(Factura.class, id);
	}

	public Collection<Factura> consultarTodos() {
		return session.createQuery(
							"from Factura", 
							Factura.class).getResultList();
	}

	public List<Factura> consultarPorCantidad(float cantidad) {
		Query<Factura> query = session.createQuery(
					"from Factura f where f.cantidad = :c", 
					Factura.class);
		query.setParameter("c", cantidad);
		
		return query.getResultList();
	}

}
