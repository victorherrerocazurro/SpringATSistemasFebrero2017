package com.atsistemas.curso.dto;

import java.util.LinkedList;
import java.util.List;

import com.atsistemas.curso.entidades.Cliente;
import com.atsistemas.curso.entidades.Factura;

public class ClienteDto {
	private long id;
	private String nombre;
	private List<FacturaDto> facturas;
	
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
	public List<FacturaDto> getFacturas() {
		return facturas;
	}
	public void setFacturas(List<FacturaDto> facturas) {
		this.facturas = facturas;
	}
	public ClienteDto(long id, String nombre, List<FacturaDto> facturas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.facturas = facturas;
	}
	
	public ClienteDto(Cliente cliente){
		this.id = cliente.getId();
		this.nombre = cliente.getNombre();
		this.facturas = FacturaDto.toFacturasDto(cliente.getFacturas());
	}
	
	public Cliente toCliente(){
		return new Cliente(this.nombre, toFacturas());
	}
	
	private List<Factura> toFacturas() {
		
		LinkedList<Factura> facturas = new LinkedList<>();
		
		for (FacturaDto factura : this.facturas) {
			facturas.add(new Factura(factura.getCantidad(), null));
		}
		
		return facturas;
	}
	
	public static List<ClienteDto> toClientesDto(List<Cliente> clientes) {
		LinkedList<ClienteDto> clienteDto = new LinkedList<>();
		
		for (Cliente cliente : clientes) {
			clienteDto.add(new ClienteDto(cliente.getId(), cliente.getNombre(), FacturaDto.toFacturasDto(cliente.getFacturas())));
		}
		
		return clienteDto;
	}
}


