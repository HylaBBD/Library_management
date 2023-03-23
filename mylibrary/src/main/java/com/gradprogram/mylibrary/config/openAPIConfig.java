package com.gradprogram.mylibrary.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "MyLibrary", version = "1.0",description = "MyLibrary APIs"))
public class openAPIConfig {
    
}
