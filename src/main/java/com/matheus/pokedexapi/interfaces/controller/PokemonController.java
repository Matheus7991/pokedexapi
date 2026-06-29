package com.matheus.pokedexapi.interfaces.controller;

import com.matheus.pokedexapi.application.dto.CreatePokemonRequest;
import com.matheus.pokedexapi.application.dto.PokemonResponse;
import com.matheus.pokedexapi.application.mapper.PokemonResponseMapper;
import com.matheus.pokedexapi.application.usecase.CreatePokemonUseCase;
import com.matheus.pokedexapi.application.usecase.FindPokemonUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pokemon")
@RequiredArgsConstructor
public class PokemonController {

    private final FindPokemonUseCase findPokemonUseCase;
    private final CreatePokemonUseCase createPokemonUseCase;


    @GetMapping("/name/{name}")
    public ResponseEntity<PokemonResponse> findByName(
            @PathVariable String name
    ){

        var pokemon = findPokemonUseCase.execute(name);

        return ResponseEntity.ok(PokemonResponseMapper.toResponse(pokemon));
    }

    @PostMapping
    public ResponseEntity<PokemonResponse> create(
            @RequestBody @Valid CreatePokemonRequest request
            ){
        var pokemon = createPokemonUseCase.execute(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(PokemonResponseMapper.toResponse(pokemon));
    }

}
