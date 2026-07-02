package com.matheus.pokedexapi.infrastructure.database.repository;

import com.matheus.pokedexapi.infrastructure.database.entity.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PokemonJpaRepository extends JpaRepository<PokemonEntity, UUID> {

    Optional<PokemonEntity> findByName(String name);

    boolean existsByName(String name);
}
