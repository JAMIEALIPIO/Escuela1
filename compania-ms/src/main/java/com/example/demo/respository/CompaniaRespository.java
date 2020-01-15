package com.example.demo.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Compania;

@Repository
public interface CompaniaRespository extends CrudRepository <Compania, Long> {
	
	

}
