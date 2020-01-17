package com.example.demo.ServiceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Service.TipoProductoService;
import com.example.demo.entidad.TipoProducto;

@Transactional(readOnly = true)
@Service
public class TipoProductoServiceImpl implements TipoProductoService {

	@Override
	public TipoProducto guardarTipoProducto(TipoProducto tipoProducto) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	

}
