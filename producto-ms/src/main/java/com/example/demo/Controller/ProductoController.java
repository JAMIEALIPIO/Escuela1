package com.example.demo.Controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.FeignService;
import com.example.demo.Service.ProductoService;
import com.example.demo.dto.ProductoDTO;
import com.example.demo.dto.ProductoReducidoDTO;
import com.example.demo.dto.StockDTO;
import com.example.demo.entidad.ImagenProducto;
import com.example.demo.entidad.Producto;
import com.example.demo.entidad.TipoProducto;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.feign.AlmacenClient;

@RestController
public class ProductoController {
	
	@Autowired
	private DiscoveryClient client;
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private AlmacenClient almacenClient;
	
	@Autowired
	private FeignService feignService;
	
	
	
	/*
	public StockDTO getCantidad(String service, Long idProducto) {
		List<ServiceInstance> list=client.getInstances(service);
		if(list !=null && list.size()>0) {
			int rand=(int)Math.round(Math.random()*10 % list.size());
				URI uri=list.get(0).getUri();
				if(uri != null)
					return (new RestTemplate() ).getForObject(uri.toString() + "/stock/producto/{idProducto}", 
							StockDTO.class, idProducto);
		
	}
		return null;
	
	}
	*/
	
	@GetMapping("/productos")
	public List<ProductoDTO> obtenerProductos(){
		ModelMapper mapper=new ModelMapper();
		Iterable<Producto> productos =productoService.obtenerProductos();
	return StreamSupport.stream(productos.spliterator(), false).map(p ->mapper.map
			(p, ProductoDTO.class)).collect(Collectors.toList());
	}
	
	
	@GetMapping("/productos/{id}")
	public ProductoDTO obtnerProductoPorId(@PathVariable("id") Long id) throws ResourceNotFoundException{

		ModelMapper mapper=new ModelMapper();

	    ProductoDTO producto=mapper.map(productoService.obtnerProductoPorId(id), ProductoDTO.class);
	
	    StockDTO stockDTO=feignService.obtenerCantidad(id);
		producto.setCantidadStock(stockDTO.getCantidad());
		return producto;
		
	}
	
	
	@PostMapping("/productos")
	public ProductoDTO guardarProducto(@Valid @RequestBody ProductoReducidoDTO productoReducidodto)
			throws ValidationException, ResourceNotFoundException{
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
	
/*	
	@RequestMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
	public String getPorductosJSON(Model model) 
	{
	    model.addAttribute("producto", );
	    return "jsonTemplate";
	}
	
	
	*/
	
	

}
