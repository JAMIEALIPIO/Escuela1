package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.entidad.Orden;
import com.example.demo.exceptions.ResourceNotFoundException;

public interface OrdenService {
	

	public List<Orden> listarOrdenesFecha(Date fecha) throws ResourceNotFoundException;

	public Orden guardarOrden(Orden orden);


}
