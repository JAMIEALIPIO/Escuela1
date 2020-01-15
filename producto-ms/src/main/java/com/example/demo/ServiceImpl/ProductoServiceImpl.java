package com.example.demo.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Service.ProductoService;
import com.example.demo.entidad.Producto;
import com.example.demo.repository.ProductoRepository;

@Transactional(readOnly = true)
@Service
public class ProductoServiceImpl implements ProductoService {

	
	
	@Autowired
	private ProductoRepository productoRepository;
	
	
	@Override
	public Iterable<Producto> obtenerProductos() {
		
		return productoRepository.findAll();
	}

	
	
	@Override
	public Producto guardarProducto(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto obtnerProductoPorId(Long id) {
		
		return null;
	}
	
	
}
