package com.gradprogram.mylibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "MyLibrary", version = "1.0", description = "MyLibrary APIs"))
public class MylibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MylibraryApplication.class, args);
	}

}
