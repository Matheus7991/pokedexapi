package com.matheus.pokedexapi.application.usecase;

import com.matheus.pokedexapi.application.dto.CreatePokemonRequest;
import com.matheus.pokedexapi.domain.entity.Pokemon;
import com.matheus.pokedexapi.domain.exception.PokemonAlreadyExistsException;
import com.matheus.pokedexapi.domain.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePokemonUseCase {

    private final PokemonRepository pokemonRepository;

    public Pokemon execute(CreatePokemonRequest request){

        if(pokemonRepository.existsByName(request.name())){
            throw new PokemonAlreadyExistsException(request.name());
        }

        Pokemon pokemon = new Pokemon(
                null,
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
