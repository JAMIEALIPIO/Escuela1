package com.example.demo.serviceImpl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.OrdenRepository;
import com.example.demo.entidad.Orden;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.service.OrdenService;


@Transactional(readOnly = true)
@Service
public class OrdenServiceImpl implements OrdenService{

	 @Autowired
	private OrdenRepository ordenRepository;
	
	

	@Override
	public List<Orden> listarOrdenesFecha(Date fecha) throws ResourceNotFoundException {
		
		return ordenRepository.findByDespusIgualFechaEnvio(fecha);
	}



	@Override
	public Orden guardarOrden(Orden orden) {
		// TODO Auto-generated method stub
		return null;
	}

	



}
