package com.matheus.pokedexapi.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public record PokemonResponse(

        @Schema(description = "Identificador único do Pokémon", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID id,

        @Schema(description = "Nome do Pokémon", example = "Pikachu")
        String name,

        @Schema(description = "Tipo do Pokémon", example = "Electric")
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