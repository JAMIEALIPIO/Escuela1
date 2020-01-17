package com.example.demo.dto;

import java.util.Date;

import javax.validation.constraints.FutureOrPresent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class OrdenReducidoDto {
	
    private Long idCliente;
	private Date fecha;
	
	@FutureOrPresent
	private Date fechaEnvio;
	private Long total;
	
	

}
