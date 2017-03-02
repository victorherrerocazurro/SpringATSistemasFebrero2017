package com.atsistemas.curso.persistencia;

import java.util.List;

import com.atsistemas.curso.entidades.Factura;

public interface FacturaDao extends Dao<Factura>{
	List<Factura> consultarPorCantidad(float cantidad);
}
