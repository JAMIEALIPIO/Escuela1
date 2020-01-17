package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductoReducidoDTO;
import com.example.demo.dto.TipoProductoDTO;
import com.example.demo.repository.TipoProductoRepository;

@RestController
@RefreshScope
public class TipoProductoController {
	
	
	@Autowired
	private TipoProductoRepository tipoProductoRepository;
	
	
	

}
