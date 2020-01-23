package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.CantidadDTO;
import com.example.demo.dto.OrdenDetalleReducidoDTO;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.feign.AlmacenClient;
import com.example.demo.service.FeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public class FeignServiceImpl implements FeignService{

	@Autowired
	private AlmacenClient almacenClient;
	
	@HystrixCommand(fallbackMethod = "obtenerCantidadDefecto")
	@Override
	public CantidadDTO validarCantidadOrden(Long idProducto) throws ResourceNotFoundException {
		return almacenClient.obtenerCantidad(idProducto);

	}
	
      public CantidadDTO obtenerCantidadDefecto(Long id) throws ResourceNotFoundException {
    	  
    	  OrdenDetalleReducidoDTO ordendetalle;
    	 // ordendetalle.getCantidad();
    	  CantidadDTO cantidad =almacenClient.obtenerCantidad(id);
		  return cantidad;
	  }

}
