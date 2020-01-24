package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidad.Producto;

@RestController

public class IndexController {
	
	@GetMapping("/")
	public String showUpdateForm(Producto producto) {
		
		return "index";
	}
}
