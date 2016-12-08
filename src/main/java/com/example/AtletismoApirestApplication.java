package com.example;

import com.example.domain.Medalla;
import com.example.service.AtletaService;
import com.example.service.MedallaService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AtletismoApirestApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AtletismoApirestApplication.class, args);

		AtletaService atletas = context.getBean(AtletaService.class);
		atletas.Atletas();

		MedallaService  medallas = context.getBean(MedallaService.class);
		medallas.medallas();

	}
}
