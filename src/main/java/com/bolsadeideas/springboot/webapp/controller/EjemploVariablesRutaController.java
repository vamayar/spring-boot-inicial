package com.bolsadeideas.springboot.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {
	
	@GetMapping("/")
	public String index(Model model) {
		return "variables/index";
	}
	
	@GetMapping("/string/{texto}")
	public String variables(@PathVariable String  texto, Model model) { //en el pathvariable se puede especificar el nombre de la variable
		model.addAttribute("titulo", "Recibir parametros de la ruta (@PathVariable)");
		model.addAttribute("resultado", "El texto enviado en la ruta es: " +  texto);
		return "variables/ver";
	}
	
	@GetMapping("/string/{texto}/{numero}")
	public String variables(@PathVariable String  texto,@PathVariable Integer  numero, Model model) { //en el pathvariable se puede especificar el nombre de la variable
		model.addAttribute("titulo", "Recibir parametros de la ruta (@PathVariable)");
		model.addAttribute("resultado", "El texto enviado en la ruta es: " +  texto + " y el numero enviado en el path es: "+ numero);
		return "variables/ver";
	}
}
