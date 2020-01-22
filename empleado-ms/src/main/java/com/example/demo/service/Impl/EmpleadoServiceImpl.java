package com.example.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Empleado;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.EmpleadoRepository;
import com.example.demo.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	
	@Override
	public Empleado obtenerEmpleadoPorId(Long id) throws ResourceNotFoundException {
		return empleadoRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(String.format("No se encontro el id empleado %s en la BD", id)));
		
	}

}
