package com.example.demo.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import com.example.demo.entidad.DetalleOrden;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Setter
@Getter
public class OrdenDTO {
	
	private Long id;
	private Long idCliente;
	
	private Date fecha;
	
	
	private Date fechaEnvio;
	
	private Long total;
	
	


}
