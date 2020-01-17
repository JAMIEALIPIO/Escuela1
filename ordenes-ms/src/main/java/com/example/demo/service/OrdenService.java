package com.example.demo.service;

import com.example.demo.entidad.DetalleOrden;
import com.example.demo.entidad.Orden;

public interface OrdenService {
	
	public Orden guardarOrden(Orden orden);

	Orden guardarOrden(Orden orden, DetalleOrden detalleOrden);

}
