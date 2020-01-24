package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.StockDTO;
import com.example.demo.exceptions.ResourceNotFoundException;

@FeignClient("almacen-ms")
public interface AlmacenClient {
	
    @GetMapping("/stock/producto/{idProducto}")
    public StockDTO obtenerCantidad(@PathVariable("idProducto") Long idProducto) throws ResourceNotFoundException;
	
	

}
