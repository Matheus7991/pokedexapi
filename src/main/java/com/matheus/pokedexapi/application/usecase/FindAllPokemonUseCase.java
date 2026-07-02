package com.matheus.pokedexapi.application.usecase;

import com.matheus.pokedexapi.domain.entity.Pokemon;
import com.matheus.pokedexapi.domain.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllPokemonUseCase {

    private final PokemonRepository pokemonRepository;

    public List<Pokemon> execute(){
        return pokemonRepository.findAll();
    }
}
