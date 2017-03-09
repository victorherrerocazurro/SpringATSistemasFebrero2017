package com.atsistemas.curso.dto;

import java.util.LinkedList;
import java.util.List;

import com.atsistemas.curso.entidades.Factura;

public class FacturaDto {
	private long id;
	private double cantidad;
	public FacturaDto(long id, double cantidad) {
		super();
		this.id = id;
		this.cantidad = cantidad;
	}
	public FacturaDto(Factura factura) {
		super();
		this.id = factura.getId();
		this.cantidad = factura.getCantidad();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	public Factura toFactura(){
		return new Factura(this.cantidad);
	}
	
	public static List<FacturaDto> toFacturasDto(List<Factura> facturas) {
		LinkedList<FacturaDto> facturasDto = new LinkedList<>();
		
		for (Factura factura : facturas) {
			facturasDto.add(new FacturaDto(factura));
		}
		
		return facturasDto;
	}
}
