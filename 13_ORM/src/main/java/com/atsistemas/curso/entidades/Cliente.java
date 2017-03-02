package com.atsistemas.curso.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTES")
//@Access(AccessType.PROPERTY)
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	@Column(name="NOMBRE")
	private String nombre;
	
	//"cliente" es el nombre del campo que tenemos en Factura
	@OneToMany(mappedBy="cliente")
	// En caso de mapeo unidireccional, habria que indicar con @JoinColumn
	// en nombre del campo de la tabla FACTURAS que mantiene la FK sobre
	// la tabla CLIENTES
	//@JoinColumn(name="ID_CLIENTE")
	private List<Factura> facturas;
	
	// Por que al usar Hibernate, este nos lo exige, 
	// es el unico que es capaz de emplear
	public Cliente() {
		super();
	}

	public Cliente(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public Cliente(String nombre, List<Factura> facturas) {
		super();
		this.nombre = nombre;
		this.facturas = facturas;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", facturas=" + facturas + "]";
	}
	
}
