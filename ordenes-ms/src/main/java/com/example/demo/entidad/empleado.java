package com.example.demo.entidad;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class empleado {
	
	private Long id;
	
	private String nombre;
	
	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	private String dni;
	
	private Date fechaIngreso;
	
	private Boolean activo;
	
	private String empresa;

}
