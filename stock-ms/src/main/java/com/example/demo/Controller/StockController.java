package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.StockService;
import com.example.demo.dto.StockDTO;
import com.example.demo.entidad.Stock;
import com.example.demo.exceptions.ResourceNotFoundException;

@RestController
@RefreshScope
public class StockController {

	
	@Autowired
	private StockService stockService;
	
	
	@GetMapping("/stock/{id}")
	public Stock obtenerStockPorId(@PathVariable("id") Long id) throws ResourceNotFoundException {
		return stockService.obtenerStockPorId(id);
	}
	
	
	//1
	
	@GetMapping("/producto/{idProducto}/tienda/{idTienda}")
	public Integer productoTienda(@PathVariable("idProducto") Long idProducto, @PathVariable ("idTienda")  Long idTienda  ) throws ResourceNotFoundException {
		
		return stockService.productosTienda(idProducto, idTienda);
		
	}
	
	
	
	
	//1
	/*@GetMapping("/stock/producto/{idProducto}")
	public Integer productosTotal(@PathVariable("idProducto") Long idProducto) throws ResourceNotFoundException {
		return stockService.productosTotal(idProducto);
	}
	*/
	
	
	
	//2
	
	@GetMapping("/stock/producto/{idProducto}")
	public StockDTO obtenerCantidad(@PathVariable("idProducto") Long idProducto) throws ResourceNotFoundException{

	  StockDTO response= new StockDTO();
	 //response.setCantidad(stockService.productosTotal(idProducto));
	  response.setCantidad(666);
    
	  //balanceo de cargas
	  return response;
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
}
