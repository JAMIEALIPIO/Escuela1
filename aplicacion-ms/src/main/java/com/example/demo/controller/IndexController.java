package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entidad.Producto;

@Controller
public class IndexController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/")
	public String hello(Model model) {
		model.addAttribute("productos", listaProductos());
		return "index";

	}

	
	
	@RequestMapping("/nuevo")
	public String nuevoProducto(Model model) {
	   Producto producto = new Producto();
	    model.addAttribute("productos", producto);
	      
	    return "nuevoproducto";
	}
	
	

	private static List<Producto> listaProductos() {
		final String uri = "http://localhost:9090/producto/productos";

		RestTemplate restTemplate = new RestTemplate();
		Producto[] result = restTemplate.getForObject(uri,Producto[].class);

		return Arrays.asList(result);
	}

}
