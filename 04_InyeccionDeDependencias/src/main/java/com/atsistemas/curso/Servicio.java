package com.atsistemas.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class Servicio {

	@Autowired
	private PersonaDao dao;
	private PersonaDao otro;
	
	public Servicio(){
		
	}
	
	@Autowired
	//Inyeccion por contruccion
	public Servicio(@Qualifier("memoriaPersonaDao") PersonaDao dao, 
					@Qualifier("memoriaPersonaDao") PersonaDao otro) {
		super();
		this.dao = dao;
	}

	//Inyeccion por Setter
	@Autowired
	public void setDao(@Qualifier("memoriaPersonaDao") PersonaDao dao) {
		this.dao = dao;
	}
	
	public void setOtro(PersonaDao dao) {
		this.otro = dao;
	}

	public void altaUsuario(String avatar, String mail, String password){
		
		//Nos acopla con la implementacion en Memoria
		//MemoriaPersonaDao dao = new MemoriaPersonaDao();
		
		//insertar en la BD la persona
		dao.insertar(new Persona(avatar, mail, password));
		
		//mandar correo electronico de confirmacion/activacion
		
	}
	
}
