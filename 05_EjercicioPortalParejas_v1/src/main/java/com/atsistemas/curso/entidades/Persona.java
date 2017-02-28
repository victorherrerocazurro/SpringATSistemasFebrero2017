package com.atsistemas.curso.entidades;

import java.io.Serializable;

public class Persona implements Serializable{

	private long id;
	private String nombre;	
	
	//Porque probablemente emplee esta clase con un Framework que precise
	//construir los objetos con el construtor por defecto
	public Persona() {
		super();
	}
	
	// Lo pongo por comodidad
	public Persona(long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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
		Persona other = (Persona) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + "]";
	}	
	
}
