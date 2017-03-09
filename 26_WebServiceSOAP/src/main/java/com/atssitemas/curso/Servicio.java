package com.atssitemas.curso;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.atsistemas.curso.entidades.Persona;

@WebService(serviceName="servicio")
public class Servicio implements IServicio {
  /* (non-Javadoc)
 * @see com.atssitemas.curso.IServicio#metodo(com.atsistemas.curso.entidades.Persona)
 */
@Override
@WebMethod
  public Persona metodo(Persona persona){
	  return new Persona(1, "Victor", 24, 1.50, "Hombre");
  }
}
