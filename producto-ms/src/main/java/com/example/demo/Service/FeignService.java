package com.example.demo.Service;

import com.example.demo.dto.StockDTO;
import com.example.demo.exceptions.ResourceNotFoundException;

public interface FeignService {
	
	//stockdto=cantidaddto
	
	public StockDTO obtenerCantidad(Long idProducto) throws ResourceNotFoundException;
	
	
	
	

}
