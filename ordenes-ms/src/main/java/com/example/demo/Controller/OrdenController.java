package com.example.demo.Controller;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ActualizarStockDTO;
import com.example.demo.dto.OrdenDTO;
import com.example.demo.dto.OrdenDetalleReducidoDTO;
import com.example.demo.dto.OrdenReducidaDTO;
import com.example.demo.dto.ProductoDTO;
import com.example.demo.entidad.Orden;
import com.example.demo.entidad.OrdenDetalle;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ValidacionException;
import com.example.demo.feign.AlmacenClient;
import com.example.demo.feign.ProductoClient;
import com.example.demo.service.OrdenService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RefreshScope
public class OrdenController {
	
	@Autowired
	private DiscoveryClient client;

	@Autowired
	private OrdenService ordenService;
	
	@Autowired
	private ProductoClient productoClient;
	
	@Autowired
	private AlmacenClient almacenClient;
	
	/*@Autowired
	private FeignService feignService;
	
	*/
	
/*	
	public CantidadDTO getCantidad(String service, Long idProducto) {
		List<ServiceInstance> list=client.getInstances(service);
		if(list !=null && list.size()>0) {
			int rand=(int)Math.round(Math.random()*10 % list.size());
				URI uri=list.get(rand).getUri();
				if(uri != null)
					return (new RestTemplate() ).getForObject(uri.toString() + "/stock/producto/{idProducto}", 
							CantidadDTO.class, idProducto);
		
	}
		return null;
	
	}*/
	
	
	/*
	public ProductoDTO getProducto(String service, Long idProducto) {
		List<ServiceInstance> list=client.getInstances(service);
		if(list !=null && list.size()>0) {
			int rand=(int)Math.round(Math.random()*10 % list.size());
				URI uri=list.get(rand).getUri();
				if(uri != null)
					return (new RestTemplate() ).getForObject(uri.toString() + "/productos/{id}", 
							ProductoDTO.class, idProducto);
		
	}
		return null;
	
	}*/
	
	
	@ApiOperation(value="Guardar una orden de venta",
			notes="Al guardar una orden se verificara el stock de los almacenes",
			response=OrdenDTO.class)
	@ApiResponses(value = {
			@ApiResponse(code=201, message="se resgitro correctamente la orden",response=OrdenDTO.class),
			@ApiResponse(code=404, message="recurso no encontrado",response=ResourceNotFoundException.class),
			@ApiResponse(code=200, message="validacion de negocio",response=ValidacionException.class)
	})
	
    @ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/orden/guardar")
	public OrdenDTO guardar(@Valid @RequestBody OrdenReducidaDTO ordenDTO) throws ValidacionException, ResourceNotFoundException {
		
		ModelMapper modelmapper = new ModelMapper();
		modelmapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		BigDecimal total = new BigDecimal(0);
		Orden orden = modelmapper.map(ordenDTO, Orden.class);

			for (OrdenDetalle ordenDetalle : orden.getDetalle()) {
			//	int cantidad = getCantidad("almacen-ms", ordenDetalle.getIdProducto()).getCantidad();
				
			  int cantidad =almacenClient.obtenerCantidad(ordenDetalle.getIdProducto()).getCantidad();

				    if (cantidad < ordenDetalle.getCantidad()) 
				      {
					      throw new ValidacionException("Cantidad sobrepasa el stock actual");
				      }
				   
							//feign client
							ProductoDTO producto = productoClient.obtnerProductoPorId( ordenDetalle.getIdProducto());
							BigDecimal precio = producto.getPrecio();
							total = total.add(precio.multiply(new BigDecimal(ordenDetalle.getCantidad())));
							ordenDetalle.setPrecio(precio);
							//ordenDetalle.setOrden(orden);
		}

			orden.setTotal(total);
			orden.setFecha(new Date());
			Orden guardado=ordenService.guardarOrden(orden);
			
			ActualizarStockDTO actualizarStockDTO=new ActualizarStockDTO();
			actualizarStockDTO.setDetalle(new ArrayList<OrdenDetalleReducidoDTO>());
			
			guardado.getDetalle().forEach(detalle ->{
			   OrdenDetalleReducidoDTO d=new OrdenDetalleReducidoDTO(detalle.getIdProducto(), detalle.getCantidad());
			   actualizarStockDTO.getDetalle().add(d);
				
			});
			almacenClient.actualizarStock(actualizarStockDTO);
			return modelmapper.map(guardado, OrdenDTO.class);
		}
	
	
	@GetMapping("/ordenes/listado/{fecha}")
	public List<OrdenDTO> listadoOrdenes(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha) throws ResourceNotFoundException{
		
		ModelMapper modelMapper = new ModelMapper();
		Type listType = new TypeToken<List<OrdenDTO>>() {}.getType();
		return modelMapper.map(ordenService.listarOrdenesFecha(fecha), listType);
		
		
	}
	
	@GetMapping("/orden/detalle/{idProducto}")
	public List<OrdenDTO>detalleProductos(@PathVariable("idProducto") Long idProducto) throws ResourceNotFoundException{
		
		ModelMapper modelMapper=new ModelMapper();
		Type listType = new TypeToken<List<OrdenDTO>>() {}.getType();
		
		return modelMapper.map(ordenService.obtenerDetallesProducto(idProducto), listType);
		
	}
	
	
	@RequestMapping(value="/orden/{idOrden}", method=RequestMethod.GET)
	public Orden eliminarOrdenes(@PathVariable("idOrden") Long idOrden){
	
		return ordenService.eliminarRegistroOrdenes(idOrden);
	  
	}
	
	
	@PutMapping("/orden/{idOrden}")
	public OrdenDTO actualizarOrdenFecha(@PathVariable ("idOrden") Long idOrden,
			@RequestBody OrdenReducidaDTO ordenReducidadto) throws ResourceNotFoundException {
			
		    ModelMapper modelMapper=new ModelMapper();
		 
			Orden orden=ordenService.actualizarFechaOrden(idOrden, ordenReducidadto);
			OrdenDTO ordendto=modelMapper.map(orden, OrdenDTO.class);
			
		return ordendto;	
		
	}
	
	
/*	@DeleteMapping
	public Orden eliminar(@PathVariable("idOrden") Long idOrden) {
		
		
		
		
		return null;
		
	}
	
	*/
	
	
	
	
	
	
	
	
	
	
}
