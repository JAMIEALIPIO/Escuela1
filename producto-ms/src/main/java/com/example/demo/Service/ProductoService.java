package com.example.demo.Service;


import com.example.demo.entidad.Producto;
import com.example.demo.exceptions.ResourceNotFoundException;

public interface ProductoService {
	
	public Iterable<Producto> obtenerProductos();
	public Producto guardarProducto(Producto producto);
	
	public Producto obtnerProductoPorId(Long id) throws ResourceNotFoundException;

}
