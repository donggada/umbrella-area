package com.example.umbrellaarea.umbrellaarea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;
import java.util.UUID;

@EnableJpaAuditing
@SpringBootApplication
public class UmbrellaAreaApplication {

	public static void main(String[] args) {
		SpringApplication.run(UmbrellaAreaApplication.class, args);

	}

//	@Bean
//	public AuditorAware<String> auditorProvider () {
//		//TODO SESSION 으로 변경
//		return () -> Optional.of(UUID.randomUUID().toString());
//	}

}
