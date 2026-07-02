package com.matheus.pokedexapi.domain.exception;

public class PokemonAlreadyExistsException  extends RuntimeException{

    public PokemonAlreadyExistsException(String name){
        super("Pokemon already exists: " + name);
    }
}
