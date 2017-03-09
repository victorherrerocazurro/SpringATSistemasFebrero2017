package com.atsistemas.curso.servicios;

import java.util.List;

import com.atsistemas.curso.dto.ClienteDto;
import com.atsistemas.curso.dto.FacturaDto;

public interface Servicio {
	void altaFactura(FacturaDto factura);
	void altaCliente(ClienteDto cliente);
	
	void bajaFactura(long id);
	void bajaCliente(long id);
	
	void actualizarFactura(FacturaDto factura);
	void actualizarCliente(ClienteDto cliente);
	
	FacturaDto obtenerFactura(long id);
	ClienteDto obtenerCliente(long id);
	
	List<FacturaDto> obtenerFacturas();
	List<ClienteDto> obtenerClientes();
	
	List<FacturaDto> obtenerFacturasCliente(long idCliente);
	
	ClienteDto obtenerClienteDeFactura(long idFactura);
}
