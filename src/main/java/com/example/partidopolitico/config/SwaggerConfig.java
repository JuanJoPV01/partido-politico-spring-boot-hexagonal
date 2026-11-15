package com.example.partidopolitico.config;

import io.swagger.v3.core.ApiInfo;
import io.swagger.v3.core.ApiInfoBuilder;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        SecurityRequirement securityRequirement = new SecurityRequirement()
                .addList("Bearer Authentication");

        Components components = new Components()
                .addSecuritySchemes("Bearer Authentication", new SecurityScheme()
                        .name("Authorization")
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("Bearer")
                        .bearerFormat("JWT"));

        return new OpenAPI()
                .info(apiInfo())
                .security(Arrays.asList(securityRequirement))
                .components(components);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API de Gestión de Partido Político")
                .description("API REST para CRUD completo de PartidoPolítico con arquitectura hexagonal, DDD y CQRS")
                .version("1.0.0")
                .build();
    }
}