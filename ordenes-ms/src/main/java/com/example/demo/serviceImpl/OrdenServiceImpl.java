package com.example.demo.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.OrdenRepository;
import com.example.demo.entidad.DetalleOrden;
import com.example.demo.entidad.Orden;
import com.example.demo.service.OrdenService;


@Transactional(readOnly = true)
@Service
public class OrdenServiceImpl implements OrdenService{

	 @Autowired
	private OrdenRepository ordenRepository;
	
	@Transactional(readOnly = false)
	@Override
	public Orden guardarOrden(Orden orden, DetalleOrden detalleOrden) {
		
		Orden orden1=new Orden();
		DetalleOrden detalle=new DetalleOrden();
		orden1.setIdCliente(orden.getIdCliente());
		orden1.setFecha(new Date());
		orden1.setFechaEnvio(orden.getFechaEnvio());
		orden1.setDetalleOrden(orden.getDetalleOrden());
		detalle.getIdCantidad();

	//	ordenRepository.save(orden1);
		

		
	/*	DetalleOrden detalle=new DetalleOrden();
		detalle
		detalle1.getIdCantidad();
		
		orden1.setDetalleOrden(detalleOrden);
		
		
		*/
		

		
		
		
		return null;
	}

	@Override
	public Orden guardarOrden(Orden orden) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	

	

}
