package com.atsistemas.curso.servicios;

import java.util.List;

import com.atsistemas.curso.entidades.Cliente;
import com.atsistemas.curso.entidades.Factura;

public interface Servicio {
	void altaFactura(Factura factura);
	void altaCliente(Cliente cliente);
	
	void bajaFactura(long id);
	void bajaCliente(long id);
	
	void actualizarFactura(Factura factura);
	void actualizarCliente(Cliente cliente);
	
	Factura obtenerFactura(long id);
	Cliente obtenerCliente(long id);
	
	List<Factura> obtenerFacturas();
	List<Cliente> obtenerClientes();
	
	List<Factura> obtenerFacturasCliente(long idCliente);
	
	Cliente obtenerClienteDeFactura(long idFactura);
}
