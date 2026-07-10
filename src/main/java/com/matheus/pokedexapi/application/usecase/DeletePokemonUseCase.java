package com.matheus.pokedexapi.application.usecase;

import com.matheus.pokedexapi.domain.exception.PokemonNotFoundException;
import com.matheus.pokedexapi.domain.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletePokemonUseCase {

    private final PokemonRepository pokemonRepository;

    public void execute(UUID id) {

        pokemonRepository.findById(id)
                .orElseThrow(() ->
                        new PokemonNotFoundException(id.toString()));

        pokemonRepository.delete(id);
    }
}
