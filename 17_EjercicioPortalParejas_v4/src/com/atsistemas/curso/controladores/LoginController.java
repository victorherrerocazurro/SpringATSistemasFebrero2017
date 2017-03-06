package com.atsistemas.curso.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atsistemas.curso.entidades.Persona;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends SpringWebAbstractController {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see SpringWebAbstractController#SpringWebAbstractController()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		Persona persona = getServicio().buscarPersonaPorId(Long.parseLong(id));
		
		request.getSession().setAttribute(USUARIO_SESSION_KEY, persona);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
