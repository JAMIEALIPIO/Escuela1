package com.example.demo.service.impl;

import com.example.demo.dto.EmpresaDTO;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.service.FeignEmpresa;

public class FeignServiceImpl implements FeignEmpresa{

	@Override
	public EmpresaDTO obtenerEmpresa(Long idEmpresa) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
