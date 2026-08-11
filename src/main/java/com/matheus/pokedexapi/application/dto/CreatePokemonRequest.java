package com.matheus.pokedexapi.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record CreatePokemonRequest(

        @Schema(description = "Nome do Pokémon", example = "Pikachu")
        @NotBlank(message = "Name is required")
        String name,

        @Schema(description = "Tipo do Pokémon", example = "Electric")
        @NotBlank(message = "Type is required")
        String type,

        @Schema(description = "Altura do Pokémon", example = "40")
        Integer height,

        @Schema(description = "Peso do Pokémon", example = "60")
        Integer weight,

        @Schema(description = "Descrição do Pokémon", example = "Mouse Pokémon")
        String description,

        @Schema(description = "URL da imagem do Pokémon", example = "https://example.com/pikachu.png")
        String imageUrl
) {
}
