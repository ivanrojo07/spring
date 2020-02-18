package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	//Diferente forma se pasar parametros
	@GetMapping({"","/","/index","/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring Framework");
		return "index";
	}
	
	@RequestMapping(value= {"/2","/index2","/home2"},method = RequestMethod.GET)
	public String index2(ModelMap modelmap) {
		modelmap.addAttribute("titulo", "Hola Spring con ModelMap");
		return "index";
	}
	
	@GetMapping({"/3","/index3","/home3"})
	public String index3(Map<String, Object> map) {
		map.put("titulo", "Hola Spring con Map");
		return "index";
	}
	
	@GetMapping({"/4","/index4","/home4"})
	public ModelAndView index4(ModelAndView model_and_view) {
		model_and_view.addObject("titulo", "Hola Spring con Model And View");
		model_and_view.setViewName("index");
		return	model_and_view;
	}
	
	@RequestMapping(value="/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Ivan");
		usuario.setApellido("Rojo");
		//usuario.setEmail("ivan@mail.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil de ".concat(usuario.getNombre()));
		return "perfil";
	}
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Karen","Lopéz","karenlopez@mail.com"));
		usuarios.add(new Usuario("Mario","Capistran","mariocapistran@mail.com"));
		usuarios.add(new Usuario("Iván","Rojo","ivanrojo@mail.com"));
		model.addAttribute("titulo", "Listado de usuarios.");
		model.addAttribute("usuarios", usuarios);
		return "usuarios_list";
	}
	
	@RequestMapping("/listar2")
	public String listar2(Model model) {
		List<Usuario> usuarios = Arrays.asList(
				new Usuario("Elizabeth","Rodriguez","elirod@mail.com"),
				new Usuario("Domitila","Gomez","domigom@mail.com"),
				new Usuario("Jazmin", "Breniz","jazmin@mail.com")
				);
		model.addAttribute("titulo", "Listado de usuarios 2.");
		model.addAttribute("usuarios", usuarios);
		return "usuarios_list";
	}
	
	@RequestMapping("/listar3")
	public String listar3(Model model) {
		model.addAttribute("titulo", "Listado de Usuarios 3.");
		
		return "usuarios_list";
	}
	
	//	Usar Model Attribute
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(
				new Usuario("Elizabeth","Gradilla","eligrad@mail.com"),
				new Usuario("Allison","Becker","allisonbeck@mail.com"),
				new Usuario("Roberto","Firminho","bobby@mail.com")
				);
		return usuarios;
	}
	
}
