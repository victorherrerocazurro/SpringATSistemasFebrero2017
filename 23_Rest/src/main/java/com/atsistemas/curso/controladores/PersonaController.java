package com.atsistemas.curso.controladores;

import java.util.LinkedList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atsistemas.curso.entidades.Persona;

@RestController
@RequestMapping(
		path="/Persona", 
		//La respuesta, el @ResponseBody
		produces= {
				MediaType.APPLICATION_JSON_VALUE, 
				MediaType.APPLICATION_XML_VALUE
		},
		consumes={
				MediaType.APPLICATION_JSON_VALUE, 
				MediaType.APPLICATION_XML_VALUE
		}
)
public class PersonaController {

	@RequestMapping(method=RequestMethod.GET, consumes=MediaType.ALL_VALUE)
	public List<Persona> consultar(@RequestParam(required=false) Integer edad){
		
		LinkedList<Persona> personas = new LinkedList<>();
		
		if(edad!= null){
			// TODO Consultar por edad
			personas.add(new Persona(1, "Juan", edad, 1.70, "Hombre"));
		} else {
			// TODO Consultar Todos
			personas.add(new Persona(1, "Juan", 21, 1.70, "Hombre"));
			personas.add(new Persona(2, "Maria", 34, 1.60, "Mujer"));
		}
		
		return personas;
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET, consumes=MediaType.ALL_VALUE)
	public Persona consultarPorId(@PathVariable long id){
		return new Persona(id, "Pedro", 35, 1.70, "Hombre");
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void insertar(@RequestBody Persona persona){
		// TODO retornar codigos de respuesta y location
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public void actualizar(@RequestBody Persona persona){
		// TODO retornar codigos de respuesta y location
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public void borrarPorId(@PathVariable long id){
		// TODO retornar codigos de respuesta y location
	}
}
