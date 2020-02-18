package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
//		Redirecciona a la url
//		return "redirect:/app/index";
//		Usa el RequestDispatcher.forward
		return "forward:/app/index"; 
	}
}
