package com.example.demo.service;

import com.example.demo.entidad.Empresa;
import com.example.demo.exceptions.ResourceNotFoundException;

public interface EmpresaService {
	
	public Empresa obtenerEmpresaPorId(Long id) throws ResourceNotFoundException;

}
