package com.example.demo.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Orden;
import com.example.demo.entidad.OrdenDetalle;
import com.example.demo.util.CustomRepository;

@Repository
public interface DetalleOrdenRepository extends CustomRepository<OrdenDetalle, Long> {
	
	List<OrdenDetalle> findByIdProducto(Long idProducto);

}
