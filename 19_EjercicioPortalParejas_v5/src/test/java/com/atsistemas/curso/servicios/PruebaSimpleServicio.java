package com.atsistemas.curso.servicios;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atsistemas.curso.entidades.Persona;
import com.atsistemas.curso.negocio.Negocio;
import com.atsistemas.curso.persistencia.jpa.data.PersonaDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Configuracion.class)
@ActiveProfiles("test")
public class PruebaSimpleServicio {

	//Dato de prueba de entrada
	Persona personaIn = new Persona();
	Persona personaInThrow = new Persona(1,"Juan",12,1.8,"Hombre");
	
	@Autowired
	SimpleServicio sut;
	
	@Autowired
	PersonaDao personaDao;
	
	@Autowired
	Negocio negocio;
	
	@Test
	public void testAltaUsuarioCorrecta() {
		when(personaDao.save(personaIn)).thenReturn(personaIn);
		
		try {
			//Ejecutar la prueba
			sut.altaUsuario(personaIn);
			
			//La prueba ha ido correcta
			verify(personaDao).save(personaIn);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test(expected=RuntimeException.class)
	public void testAltaUsuarioInCorrecta() {
		
		when(personaDao.save(personaInThrow)).thenThrow(new RuntimeException());
		
		sut = new SimpleServicio(personaDao, null);
		
		//Ejecutar la prueba
		sut.altaUsuario(personaInThrow);
		
		//La prueba ha ido correcta
		fail("Se ha ejecutado de forma correcta el proceso de Alta cuando no deberia");		
	}

}
