package com.example.demo.Service;

import com.example.demo.dto.ProductoReducidoDTO;
import com.example.demo.entidad.Producto;

public interface ProductoService {
	
	public Iterable<Producto> obtenerProductos();
	public Producto guardarProducto(Producto producto);
	
	public Producto obtnerProductoPorId(Long id);

}
