package com.atsistemas.curso.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

import com.atsistemas.curso.entidades.Persona;
import com.atsistemas.curso.vistas.AfinesPdfView;

@Controller
@RequestMapping(path="/Persona")
public class PersonaControlador {

	@RequestMapping(path="/Alta/{id}",method= RequestMethod.POST)
	public String procesarAltaPersona(@PathVariable long id, Persona persona){
		return "formularioAlta";
	}
	
	@RequestMapping(path="/Alta",method= RequestMethod.GET)
	public String inicializarAltaPersona(@RequestParam long id){
		System.out.println(id);
		return "formularioAlta";
	}
	
	@RequestMapping(path="/BuscarAfines",method= RequestMethod.GET)
	public View procesarBuscarAfines(Model model, HttpSession session){
		
		List<String> afines = new ArrayList<>();
		
		afines.add("Juan");
		afines.add("Maria");
		
		model.addAttribute("listadoAfines", afines);
		
		//return new JstlView("WEB-INF/Paginas/listadoAfines.jsp");
		
		return new AfinesPdfView();
	}
	
}
