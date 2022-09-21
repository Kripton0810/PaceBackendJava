package com.paceclasses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
public class PaceBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaceBackendApplication.class, args);
		//comment hello command as
	}
	@Bean
	public Docket swaggerConfigration()
	{
		return new Docket(DocumentationType.SWAGGER_2).enable(true).apiInfo(new ApiInfoBuilder().title("API Documentation for PACE Backend").version("1.0.0").build())
				.select().apis(RequestHandlerSelectors.basePackage("com.paceclasses")).paths(PathSelectors.any()).build();
	}

}
