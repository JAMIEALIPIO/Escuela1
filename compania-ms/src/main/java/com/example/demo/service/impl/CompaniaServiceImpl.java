package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.CompaniaReducidaDTO;
import com.example.demo.entidad.Compania;
import com.example.demo.entidad.Persona;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.respository.CompaniaRespository;
import com.example.demo.respository.PersonaRespository;
import com.example.demo.service.CompaniaService;

@Transactional(readOnly = true)
@Service
public class CompaniaServiceImpl implements CompaniaService {
	
	@Autowired
	private CompaniaRespository companiaRepository;
	
	@Autowired
	private PersonaRespository personaRepository;

	@Override
	public Iterable<Compania> obtenerCompanias() {
		
		return companiaRepository.findAll();
	}
	
	
	@Override
	public Compania guardarCompania(Compania compania) {

		return companiaRepository.save(compania);
	}


	@Override
	public Compania asociarCompaniaPersona(Long idCompania, Long idPersona) throws ResourceNotFoundException {
		
		Persona persona=personaRepository.findById(idPersona).orElseThrow(()->new ResourceNotFoundException("No se encontro la persona con el id indicado"));
		
		Compania compania=companiaRepository.findById(idCompania).orElseThrow(()->new ResourceNotFoundException("No se encontro la compania con el id indicado"));
		
		persona.setCompania(compania);
		personaRepository.save(persona);
		
		
		return companiaRepository.findById(idCompania).get();
	}


	@Override
	public Compania actualizarCompania(Long id, CompaniaReducidaDTO companiaReducidadto) throws ResourceNotFoundException {
		
		Compania compania=companiaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No se encontro la compania con el id indicado"));
		
		
		compania.setNombre(companiaReducidadto.getNombre());
		compania.setRUC(companiaReducidadto.getRUC());
		compania.setRazonSocial(companiaReducidadto.getRazonSocial());
		
		return companiaRepository.save(compania);
	}


	@Override
	public Compania obtenerCompaniaPorId(Long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


	
	
     @Override
	public List<Compania> obtenerCompania() {

		return StreamSupport.stream(companiaRepository.findAll().spliterator(), false).collect(Collectors.toList());
		
		
	}

}
