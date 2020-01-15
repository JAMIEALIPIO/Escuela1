package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entidad.Persona;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ValidarDni;
import com.example.demo.respository.PersonaRespository;
import com.example.demo.service.PersonaService;


@Transactional(readOnly = true)
@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaRespository personaRepository;
	
	
	//public Iterable<Persona> obtenerPersonas(){
		//return personaRepository.findAll();
	//}

	
	@Transactional(readOnly = false)
	@Override
	public Persona guardarPersona(Persona persona) throws Exception {
		
		if(personaRepository.findByDni(persona.getDni()).isPresent()) {
			throw new ValidarDni("ya existe DNI registrado");
		}
		Persona nuevo=personaRepository.save(persona);
		 personaRepository.refresh(persona);
		return nuevo;
	}
	

	@Override
	public List<Persona> obtenerPersona() {

		return StreamSupport.stream(personaRepository.findAll().spliterator(), false).collect(Collectors.toList());
		
		
	}


	@Override
	public Persona obtenerPersonaPorId(Long id) throws ResourceNotFoundException {

		return personaRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(String.format("No se encontro el id %s en la BD", id)));

	}


	@Override
	public Persona asociarPersona(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
