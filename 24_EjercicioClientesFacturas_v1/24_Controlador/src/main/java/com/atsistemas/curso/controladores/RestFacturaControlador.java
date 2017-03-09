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
@RequestMapping("/Factura")
public class RestFacturaControlador {

	private Servicio servicio;

	@Autowired
	public RestFacturaControlador(Servicio servicio) {
		super();
		this.servicio = servicio;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<FacturaDto> altaFactura(@RequestBody FacturaDto factura, HttpServletRequest request) throws URISyntaxException {
		servicio.altaFactura(factura);
		HttpHeaders cabeceras = new HttpHeaders();

		cabeceras.setLocation(new URI(request.getRequestURL().append("/").append(factura.getId()).toString()));
		return new ResponseEntity<FacturaDto>(cabeceras, HttpStatus.CREATED);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<FacturaDto> bajaFactura(@PathVariable long id) {
		servicio.bajaFactura(id);
		return new ResponseEntity<FacturaDto>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<FacturaDto> actualizarFactura(@RequestBody FacturaDto factura) {
		servicio.actualizarFactura(factura);
		return new ResponseEntity<FacturaDto>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<FacturaDto> obtenerFactura(@PathVariable long id) {
		FacturaDto factura = servicio.obtenerFactura(id);
		return new ResponseEntity<FacturaDto>(factura, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<FacturaDto>> obtenerFacturas() {
		List<FacturaDto> facturas = servicio.obtenerFacturas();
		return new ResponseEntity<List<FacturaDto>>(facturas, HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}/Cliente", method = RequestMethod.GET)
	public ResponseEntity<ClienteDto> obtenerClienteDeFactura(@PathVariable("id") long idFactura) {
		ClienteDto cliente = servicio.obtenerClienteDeFactura(idFactura);
		return new ResponseEntity<ClienteDto>(cliente, HttpStatus.OK);
	}

}
