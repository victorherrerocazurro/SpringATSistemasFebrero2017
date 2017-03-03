package com.atsistemas.curso.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.atsistemas.curso.entidades.Cliente;
import com.atsistemas.curso.entidades.Factura;
import com.atsistemas.curso.negocio.DummyNegocio;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet("/Cliente")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		Float cantidad = Float.parseFloat(request.getParameter("cantidad"));
		
		WebApplicationContext springContext = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
		
		DummyNegocio negocio = springContext.getBean(DummyNegocio.class);
		
		Cliente cliente = new Cliente(nombre);
		
		Factura factura = new Factura(cantidad, cliente);
		
		negocio.altaClienteYFatura(cliente, factura);
		
		response.getWriter()
			.append("Served at: ")
			.append(request.getContextPath())
			.append(factura.toString());
	}

}
