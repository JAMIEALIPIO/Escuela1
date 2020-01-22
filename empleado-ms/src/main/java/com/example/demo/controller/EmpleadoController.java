package com.example.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmpleadoDTO;
import com.example.demo.dto.EmpresaDTO;
import com.example.demo.entidad.Empleado;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.service.EmpleadoService;
import com.example.demo.service.FeignService;
import com.example.demo.service.Impl.FeignServiceImpl;

@RestController
public class EmpleadoController {
	
	
	@Autowired
	private EmpleadoService empleadoService;
	
	
	@Autowired
	private FeignServiceImpl feignService;
	
	@GetMapping("/empleado/{idEmpleado}")
	public EmpleadoDTO obtenerEmpleadoPorId(@PathVariable("idEmpleado") Long id) throws ResourceNotFoundException{

		ModelMapper mapper=new ModelMapper();
		Empleado empleado=empleadoService.obtenerEmpleadoPorId(id);

	    EmpleadoDTO empleadodto=mapper.map(empleado, EmpleadoDTO.class);
	    empleadodto.setEmpresa(feignService.obtenerEmpleadosEmpresa(id).getNombre());
	    //EmpresaDTO empleadoDTO=feignService.obtenerEmpleadosEmpresa(id);
	   
		//return empleadoDTO;
		return empleadodto;
		

}
}

