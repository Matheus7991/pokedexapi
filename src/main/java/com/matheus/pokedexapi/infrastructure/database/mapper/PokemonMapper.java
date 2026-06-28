package com.matheus.pokedexapi.infrastructure.database.mapper;

import com.matheus.pokedexapi.domain.entity.Pokemon;
import com.matheus.pokedexapi.infrastructure.database.entity.PokemonEntity;

public class PokemonMapper {


    public static Pokemon toDomain(PokemonEntity entity){
        return new Pokemon(
                entity.getId(),
                entity.getName(),
                entity.getType(),
                entity.getHeight(),
                entity.getWeight(),
                entity.getDescription(),
                entity.getImageUrl());
    }

    public static PokemonEntity toEntity(Pokemon pokemon){

        return PokemonEntity.builder()
                .name(pokemon.getName())
                .type(pokemon.getType())
                .height(pokemon.getHeight())
                .weight(pokemon.getWeight())
                .description(pokemon.getDescription())
                .imageUrl(pokemon.getImageUrl())
                .build();
    }

}
