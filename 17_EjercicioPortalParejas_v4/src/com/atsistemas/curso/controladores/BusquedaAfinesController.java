package com.atsistemas.curso.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atsistemas.curso.entidades.Persona;

/**
 * Servlet implementation class BusquedaAfinesController
 */
@WebServlet("/BusquedaAfines")
public class BusquedaAfinesController extends SpringWebAbstractController {
	private static final long serialVersionUID = 1L;
       
	/**
     * @see HttpServlet#HttpServlet()
     */
    public BusquedaAfinesController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//La identificacion del usuario, se ha resuelto previamente con un LOGIN
		Persona usuario = (Persona) request.getSession().getAttribute(USUARIO_SESSION_KEY);
		
		List<Persona> afines = getServicio().busquedaAfines(usuario);
		
		// TODO Auto-generated method stub
		response.getWriter().append("Afines: ").append(afines.toString());
	}

}
