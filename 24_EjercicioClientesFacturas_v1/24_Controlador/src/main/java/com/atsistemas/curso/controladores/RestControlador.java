package com.atsistemas.curso.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atsistemas.curso.entidades.Cliente;
import com.atsistemas.curso.entidades.Factura;
import com.atsistemas.curso.servicios.Servicio;

@RestController
public class RestControlador{

	private Servicio servicio;

	@Autowired
	public RestControlador(Servicio servicio) {
		super();
		this.servicio = servicio;
	}

	public ResponseEntity<Factura> altaFactura(Factura factura) {
		servicio.altaFactura(factura);
		return new ResponseEntity<Factura>(HttpStatus.CREATED);
	}

	public void altaCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	public void bajaFactura(long id) {
		// TODO Auto-generated method stub
		
	}

	public void bajaCliente(long id) {
		// TODO Auto-generated method stub
		
	}

	public void actualizarFactura(Factura factura) {
		// TODO Auto-generated method stub
		
	}

	public void actualizarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	public Factura obtenerFactura(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Cliente obtenerCliente(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Factura> obtenerFacturas() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Cliente> obtenerClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Factura> obtenerFacturasCliente(long idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	public Cliente obtenerClienteDeFactura(long idFactura) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
