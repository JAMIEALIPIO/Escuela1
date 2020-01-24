package com.example.demo.respository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Persona;
import com.example.demo.util.CustomRepository;

@Repository
public interface PersonaRespository extends CustomRepository<Persona, Long> {
	
	Optional <Persona> findByDni(String dni);
}