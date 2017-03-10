package com.atsistemas.curso.controladores;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.atsistemas.curso.entidades.Persona;
import com.atsistemas.curso.servicios.Servicio;
import com.atsistemas.curso.vistas.AfinesPdfView;
import com.atsistemas.curso.vistas.MensajeView;

@Controller
@RequestMapping("/Persona")
public class PersonasController {
	
	private Servicio servicio;
	
	@Autowired
	public PersonasController(Servicio servicio) {
		super();
		this.servicio = servicio;
	}

	@RequestMapping("/Alta")
	public ModelAndView altaUsuario(Persona persona) {
		
		ModelAndView modelAndView = new ModelAndView(new MensajeView());
		
		String mensaje = "Error!!!!!";
		
		try {
			servicio.altaUsuario(persona);
			//No news, good news
			mensaje = "El alta se ha realziado de forma correcta para los datos: " + persona;
		} catch (Exception e) {
			// news, bad news
			e.printStackTrace();
		}
		
		modelAndView.addObject("mensaje", mensaje);
		
		return modelAndView;
	}

	@RequestMapping("/Afines")
	public View busquedaAfines(Model model, HttpSession session) {
		
		Persona usuario = (Persona) session.getAttribute("usuario");
		
		List<Persona> afines = servicio.busquedaAfines(usuario);
		
		model.addAttribute("afines",afines);
		
		return new AfinesPdfView();
	}

	@RequestMapping("/Ideal")
	public String busquedaIdeal(Model model, HttpSession session) {
		
		Persona usuario = (Persona) session.getAttribute("usuario");
		
		Persona ideal = servicio.busquedaIdeal(usuario);
		
		model.addAttribute("ideal",ideal);
		
		return "ideal";
	}
	
	@RequestMapping("/Login/{id}")
	public String login(@PathVariable long id, HttpSession session, Model model) {
		
		try {
			Persona usuario = servicio.buscarPersonaPorId(id);
			
			if(usuario != null){
			
				session.setAttribute("usuario", usuario);
			
				return "principal";
			} else {
				
				model.addAttribute("mensaje", "Login incorrecto!!!");
				
				return "formularioLogin";
			}
		} catch (Exception e) {

			e.printStackTrace();
			
			model.addAttribute("mensaje", "Error!!!" + e.getMessage());
			
			return "formularioLogin";
		}
	}
	
	@RequestMapping("/Logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "formularioLogin";
	}

}
