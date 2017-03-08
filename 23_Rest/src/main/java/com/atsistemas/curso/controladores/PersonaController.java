package com.atsistemas.curso.controladores;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
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
	public ResponseEntity<List<Persona>> consultar(@RequestParam(required=false) Integer edad){
		
		LinkedList<Persona> personas = new LinkedList<>();
		
		if(edad!= null){
			// TODO Consultar por edad
			personas.add(new Persona(1, "Juan", edad, 1.70, "Hombre"));
		} else {
			// TODO Consultar Todos
			personas.add(new Persona(1, "Juan", 21, 1.70, "Hombre"));
			personas.add(new Persona(2, "Maria", 34, 1.60, "Mujer"));
		}
		
		return new ResponseEntity<>(personas, HttpStatus.OK);
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET, consumes=MediaType.ALL_VALUE)
	public ResponseEntity<Persona> consultarPorId(@PathVariable long id){
		return new ResponseEntity<>(new Persona(id, "Pedro", 35, 1.70, "Hombre"), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity insertar(@RequestBody Persona persona, HttpServletRequest request) throws URISyntaxException{
		// TODO retornar codigos de respuesta y location
		System.out.println(persona);
		HttpHeaders cabeceras = new HttpHeaders();
		
		cabeceras.setLocation(
					new URI(
							request.getRequestURL()
										.append("/")
										.append(persona.getId()).toString()));
		
		return new ResponseEntity<>(cabeceras, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity actualizar(@RequestBody Persona persona){
		// TODO retornar codigos de respuesta
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity borrarPorId(@PathVariable long id){
		// TODO retornar codigos de respuesta
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
