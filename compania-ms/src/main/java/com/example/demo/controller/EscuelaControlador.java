package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PersonaDTO;
import com.example.demo.dto.PersonaReducidaDTO;
import com.example.demo.entidad.Persona;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.service.PersonaService;

@RestController
@RefreshScope

public class EscuelaControlador {
	
	@Value("${igv}")
	private String igv;
	
	
	@Autowired
	private PersonaService personaService;
	
	
	@RequestMapping("/personas")
	public List<Persona> getPersonas(){
	return personaService.obtenerPersona();	
	}
	
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/personas")
	private PersonaDTO guardarPersona(@Valid @RequestBody PersonaReducidaDTO persona) throws Exception {
		ModelMapper mapper=new ModelMapper();
		Persona nuevo=personaService.guardarPersona(mapper.map(persona, Persona.class));
		
		return mapper.map(nuevo, PersonaDTO.class );
	}
	
	
	@GetMapping("/personas/{id}")
	public Persona obtenerPersonaPorId(@PathVariable("id") Long id) throws ResourceNotFoundException {
		return personaService.obtenerPersonaPorId(id);
	}
	
	
	@GetMapping("/igv")
	public String getIgv() {
		return "el igv actual es " +igv;
	}
	
	
	/*@Value("${palabra}")
	String palabra;
	
	
	@RequestMapping("/palabra")
	public String obtenerPalabra() {
		return "La palabra es     "  +palabra;
	}*/
	
	
	

}
