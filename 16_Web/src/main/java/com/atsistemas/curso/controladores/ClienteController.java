package com.atsistemas.curso.controladores;

import java.io.IOException;
import java.util.logging.Logger;

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
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	private DummyNegocio negocio;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
        super();
        // TODO Auto-generated constructor stub
        
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	WebApplicationContext springContext = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
		
		//WebApplicationContext attribute = (WebApplicationContext) getServletContext().getAttribute("MiContextoDeSpring");
		
		negocio = springContext.getBean(DummyNegocio.class);
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		log.info("En el controller");
		
		String nombre = request.getParameter("nombre");
		Float cantidad = Float.parseFloat(request.getParameter("cantidad"));
		
		Cliente cliente = new Cliente(nombre);
		
		Factura factura = new Factura(cantidad, cliente);
		
		negocio.altaClienteYFatura(cliente, factura);
		
		response.getWriter()
			.append("Served at: ")
			.append(request.getContextPath())
			.append(factura.toString());
	}

}
