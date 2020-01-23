package com.example.demo.entidad;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Setter
@Getter
public class Producto {
	
   
	private Long id;
	private String nombre;
	
	private String codigo;
	
	private String descripcion;
	
	private BigDecimal precio;
	
	//private TipoProducto tipoProducto;
	
//	private ImagenProducto imagenProducto;
	
	private Boolean activo;

}
