package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.ActualizarStockDTO;
import com.example.demo.dto.CantidadDTO;
import com.example.demo.exceptions.ResourceNotFoundException;

@FeignClient("almacen-ms")

public interface AlmacenClient {
	
	
	@GetMapping("/stock/producto/{idProducto}")
	public CantidadDTO obtenerCantidad(@PathVariable("idProducto") Long idProducto) throws ResourceNotFoundException;

	  
	  @PutMapping("/stock/actualizar")
		public void actualizarStock(@RequestBody ActualizarStockDTO actualizarStockDTO) throws ResourceNotFoundException;
//	public void actualizarStock(ActualizarStockDTO actualizarStockDTO);
	  
	  
	  @GetMapping("/stock/producto/{idProducto}")
	  public CantidadDTO validarCantidad(@PathVariable("idProducto") Long idProducto) throws ResourceNotFoundException;

	 
}
