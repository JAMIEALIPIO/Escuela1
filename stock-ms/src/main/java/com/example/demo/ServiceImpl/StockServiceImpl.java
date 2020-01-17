package com.example.demo.ServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.StockRepository;
import com.example.demo.Service.StockService;
import com.example.demo.entidad.Stock;
import com.example.demo.exceptions.ResourceNotFoundException;

@Transactional(readOnly = true)
@Service
public class StockServiceImpl implements StockService{

	@Autowired
	private StockRepository stockRepository;
	
	@Override
	public Stock obtenerStockPorId(Long id) throws ResourceNotFoundException {

		return stockRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(String.format("No se encontro el id %s en la BD", id)));

	}
	
	
	@Override
	public Integer productosTienda(Long idProducto, Long idTienda)
			throws ResourceNotFoundException {

		return stockRepository.contarPorIdProductoIdTienda(idProducto, idTienda).orElseThrow(()->new ResourceNotFoundException("No se encontro producto con el id indicado"));
		
		
	}


	@Override
	public Integer productosTotal(Long idProducto) throws ResourceNotFoundException {
	
		return stockRepository.totalProductos(idProducto).orElseThrow(()->new ResourceNotFoundException("No se encontro producto con el id indicado"));
	}
	}


	




	

	


