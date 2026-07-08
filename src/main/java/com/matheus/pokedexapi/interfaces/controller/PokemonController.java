package com.matheus.pokedexapi.interfaces.controller;

import com.matheus.pokedexapi.application.dto.CreatePokemonRequest;
import com.matheus.pokedexapi.application.dto.PokemonResponse;
import com.matheus.pokedexapi.application.dto.UpdatePokemonRequest;
import com.matheus.pokedexapi.application.mapper.PokemonResponseMapper;
import com.matheus.pokedexapi.application.usecase.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/pokemon")
@RequiredArgsConstructor
public class PokemonController {

    private final FindPokemonUseCase findPokemonUseCase;
    private final CreatePokemonUseCase createPokemonUseCase;
    private final FindAllPokemonUseCase findAllPokemonUseCase;
    private final FindPokemonByIdUseCase findPokemonByIdUseCase;
    private final UpdatePokemonUseCase updatePokemonUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<PokemonResponse> findById(@PathVariable UUID id){
        var pokemon = findPokemonByIdUseCase.execute(id);

        return ResponseEntity.ok(PokemonResponseMapper.toResponse(pokemon));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PokemonResponse> findByName(
            @PathVariable String name
    ){

        var pokemon = findPokemonUseCase.execute(name);

        return ResponseEntity.ok(PokemonResponseMapper.toResponse(pokemon));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<PokemonResponse>> findAll(Pageable pageable){

        return ResponseEntity.ok(findAllPokemonUseCase.execute(pageable).map(PokemonResponseMapper::toResponse));

    }

    @PutMapping("/{id}")
    public ResponseEntity<PokemonResponse> update(@PathVariable UUID id, @Valid @RequestBody UpdatePokemonRequest request){

        var pokemon = updatePokemonUseCase.execute(id, request);

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
