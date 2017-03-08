package com.atsistemas.curso.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atsistemas.curso.entidades.Cliente;
import com.atsistemas.curso.entidades.Factura;
import com.atsistemas.curso.persistencia.ClienteDao;
import com.atsistemas.curso.persistencia.FacturaDao;

@Component
public class BasicoServicio implements Servicio {

	private FacturaDao facturaDao;
	private ClienteDao clienteDao;
	
	@Autowired
	public BasicoServicio(FacturaDao facturaDao, ClienteDao clienteDao) {
		super();
		this.facturaDao = facturaDao;
		this.clienteDao = clienteDao;
	}

	public void altaFactura(Factura factura) {
		facturaDao.save(factura);
	}

	public void altaCliente(Cliente cliente) {
		clienteDao.save(cliente);
	}

	public void bajaFactura(long id) {
		facturaDao.delete(id);
	}

	public void bajaCliente(long id) {
		clienteDao.delete(id);
	}

	public void actualizarFactura(Factura factura) {
		facturaDao.save(factura);
	}

	public void actualizarCliente(Cliente cliente) {
		clienteDao.save(cliente);
	}

	public Factura obtenerFactura(long id) {
		return facturaDao.findOne(id);
	}

	public Cliente obtenerCliente(long id) {
		return clienteDao.findOne(id);
	}

	public List<Factura> obtenerFacturas() {
		return facturaDao.findAll();
	}

	public List<Cliente> obtenerClientes() {
		return clienteDao.findAll();
	}

	public List<Factura> obtenerFacturasCliente(long idCliente) {
		return clienteDao.findOne(idCliente).getFacturas();
	}

	public Cliente obtenerClienteDeFactura(long idFactura) {
		return facturaDao.findOne(idFactura).getCliente();
	}

}
