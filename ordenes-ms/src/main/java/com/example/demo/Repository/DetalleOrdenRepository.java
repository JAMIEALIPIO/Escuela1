package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.entidad.DetalleOrden;
import com.example.demo.util.CustomRepository;


@Repository
public interface DetalleOrdenRepository extends CustomRepository<DetalleOrden, Long> {
	
	public Optional<DetalleOrden> findByIdProducto(Long idProducto);


}
