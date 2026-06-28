package com.matheus.pokedexapi.application.usecase;

import com.matheus.pokedexapi.domain.entity.Pokemon;
import com.matheus.pokedexapi.domain.exception.PokemonNotFoundException;
import com.matheus.pokedexapi.domain.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindPokemonUseCase {

    private final PokemonRepository pokemonRepository;

    public Pokemon execute(String name){
        return pokemonRepository.findByName(name)
                .orElseThrow(
                        () -> new PokemonNotFoundException(name)
                );
    }
}
