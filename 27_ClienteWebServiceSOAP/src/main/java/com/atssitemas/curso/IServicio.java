package com.atssitemas.curso;

import javax.jws.WebService;

import com.atsistemas.curso.entidades.Persona;

@WebService
public interface IServicio {

	Persona metodo(Persona persona);

}