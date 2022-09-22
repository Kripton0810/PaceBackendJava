package com.paceclasses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
// @EnableSwagger2
public class PaceBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaceBackendApplication.class, args);
		// comment hello command as
	}

}
