package com.exemplo.starterkit;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info =
@Info(title = "API REST Spring Boot Test", version = "1.0.0", description = "Exemplo de aplicação para testar conhecimentos"))
public class StarterKitApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarterKitApplication.class, args);
	}

}
