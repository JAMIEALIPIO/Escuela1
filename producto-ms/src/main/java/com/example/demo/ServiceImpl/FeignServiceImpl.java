package com.example.demo.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Service.FeignService;
import com.example.demo.dto.StockDTO;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.feign.AlmacenClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class FeignServiceImpl  implements FeignService{

	@Autowired
	private AlmacenClient almacenCliente;
	
	@HystrixCommand(fallbackMethod = "obtenerCantidadDefecto")
	@Override
	public StockDTO obtenerCantidad(Long idProducto) throws ResourceNotFoundException {

		return almacenCliente.obtenerCantidad(idProducto);
	}
	
	public StockDTO obtenerCantidadDefecto(Long id) {
		//EMPRSSADTO EMPRESADTO=NEW EM
		//EMPRESADTO.SETNOMBRE("")
		//return emprssadto
		return new StockDTO(0);
	}
	

}
