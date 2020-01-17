package com.example.demo.dto;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Setter
@Getter
public class ProductoDTO {
	
	
	
	private Long id;
	
	private String nombre;
	
	private String codigo;
		
	private String descripcion;
	
	private BigDecimal precio;
	
	@JsonProperty(value="tipo_producto")
	private TipoProductoDTO tipoProducto;
	
	@JsonProperty(value="imagen_producto")
	@OneToOne(cascade = CascadeType.ALL)
	private ImagenProductoDTO imagenProducto;
	
	private Boolean activo;
	@JsonProperty(value="cantidad_Stock")

	private int cantidadStock;

}

