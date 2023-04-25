package com.atg.kogas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class KogasApplication {

	public static void main(String[] args) {
		SpringApplication.run(KogasApplication.class, args);
	}

}
