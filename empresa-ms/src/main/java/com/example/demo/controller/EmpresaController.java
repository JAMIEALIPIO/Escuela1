package com.example.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmpresaDTO;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.service.EmpresaService;
import com.example.demo.service.impl.FeignServiceImpl;

@RestController
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private FeignServiceImpl feignService;
	
	@GetMapping("/empresa/{idEmpresa}")
	public EmpresaDTO obtenerEmpresaporrId(@PathVariable("idEmpresa") Long id) throws ResourceNotFoundException{

		ModelMapper mapper=new ModelMapper();

		EmpresaDTO empresa=mapper.map(empresaService.obtenerEmpresaPorId(id), EmpresaDTO.class);
	
	//	EmpresaDTO empresaDTO=feignService.obtenerEmpresa(id);
	   
		return empresa;
		

}
}
