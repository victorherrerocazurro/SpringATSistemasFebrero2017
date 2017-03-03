package com.atsistemas.curso.persistencia.jpa;

import java.util.Collection;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.atsistemas.curso.entidades.Factura;
import com.atsistemas.curso.persistencia.FacturaDao;

@Named
@Transactional
public class JpaFacturaDao implements FacturaDao{
	@PersistenceContext
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void insertar(Factura entidad) {
		entityManager.persist(entidad);
	}

	public Factura consultarPorId(long id) {
		return entityManager.find(Factura.class, id);
	}

	public Collection<Factura> consultarTodos() {
		return entityManager.createQuery(
							"from " + Factura.class.getSimpleName(), 
							Factura.class).getResultList();
	}

	public List<Factura> consultarPorCantidad(float cantidad) {
		TypedQuery<Factura> query = entityManager.createQuery(
					"from Factura f where f.cantidad = :c", 
					Factura.class);
		query.setParameter("c", cantidad);
		
		return query.getResultList();
	}
}
