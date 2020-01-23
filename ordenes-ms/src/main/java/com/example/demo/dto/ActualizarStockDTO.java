package com.example.demo.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ActualizarStockDTO {
	@ApiModelProperty(value="")

	 private List<OrdenDetalleReducidoDTO> detalle;

}
