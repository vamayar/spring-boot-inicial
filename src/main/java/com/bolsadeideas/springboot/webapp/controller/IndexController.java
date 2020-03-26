package com.bolsadeideas.springboot.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.webapp.model.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListas;
	
	@GetMapping({"/index","/","/home"})
	public String index(Model model) {
		model.addAttribute("titulo",textoIndex);
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario =  Usuario.builder().nombre("Victor").apellido("Amaya").email("vh_ar@hotmail.com").build();
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		
		model.addAttribute("titulo", textoListas);
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(Usuario.builder().nombre("Zaira").apellido("Valdes").email("zaira@hotmail.com").build());
		usuarios.add(Usuario.builder().nombre("Claudia").apellido("Martin").email("claudia@hotmail.com").build());
		usuarios.add(Usuario.builder().nombre("Diana").apellido("Ibañez").email("diana@hotmail.com").build());
		usuarios.add(Usuario.builder().nombre("Ana").apellido("Karen").email("anakaren@hotmail.com").build());
		
		return usuarios;
	}
}
