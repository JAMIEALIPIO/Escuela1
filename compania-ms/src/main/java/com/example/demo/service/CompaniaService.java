package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CompaniaReducidaDTO;
import com.example.demo.entidad.Compania;
import com.example.demo.exceptions.ResourceNotFoundException;

public interface CompaniaService {
	
	
	public Iterable<Compania> obtenerCompanias();

	Compania guardarCompania(Compania compania);
	
	public Compania asociarCompaniaPersona(Long idCompania, Long idPersona) throws ResourceNotFoundException;
	
	public Compania actualizarCompania(Long id, CompaniaReducidaDTO companiaReducidadto) throws ResourceNotFoundException;
	
	public Compania obtenerCompaniaPorId(Long id) throws ResourceNotFoundException;
	
	public List<Compania> obtenerCompania();

}
