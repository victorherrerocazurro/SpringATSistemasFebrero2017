package com.atsistemas.curso.negocio;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atsistemas.curso.entidades.Cliente;
import com.atsistemas.curso.entidades.Factura;
import com.atsistemas.curso.persistencia.ClienteDao;
import com.atsistemas.curso.persistencia.FacturaDao;

@Component
@Transactional
public class DummyNegocio {

	@Autowired
	private ClienteDao clienteDao;
	
	@Autowired
	private FacturaDao facturaDao;
	
	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}
	
	public void setFacturaDao(FacturaDao facturaDao) {
		this.facturaDao = facturaDao;
	}

	public void altaClienteYFatura(Cliente cliente, Factura factura){
		clienteDao.save(cliente);
		
		cliente.setNombre("pepito grillo");
		
		System.out.println("Entre la insercion del cliente y la factura");
		
		facturaDao.save(factura);
	}
	
	/*public void modificarCliente(Cliente cliente){
		clienteDao.insertarHistorico(cliente);
		
		clienteDao.actualizar(cliente);
		//Mando un correo electronico
		//gestorCorreo.enviar(cliente.getEmail(),new CorreoEdicionPerfil(cliente));
	}*/
	
}
