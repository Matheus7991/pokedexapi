package com.matheus.pokedexapi.domain.repository;

import com.matheus.pokedexapi.domain.entity.Pokemon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PokemonRepository {

    Pokemon save(Pokemon pokemon);

    Optional<Pokemon> findById(UUID id);

    Optional<Pokemon> findByName(String name);

    Page<Pokemon> findAll(Pageable pageable);

    boolean existsByName(String name);

    void delete(UUID id);

}
