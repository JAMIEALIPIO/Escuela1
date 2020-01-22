package com.example.demo.service;

import com.example.demo.entidad.Empleado;
import com.example.demo.exceptions.ResourceNotFoundException;

public interface EmpleadoService {
	
	
	public Empleado obtenerEmpleadoPorId(Long id) throws ResourceNotFoundException;

}
