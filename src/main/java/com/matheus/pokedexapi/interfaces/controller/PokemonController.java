package com.matheus.pokedexapi.interfaces.controller;

import com.matheus.pokedexapi.application.usecase.FindPokemonUseCase;
import com.matheus.pokedexapi.domain.entity.Pokemon;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
@RequiredArgsConstructor
public class PokemonController {

    private final FindPokemonUseCase findPokemonUseCase;


    @GetMapping("/name/{name}")
    public ResponseEntity<Pokemon> findByName(
            @PathVariable String name
    ){

        return ResponseEntity.ok(findPokemonUseCase.execute(name));
    }

}
