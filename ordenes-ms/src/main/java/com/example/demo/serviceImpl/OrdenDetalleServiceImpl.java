package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.DetalleOrdenRepository;
import com.example.demo.entidad.OrdenDetalle;
import com.example.demo.service.OrdenDetalleService;

@Transactional(readOnly = true)
@Service
public class OrdenDetalleServiceImpl implements OrdenDetalleService{

	@Autowired
	private DetalleOrdenRepository detalleOrdenRepository;

	@Override
	public OrdenDetalle detalleProductos(Long idProducto) {
		
		return null;
	}

}
