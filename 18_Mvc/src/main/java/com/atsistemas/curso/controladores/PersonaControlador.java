package com.atsistemas.curso.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.View;

import com.atsistemas.curso.entidades.Persona;
import com.atsistemas.curso.vistas.AfinesPdfView;

@Controller
@RequestMapping(path="/Persona")
@SessionAttributes({"generos"})
public class PersonaControlador {

	@ModelAttribute("generos")
	public String[] initGeneros(){
		return new String[]{"Hombre", "Mujer"};
	}
	
	@RequestMapping(path="/Alta",method= RequestMethod.GET)
	public String inicializadorFormularioAltaPersona(Model model){
		model.addAttribute("persona", new Persona());
		
		//Solo esta dsponible en la request de Alta por GET
		//model.addAttribute("generos", new String[]{"Hombre", "Mujer"});
		return "formularioAlta";
	}
	
	@RequestMapping(path="/Alta",method= RequestMethod.POST)
	public String procesarAltaPersona(@Valid @ModelAttribute Persona persona, Errors errors){
		
		System.out.println(errors);
		
		if (!errors.hasErrors()){
			System.out.println("Invocamos Logica de Negocio!!!!");
		}
		
		return "formularioAlta";
	}
	
	@RequestMapping(path="/BuscarAfines",method= RequestMethod.GET)
	public View procesarBuscarAfines(Model model, HttpSession session){
		
		List<String> afines = new ArrayList<>();
		
		afines.add("Juan");
		afines.add("Maria");
		
		model.addAttribute("listadoAfines", afines);
		
		return new AfinesPdfView();
	}
	
}
