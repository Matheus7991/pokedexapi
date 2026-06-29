package com.matheus.pokedexapi.interfaces.exception;

public record ErrorResponse(
        int status,
        String message
) {
}
