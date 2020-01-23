package com.example.demo.service;

import com.example.demo.dto.CantidadDTO;
import com.example.demo.exceptions.ResourceNotFoundException;

public interface FeignService {
	
	public CantidadDTO validarCantidadOrden(Long idProducto) throws ResourceNotFoundException;


}
