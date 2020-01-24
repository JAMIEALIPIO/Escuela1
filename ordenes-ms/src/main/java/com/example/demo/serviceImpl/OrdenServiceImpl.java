package com.example.demo.serviceImpl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.OrdenRepository;
import com.example.demo.dto.ActualizarStockDTO;
import com.example.demo.dto.OrdenDTO;
import com.example.demo.dto.OrdenReducidaDTO;
import com.example.demo.entidad.Orden;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.service.OrdenService;


@Transactional(readOnly = true)
@Service
public class OrdenServiceImpl implements OrdenService{

	@Autowired
	private OrdenRepository ordenRepository;
	
	

	@Override
	public List<Orden> listarOrdenesFecha(Date fecha) throws ResourceNotFoundException {
		
		return ordenRepository.findByDespusIgualFechaEnvio(fecha);
	}



	@Override
	public Orden guardarOrden(Orden orden) {
		return ordenRepository.save(orden);
	}



	@Override
	public List<Orden> obtenerDetallesProducto(Long idProducto) throws ResourceNotFoundException {
		return ordenRepository.findByDetalle_IdProducto(idProducto);
	}



	@Override
	public Orden eliminarRegistroOrdenes(Long idOrden) {
	
		return ordenRepository.eliminarOrden(idOrden); 
	}


	@Transactional(readOnly = false)
	@Override
	public Orden actualizarFechaOrden(Long id, OrdenReducidaDTO ordenReducidaDTO) throws ResourceNotFoundException {
		
		Orden orden=ordenRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No se encontro la orden con el id indicado"));
		
		orden.setFechaEnvio(ordenReducidaDTO.getFechaEnvio());
		
		return ordenRepository.save(orden);
		
	}







}
