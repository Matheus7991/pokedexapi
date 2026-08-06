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

        Integer height,

        Integer weight,

        String description,

        String imageUrl
) {
}
