package com.example.demo.Service;

import java.util.List;

import com.example.demo.dto.StockReducidoDTO;
import com.example.demo.entidad.Stock;
import com.example.demo.exceptions.ResourceNotFoundException;



public interface StockService {
	
	
	public Stock obtenerStockPorId(Long id) throws ResourceNotFoundException;
	
	
	
	
	public Integer productosTienda(Long idProducto, Long idTienda) throws ResourceNotFoundException;

	public Integer productosTotal(Long idProducto)throws ResourceNotFoundException;
	
}
