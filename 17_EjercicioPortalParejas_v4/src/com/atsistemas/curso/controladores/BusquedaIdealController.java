package com.atsistemas.curso.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atsistemas.curso.entidades.Persona;

/**
 * Servlet implementation class BusquedaIdealController
 */
@WebServlet("/BusquedaIdeal")
public class BusquedaIdealController extends SpringWebAbstractController {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusquedaIdealController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Si el cliente cuando busca afines tiene que idetificarse con el ID
		/*String id = request.getParameter("id");
		
		Persona persona = new Persona();
		
		persona.setId(Long.parseLong(id));*/
		
		//La identificacion del usuario, se ha resuelto previamente con un LOGIN
		Persona usuario = (Persona) request.getSession().getAttribute(USUARIO_SESSION_KEY);
		
		Persona ideal = getServicio().busquedaIdeal(usuario);
		
		response.getWriter().append("Ideal: ").append(ideal.toString());
	}

}
