package com.example.demo.service;

import com.example.demo.dto.EmpresaDTO;
import com.example.demo.entidad.Empresa;
import com.example.demo.exceptions.ResourceNotFoundException;

public interface FeignEmpresa {
	
	public EmpresaDTO obtenerEmpresa(Long idEmpresa) throws ResourceNotFoundException;
}
