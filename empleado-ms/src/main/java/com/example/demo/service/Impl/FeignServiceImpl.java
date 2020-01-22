package com.example.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmpleadoDTO;
import com.example.demo.dto.EmpresaDTO;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.feign.EmpresaClient;
import com.example.demo.service.FeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class FeignServiceImpl implements FeignService{

	@Autowired
	private EmpresaClient empresaClient;
	
	@HystrixCommand(fallbackMethod = "obtenerNombrePorDefecto")
	@Override
	public EmpresaDTO obtenerEmpleadosEmpresa(Long idEmpleado) throws ResourceNotFoundException {
		
		return empresaClient.obtenerEmpresaporrId(idEmpleado);
		 
	}
	
	
	public EmpresaDTO obtenerNombrePorDefecto(Long id) {
		EmpresaDTO empresaDTO=new EmpresaDTO();
		empresaDTO.setNombre(" ");
		return empresaDTO;
		
	}

}
