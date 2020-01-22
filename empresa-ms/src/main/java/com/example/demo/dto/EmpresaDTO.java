package com.example.demo.dto;


import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Setter
@Getter

public class EmpresaDTO {
	
	private Long id;
	
	private String nombre;
	
	private String ruc;
	
	private String direccion;

}
