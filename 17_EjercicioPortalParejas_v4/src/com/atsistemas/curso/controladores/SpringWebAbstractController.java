package com.atsistemas.curso.controladores;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.atsistemas.curso.servicios.Servicio;

public abstract class SpringWebAbstractController extends HttpServlet {

	public static final String USUARIO_SESSION_KEY = "usuario";
	
	private Servicio servicio;

	public SpringWebAbstractController() {
		super();
	}

	protected Servicio getServicio() {
		return servicio;
	}

	@Override
	public void init() throws ServletException {
		super.init();
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		
		servicio = context.getBean(Servicio.class);
	}

}