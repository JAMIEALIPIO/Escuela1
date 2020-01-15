package com.example.demo.Controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.ValidationException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ProductoService;
import com.example.demo.dto.ProductoDTO;
import com.example.demo.dto.ProductoReducidoDTO;
import com.example.demo.entidad.ImagenProducto;
import com.example.demo.entidad.Producto;
import com.example.demo.entidad.TipoProducto;
import com.example.demo.exceptions.ResourceNotFoundException;

@RestController
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/productos")
	public List<ProductoDTO> obtenerProductos(){
		ModelMapper mapper=new ModelMapper();
		Iterable<Producto> productos =productoService.obtenerProductos();
	return	StreamSupport.stream(productos.spliterator(), false).map(p ->mapper.map(p, ProductoDTO.class)).collect(Collectors.toList());
	}
	
	
	@GetMapping("/productos/{id}")
	public ProductoDTO obtenerProductosPorId(@PathVariable("id") Long id) throws ResourceNotFoundException{
		ModelMapper mapper=new ModelMapper();
		
		return mapper.map(productoService.obtnerProductoPorId(id), ProductoDTO.class);
	}
	
	
	@PostMapping("/productos")
	public ProductoDTO guardarProducto(@RequestBody ProductoReducidoDTO productoReducidodto) throws ValidationException, ResourceNotFoundException{
		ModelMapper mapper=new ModelMapper();
		Producto producto=mapper.map(productoReducidodto, Producto.class);
		
		TipoProducto tipoProducto=new TipoProducto();
		tipoProducto.setCodigo(productoReducidodto.getCodigoProducto());
		
		ImagenProducto imagenProducto= new ImagenProducto();
		imagenProducto.setRutaImagen(productoReducidodto.getRutaImagen());
		imagenProducto.setRutaThumbnail(productoReducidodto.getRutaThumbnail());
		
		producto.setTipoProducto(tipoProducto);
		producto.setImagenProducto(imagenProducto);
		return mapper.map(productoService.guardarProducto(producto), ProductoDTO.class);
		
		
	}

}
