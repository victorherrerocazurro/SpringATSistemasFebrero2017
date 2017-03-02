package com.atsistemas.curso.entidades;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="FACTURAS")
//@Access(AccessType.PROPERTY)
public class Factura implements Serializable{
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	@Column(name="CANTIDAD")
	private double cantidad;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;
	
	public Factura() {
		super();
	}
	public Factura(double cantidad) {
		super();
		this.cantidad = cantidad;
	}
	public Factura(double cantidad, Cliente cliente) {
		super();
		this.cantidad = cantidad;
		this.cliente = cliente;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		Factura other = (Factura) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Factura [id=" + id + ", cantidad=" + cantidad + ", cliente=" + cliente + "]";
	}
}
