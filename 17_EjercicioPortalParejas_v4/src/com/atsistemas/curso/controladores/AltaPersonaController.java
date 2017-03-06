package com.atsistemas.curso.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.atsistemas.curso.entidades.Persona;
import com.atsistemas.curso.servicios.Servicio;

/**
 * Servlet implementation class AltaPersonaController
 */
@WebServlet("/AltaPersona")
public class AltaPersonaController extends SpringWebAbstractController {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaPersonaController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-Recuperar la info que le envie el cliente
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String edad = request.getParameter("edad");
		String altura = request.getParameter("altura");
		String genero = request.getParameter("genero");
		
		//2-Adaptar la info a lo que se maneja en el Servicio
		
		Persona persona = new Persona(
				Long.parseLong(id), 
				nombre, 
				Integer.parseInt(edad), 
				Double.parseDouble(altura), genero);
		
		try {
			
			//3-Invocar el servicio pertinente
			getServicio().altaUsuario(persona);
			
			//4-Con un feedback de exito, elegir la Vista mas adecuada para la representacion de la respuesta
			response.getWriter().append("Se ha dado de alta la persona: " + persona);
		
		} catch (Exception e) {
			e.printStackTrace();
			
			//4-Con feedback de fracaso, elegir la Vista mas adecuada para la representacion de la respuesta
			response.getWriter().append("ERROR: ").append(e.getMessage());
		}
		
		
	}

}
