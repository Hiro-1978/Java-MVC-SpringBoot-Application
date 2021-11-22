package com.hiro11.fleeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@SpringBootApplication
public class FleeappApplication {

	@Bean
	public AuditorAware<String> auditorAware(){
		return new SpringSecurityAditorAware();
	}

	public static void main(String[] args) {
		SpringApplication.run(FleeappApplication.class, args);
	}

}
