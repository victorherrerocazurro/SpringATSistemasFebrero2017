package com.atsistemas.curso.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.JstlView;

import com.atsistemas.curso.vistas.AfinesPdfView;

@Controller
//@RequestMapping(path="/Persona")
public class PersonaControlador {

	@RequestMapping(path="/Alta",method= RequestMethod.POST)
	public String procesarAltaPersona(){
		return "formularioAlta";
	}
	
	@RequestMapping(path="/Alta",method= RequestMethod.GET)
	public String inicializarAltaPersona(){
		return "formularioAlta";
	}
	
	@RequestMapping(path="/BuscarAfines",method= RequestMethod.GET)
	public View procesarBuscarAfines(Model model){
		
		List<String> afines = new ArrayList<>();
		
		afines.add("Juan");
		afines.add("Maria");
		
		model.addAttribute("listadoAfines", afines);
		
		//return new JstlView("WEB-INF/Paginas/listadoAfines.jsp");
		
		return new AfinesPdfView();
	}
	
}
