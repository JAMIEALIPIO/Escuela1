package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.EmpresaDTO;
import com.example.demo.exceptions.ResourceNotFoundException;

@FeignClient("empresa-ms")
public interface EmpresaClient {
	
	@GetMapping("/empresa/{idEmpresa}")
	public EmpresaDTO obtenerEmpresaporrId(@PathVariable("idEmpresa") Long id) throws ResourceNotFoundException;

}
