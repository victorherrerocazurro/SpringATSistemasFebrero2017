package com.atsistemas.curso.vistas;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

public class MensajeView implements View {

	@Override
	public String getContentType() {
		return "text/html";
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.getWriter()
		.append("Served at: ")
		.append(request.getContextPath())
		.append(model.get("mensaje").toString());
	}

}
