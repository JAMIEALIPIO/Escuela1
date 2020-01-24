package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.dto.ActualizarStockDTO;
import com.example.demo.dto.OrdenReducidaDTO;
import com.example.demo.entidad.Orden;
import com.example.demo.entidad.OrdenDetalle;
import com.example.demo.exceptions.ResourceNotFoundException;

public interface OrdenService {
	

	public List<Orden> listarOrdenesFecha(Date fecha) throws ResourceNotFoundException;

	public Orden guardarOrden(Orden orden);
	
//	public Orden obtenerDetallesProducto(Orden orden);
	
	public List<Orden> obtenerDetallesProducto(Long idProducto) throws ResourceNotFoundException;
	
	public Orden eliminarRegistroOrdenes (Long idOrden);
	
	Orden actualizarFechaOrden(Long id, OrdenReducidaDTO ordenReducidaDTO) throws ResourceNotFoundException;



}
