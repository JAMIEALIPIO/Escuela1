package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Stock;
import com.example.demo.util.CustomRepository;

@Repository
public interface StockRepository  extends CustomRepository<Stock, Long>{
	
	@Query("select sum(s.cantidad) from Stock s where s.idProducto = ?1 and s.idTienda = ?2")
	Optional<Integer> contarPorIdProductoIdTienda(Long idProducto, Long idTienda);
	
	@Query("select sum(s.cantidad) from Stock s where s.idProducto = ?1")
	Optional<Integer> totalProductos(Long idProducto);
	
	

}
