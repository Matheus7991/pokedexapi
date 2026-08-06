package com.matheus.pokedexapi.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI pokemonOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Pokemon API")
                        .description("API desenvolvida utilizando Spring Boot 3, Java 17 e Clean Architecture")
                        .version("1.0.0"));
    }
}
