package com.atsistemas.curso.aplicacion.jpa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atsistemas.curso.entidades.Cliente;
import com.atsistemas.curso.entidades.Factura;
import com.atsistemas.curso.negocio.DummyNegocio;

public class AplicacionJpa {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.atsistemas.curso.aplicacion.jpa");
		
		/*FacturaDao facturaDao = context.getBean(FacturaDao.class);
		ClienteDao clienteDao = context.getBean(ClienteDao.class);*/
		
		DummyNegocio negocio = context.getBean(DummyNegocio.class);
		
		Cliente cliente = new Cliente("Victor");
		
		System.out.println("El objeto Cliente no tiene ID todavia: " + cliente);
		
		Factura factura = new Factura(33.000f, cliente);
		
		System.out.println("El objeto Factura, esta asociado al Cliente, aunque el Cliente no tiene ID todavia");
		
		negocio.altaClienteYFatura(cliente, factura);
		
		/*clienteDao.insertar(cliente);
		
		facturaDao.insertar(factura);*/
		
		context.close();
		
	}

}
