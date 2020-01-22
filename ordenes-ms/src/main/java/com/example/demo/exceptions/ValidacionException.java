package com.example.demo.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class ValidarDni  extends Exception{
	
private static final long serialVersionUID=1L;
	
	private String message;

}
