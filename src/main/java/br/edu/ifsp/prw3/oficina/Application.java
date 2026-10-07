package br.edu.ifsp.prw3.oficina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class Application {

	public static void main(String[] args) {

		// Membros do Grupo: Eduardo Sorrigotti Tahara// SC3052621

		SpringApplication.run(Application.class, args);
	}

}
