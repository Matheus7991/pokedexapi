package com.matheus.pokedexapi.infrastructure.database.repository;

import com.matheus.pokedexapi.domain.entity.Pokemon;
import com.matheus.pokedexapi.domain.repository.PokemonRepository;
import com.matheus.pokedexapi.infrastructure.database.mapper.PokemonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PokemonRepositoryImpl implements PokemonRepository {

    private final PokemonJpaRepository pokemonJpaRepository;

    @Override
    public Pokemon save(Pokemon pokemon){
        var entity = PokemonMapper.toEntity(pokemon);

        var savedEntity = pokemonJpaRepository.save(entity);

        return PokemonMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Pokemon> findById(UUID id){

        return pokemonJpaRepository.findById(id)
                .map(PokemonMapper::toDomain);
    }

    public Optional<Pokemon> findByName(String name){

        return pokemonJpaRepository.findByName(name)
                .map(PokemonMapper::toDomain);
    }

    @Override
    public void delete(UUID id) {

        pokemonJpaRepository.deleteById(id);
    }

}
