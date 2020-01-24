package com.example.demo.service;

import java.util.List;

import com.example.demo.entidad.Persona;
import com.example.demo.exceptions.ResourceNotFoundException;

public interface PersonaService {

	public List<Persona> obtenerPersona();
	public Persona guardarPersona(Persona persona) throws Exception;
	
	public Persona obtenerPersonaPorId(Long id) throws ResourceNotFoundException;
	
	public Persona asociarPersona(Long id);
	
	
	
;}
