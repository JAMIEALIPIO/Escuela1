package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entidad.Empresa;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.EmpresaRepository;
import com.example.demo.service.EmpresaService;

public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	public Empresa obtenerEmpresaPorId(Long id) throws ResourceNotFoundException {
		
		return empresaRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(String.format("No se encontro el id empleado %s en la BD", id)));
	}

}
