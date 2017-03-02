package com.atsistemas.curso;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atsistemas.curso.entidades.Cliente;
import com.atsistemas.curso.entidades.Factura;
import com.atsistemas.curso.persistencia.ClienteDao;
import com.atsistemas.curso.persistencia.FacturaDao;

public class Aplicacion {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.atsistemas.curso");
		
		FacturaDao dao = context.getBean(FacturaDao.class);
		ClienteDao clienteDao = context.getBean(ClienteDao.class);
		
		Cliente cliente = new Cliente("Victor");
		
		System.out.println("El objeto Cliente no tiene ID todavia: " + cliente);
		
		Factura factura = new Factura(33.000f, cliente);
		
		System.out.println("El objeto Factura, esta asociado al Cliente, aunque el Cliente no tiene ID todavia");
		
		//clienteDao.insertar(cliente);
		
		dao.insertar(factura);
		
		context.close();
		
	}

}
