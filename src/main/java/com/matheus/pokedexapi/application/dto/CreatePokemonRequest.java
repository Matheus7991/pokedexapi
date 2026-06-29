package com.matheus.pokedexapi.application.dto;

import jakarta.validation.constraints.NotBlank;

public record CreatePokemonRequest(

        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Type is required")
        String type,

        Integer height,

        Integer weight,

        String description,

        String imageUrl
) {
}
