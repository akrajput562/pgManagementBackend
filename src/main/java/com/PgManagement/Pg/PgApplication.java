package com.PgManagement.Pg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
				title = "PG management Service REST API documentation",
				description = "pg service REST API",
				version = "v1",
				contact = @Contact(
						name="rakesh Kumar",
						email="rakeshn8811@gmail.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "sharepoint URL Product Service API",
				url = "example.com"
		)
)


@SpringBootApplication
public class PgApplication {

	public static void main(String[] args) {
		SpringApplication.run(PgApplication.class, args);
	}

}
