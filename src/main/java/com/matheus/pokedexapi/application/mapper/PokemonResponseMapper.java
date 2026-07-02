package com.matheus.pokedexapi.application.mapper;

import com.matheus.pokedexapi.application.dto.PokemonResponse;
import com.matheus.pokedexapi.domain.entity.Pokemon;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class PokemonResponseMapper {

    public static PokemonResponse toResponse(Pokemon pokemon){
        return new PokemonResponse(
                pokemon.getId(),
                pokemon.getName(),
                pokemon.getType(),
                pokemon.getHeight(),
                pokemon.getWeight(),
                pokemon.getDescription(),
                pokemon.getImageUrl()
        );
    }

    public static List<PokemonResponse> toResponseList(List<Pokemon> pokemons){
        return pokemons.stream()
                .map(PokemonResponseMapper::toResponse)
                .toList();
    }


}
