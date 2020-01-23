package com.example.demo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdenDetalleReducidoDTO {

	@ApiModelProperty(value="")

	private Long idProducto;
	private Long cantidad;
}
