package com.example.demo.Controller;

import javax.validation.Valid;
import javax.validation.Validation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrdenDTO;
import com.example.demo.dto.OrdenReducidoDto;
import com.example.demo.entidad.DetalleOrden;
import com.example.demo.entidad.Orden;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.service.OrdenService;
import com.netflix.config.validation.ValidationException;

@RestController
@RefreshScope
public class OrdenController {
	
	@Autowired
	private DiscoveryClient client;

	@Autowired
	private OrdenService ordenService;
	
	@PostMapping("/ordenes")
	public OrdenDTO guardarOrden(@Valid @RequestBody OrdenReducidoDto ordenReducidoDTO)
			throws ValidationException, ResourceNotFoundException {
		
		
		ModelMapper mapper = new ModelMapper();
		Orden orden = mapper.map(ordenReducidoDTO, Orden.class);
		

		DetalleOrden detalleOrden = new DetalleOrden();
		//detalleOrden
		
		return mapper.map(ordenService.guardarOrden(orden), OrdenDTO.class);
	}
	

}
