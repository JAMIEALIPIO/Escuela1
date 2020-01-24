package com.example.demo.Repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Orden;
import com.example.demo.util.CustomRepository;

@Repository
public interface OrdenRepository  extends CustomRepository<Orden, Long>{
	
	
	
	@Query("select u from Orden u where u.fechaEnvio >= ?1")
	List<Orden> findByDespusIgualFechaEnvio(Date fecha);
	
	//@Query("select u from Orden u where u.detalle.idProducto = ?1")
	
	
	List<Orden> findByDetalle_IdProducto(Long idProducto);
	
	
	@Query("delete from Orden o where o.id = ?1")
	Orden eliminarOrden (Long idOrden);
	
	
	void delete(Long idOrden);
	
	
   //	public Orden deleteById(Long idOrden);
	
	



}
