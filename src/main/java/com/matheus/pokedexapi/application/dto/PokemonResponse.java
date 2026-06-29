package com.matheus.pokedexapi.application.dto;

import java.util.UUID;

public record PokemonResponse(
        UUID id,
        String name,
        String type,
        Integer height,
        Integer weight,
        String description,
        String imageUrl
) {
}
