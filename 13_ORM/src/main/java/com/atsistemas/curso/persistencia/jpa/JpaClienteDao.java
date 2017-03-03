package com.atsistemas.curso.persistencia.jpa;

import java.util.Collection;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.atsistemas.curso.entidades.Cliente;
import com.atsistemas.curso.persistencia.ClienteDao;

@Named
@Transactional
public class JpaClienteDao implements ClienteDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void insertar(Cliente entidad) {
		entityManager.persist(entidad);
	}

	public Cliente consultarPorId(long id) {
		return entityManager.find(Cliente.class, id);
	}

	public Collection<Cliente> consultarTodos() {
		return entityManager.createQuery("from Cliente", Cliente.class)
				.getResultList();
	}

	public List<Cliente> consultarPorNombre(String nombre) {
		TypedQuery<Cliente> query = entityManager.createQuery(
							"from Cliente c where c.nombre = :n", 
							Cliente.class);
		
		query.setParameter("n", nombre);
		
		return query.getResultList();
	}

}
