package com.example.demo.ServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Service.ProductoService;
import com.example.demo.entidad.Producto;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.ProductoRepository;

@Transactional(readOnly = true)
@Service
public class ProductoServiceImpl implements ProductoService {

	
	
	@Autowired
	private ProductoRepository productoRepository;
	
//	@Autowired
	//private TipoProductoRepository tipoPoductoRepository;
	
	
	@Override
	public Iterable<Producto> obtenerProductos() {
		
		return productoRepository.findAll();
	}

	
	@Transactional(readOnly = true)
	@Override
	public Producto guardarProducto(Producto producto) {
		
    /*
		TipoProducto  tipoProducto= tipoPoductoRepository.finByCodigo(producto.getTipoProducto().getCodigo()).get();
		producto.setTipoProducto(tipoProducto);
		
		//tipoProducto.setTipoProducto(tipoProducto);
		productoRepository.save(producto);
		
		
		
	*/	
		
		Producto nuevo=productoRepository.save(producto);
		return nuevo;
	}

	
	@Override
	public Producto obtnerProductoPorId(Long id) throws ResourceNotFoundException {
		

		return productoRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(String.format("No se encontro el id %s en la BD", id)));
	}
	
	
}
