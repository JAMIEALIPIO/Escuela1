package com.example.demo.dto;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdenDetalleDTO {
	@ApiModelProperty(value="")

	private Long id;
	private Long idProducto;
	private int cantidad;
	private BigDecimal precio;
}
