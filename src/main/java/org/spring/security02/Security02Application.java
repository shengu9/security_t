package org.spring.security02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing   // BaseEntity 설정
public class Security02Application {

	public static void main(String[] args) {
		SpringApplication.run(Security02Application.class, args);
	}

}
