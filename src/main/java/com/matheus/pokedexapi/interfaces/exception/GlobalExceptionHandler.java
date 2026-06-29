package com.matheus.pokedexapi.interfaces.exception;

import com.matheus.pokedexapi.domain.exception.PokemonNotFoundException;
import com.matheus.pokedexapi.interfaces.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PokemonNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePokemonNotFound(
            PokemonNotFoundException exception
    ){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(
                        new ErrorResponse(
                                404,
                                exception.getMessage()
                        )
                );
    }
}
