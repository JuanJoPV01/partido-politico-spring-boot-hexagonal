package com.example.partidopolitico.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestión de Partidos Políticos")
                        .description("CRUD de Partidos Políticos con Arquitectura Hexagonal, DDD y CQRS")
                        .version("1.0.0"));
    }
}