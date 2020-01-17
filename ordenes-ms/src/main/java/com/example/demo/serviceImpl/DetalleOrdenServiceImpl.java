package com.example.demo.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Repository.DetalleOrdenRepository;
import com.example.demo.entidad.DetalleOrden;
import com.example.demo.service.OrdenDetalleService;

public class DetalleOrdenServiceImpl implements OrdenDetalleService{
	
	
	@Autowired
	private DetalleOrdenRepository detalleOrdenRepository;

	@Override
	public DetalleOrden registrarDetalle(DetalleOrden detalleOrden) {
		
		
		return null;
	}
	
	

}
