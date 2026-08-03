package com.matheus.pokedexapi.application.usecase;

import com.matheus.pokedexapi.application.dto.CreatePokemonRequest;
import com.matheus.pokedexapi.domain.entity.Pokemon;
import com.matheus.pokedexapi.domain.exception.PokemonAlreadyExistsException;
import com.matheus.pokedexapi.domain.repository.PokemonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreatePokemonUseCaseTest {

    @Mock
    private PokemonRepository pokemonRepository;

    @InjectMocks
    private CreatePokemonUseCase createPokemonUseCase;

    @Test
    void shouldCreatePokemonSuccessfully() {

        CreatePokemonRequest request = new CreatePokemonRequest(
                "Pikachu",
                "Electric",
                40,
                60,
                "Mouse Pokémon",
                "url"
        );

        Pokemon pokemon = Pokemon.builder()
                .id(UUID.randomUUID())
                .name("Pikachu")
                .type("Electric")
                .height(40)
                .weight(60)
                .description("Mouse Pokémon")
                .imageUrl("url")
                .build();


        when(pokemonRepository.existsByName("Pikachu")).thenReturn(false);

        when(pokemonRepository.save(any(Pokemon.class))).thenReturn(pokemon);

        Pokemon result = createPokemonUseCase.execute(request);

        assertEquals("Pikachu", result.getName());

        verify(pokemonRepository).save(any(Pokemon.class));

    }

    @Test
    void shouldThrowExceptionWhenPokemonAlreadyExists() {

        CreatePokemonRequest request = new CreatePokemonRequest(
                "Pikachu",
                "Electric",
                40,
                60,
                "Mouse Pokémon",
                "url"
        );

        when(pokemonRepository.existsByName(anyString())).thenReturn(true);

        PokemonAlreadyExistsException exception = assertThrows(PokemonAlreadyExistsException.class,() -> createPokemonUseCase.execute(request));

        assertEquals("Pokemon already exists: Pikachu",exception.getMessage());

        verify(pokemonRepository).existsByName("Pikachu");

        verify(pokemonRepository, never()).save(any(Pokemon.class));

    }
}
