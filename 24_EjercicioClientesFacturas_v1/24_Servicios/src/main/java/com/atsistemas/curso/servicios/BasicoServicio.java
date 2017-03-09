package com.atsistemas.curso.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.atsistemas.curso.dto.ClienteDto;
import com.atsistemas.curso.dto.FacturaDto;
import com.atsistemas.curso.persistencia.ClienteDao;
import com.atsistemas.curso.persistencia.FacturaDao;

@Component
@Transactional
public class BasicoServicio implements Servicio {

	private FacturaDao facturaDao;
	private ClienteDao clienteDao;
	
	@Autowired
	public BasicoServicio(FacturaDao facturaDao, ClienteDao clienteDao) {
		super();
		this.facturaDao = facturaDao;
		this.clienteDao = clienteDao;
	}

	public void altaFactura(FacturaDto factura) {
		facturaDao.save(factura.toFactura());
	}

	public void altaCliente(ClienteDto cliente) {
		clienteDao.save(cliente.toCliente());
	}

	public void bajaFactura(long id) {
		facturaDao.delete(id);
	}

	public void bajaCliente(long id) {
		clienteDao.delete(id);
	}

	public void actualizarFactura(FacturaDto factura) {
		facturaDao.save(factura.toFactura());
	}

	public void actualizarCliente(ClienteDto cliente) {
		clienteDao.save(cliente.toCliente());
	}

	public FacturaDto obtenerFactura(long id) {
		return new FacturaDto(facturaDao.findOne(id));
	}

	public ClienteDto obtenerCliente(long id) {
		return new ClienteDto(clienteDao.findOne(id));
	}

	public List<FacturaDto> obtenerFacturas() {
		return FacturaDto.toFacturasDto(facturaDao.findAll());
	}

	public List<ClienteDto> obtenerClientes() {
		return ClienteDto.toClientesDto(clienteDao.findAll());
	}

	public List<FacturaDto> obtenerFacturasCliente(long idCliente) {
		return FacturaDto.toFacturasDto(clienteDao.findOne(idCliente).getFacturas());
	}

	public ClienteDto obtenerClienteDeFactura(long idFactura) {
		return new ClienteDto(facturaDao.findOne(idFactura).getCliente());
	}

}
