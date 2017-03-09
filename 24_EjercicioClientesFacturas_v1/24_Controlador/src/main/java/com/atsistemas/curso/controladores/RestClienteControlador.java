package com.atsistemas.curso.controladores;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atsistemas.curso.dto.ClienteDto;
import com.atsistemas.curso.dto.FacturaDto;
import com.atsistemas.curso.entidades.Cliente;
import com.atsistemas.curso.entidades.Factura;
import com.atsistemas.curso.servicios.Servicio;

@RestController
@RequestMapping("/Cliente")
public class RestClienteControlador {

	private Servicio servicio;

	@Autowired
	public RestClienteControlador(Servicio servicio) {
		super();
		this.servicio = servicio;
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<ClienteDto> altaCliente(@RequestBody ClienteDto cliente, HttpServletRequest request) throws URISyntaxException {
		servicio.altaCliente(cliente);
		HttpHeaders cabeceras = new HttpHeaders();

		cabeceras.setLocation(new URI(request.getRequestURL().append("/").append(cliente.getId()).toString()));
		return new ResponseEntity<ClienteDto>(cabeceras, HttpStatus.CREATED);

	}

	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<ClienteDto> bajaCliente(@PathVariable long id) {
		servicio.bajaCliente(id);
		return new ResponseEntity<ClienteDto>(HttpStatus.ACCEPTED);

	}

	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<ClienteDto> actualizarCliente(@RequestBody ClienteDto cliente) {
		servicio.actualizarCliente(cliente);
		return new ResponseEntity<ClienteDto>(HttpStatus.ACCEPTED);

	}

	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public ResponseEntity<ClienteDto> obtenerCliente(@PathVariable long id) {
		ClienteDto cliente = servicio.obtenerCliente(id);
		return new ResponseEntity<ClienteDto>(cliente, HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ClienteDto>> obtenerClientes() {
		List<ClienteDto> clientes = servicio.obtenerClientes();
		return new ResponseEntity<List<ClienteDto>>(clientes, HttpStatus.OK);
	}
	
	@RequestMapping(path="/{id}/Facturas", method=RequestMethod.GET)
	public ResponseEntity<List<FacturaDto>> obtenerFacturasCliente(@PathVariable("id") long idCliente) {
		List<FacturaDto> facturas = servicio.obtenerFacturasCliente(idCliente);
		return new ResponseEntity<List<FacturaDto>>(facturas, HttpStatus.OK);
	}

}
