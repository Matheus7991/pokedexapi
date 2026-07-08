package com.matheus.pokedexapi.application.usecase;

import com.matheus.pokedexapi.application.dto.UpdatePokemonRequest;
import com.matheus.pokedexapi.domain.entity.Pokemon;
import com.matheus.pokedexapi.domain.exception.PokemonNotFoundException;
import com.matheus.pokedexapi.domain.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdatePokemonUseCase {

    private final PokemonRepository pokemonRepository;

    public Pokemon execute(UUID id, UpdatePokemonRequest request){

        Pokemon pokemon = pokemonRepository.findById(id)
                .orElseThrow(() ->
                        new PokemonNotFoundException(id.toString()));

        pokemon.update(
                request.name(),
                request.type(),
                request.height(),
                request.weight(),
                request.description(),
                request.imageUrl()
        );

        return pokemonRepository.save(pokemon);
    }
}
