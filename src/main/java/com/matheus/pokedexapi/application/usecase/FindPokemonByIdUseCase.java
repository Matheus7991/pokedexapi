package com.matheus.pokedexapi.application.usecase;

import com.matheus.pokedexapi.domain.entity.Pokemon;
import com.matheus.pokedexapi.domain.exception.PokemonNotFoundException;
import com.matheus.pokedexapi.domain.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindPokemonByIdUseCase {

    private final PokemonRepository pokemonRepository;

    public Pokemon execute(UUID id){
        return pokemonRepository.findById(id)
                .orElseThrow(
                        () -> new PokemonNotFoundException(id.toString())
                );
    }
}
