package com.matheus.pokedexapi.domain.repository;

import com.matheus.pokedexapi.domain.entity.Pokemon;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PokemonRepository {

    Pokemon save(Pokemon pokemon);

    Optional<Pokemon> findById(UUID id);

    Optional<Pokemon> findByName(String name);

    List<Pokemon> findAll();

    boolean existsByName(String name);

    void delete(UUID id);

}
