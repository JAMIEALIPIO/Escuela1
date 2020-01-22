package com.example.demo.service;

import com.example.demo.dto.EmpleadoDTO;
import com.example.demo.dto.EmpresaDTO;
import com.example.demo.exceptions.ResourceNotFoundException;

public interface FeignService {

	public EmpresaDTO obtenerEmpleadosEmpresa(Long idEmpleado) throws ResourceNotFoundException;
	
	
	
	

}
