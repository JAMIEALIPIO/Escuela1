package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.util.CustomRepositoryImpl;

@EnableDiscoveryClient
@EnableJpaRepositories(repositoryBaseClass = CustomRepositoryImpl.class)
@SpringBootApplication
public class EscuelaProductoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscuelaProductoApplication.class, args);
	}

}
