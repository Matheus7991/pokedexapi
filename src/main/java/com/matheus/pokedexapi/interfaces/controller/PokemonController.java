package com.matheus.pokedexapi.interfaces.controller;

import com.matheus.pokedexapi.application.dto.CreatePokemonRequest;
import com.matheus.pokedexapi.application.dto.PokemonResponse;
import com.matheus.pokedexapi.application.dto.UpdatePokemonRequest;
import com.matheus.pokedexapi.application.mapper.PokemonResponseMapper;
import com.matheus.pokedexapi.application.usecase.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
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
    private final DeletePokemonUseCase deletePokemonUseCase;

    @Operation(summary = "Buscar Pokémon por ID", description = "Retorna um Pokémon a partir do seu UUID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pokémon encontrado com sucesso"),
            @ApiResponse(responseCode = "404",description = "Pokémon não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<PokemonResponse> findById(
            @Parameter(description = "UUID do Pokémon", example = "550e8400-e29b-41d4-a716-446655440000")
            @PathVariable UUID id){
        var pokemon = findPokemonByIdUseCase.execute(id);

        return ResponseEntity.ok(PokemonResponseMapper.toResponse(pokemon));
    }

    @Operation(summary = "Buscar Pokémon pelo nome", description = "Retorna um Pokémon a partir do seu nome")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pokémon encontrado com sucesso"),
            @ApiResponse(responseCode = "404",description = "Pokémon não encontrado")
    })
    @GetMapping("/name/{name}")
    public ResponseEntity<PokemonResponse> findByName(
            @Parameter(description = "Nome do Pokémon", example = "Pikachu")
            @PathVariable String name){

        var pokemon = findPokemonUseCase.execute(name);

        return ResponseEntity.ok(PokemonResponseMapper.toResponse(pokemon));
    }

    @Operation(summary = "Listar Pokémons", description = "Retorna uma lista paginada de Pokémons.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    @GetMapping()
    public ResponseEntity<Page<PokemonResponse>> findAll(@ParameterObject Pageable pageable){

        return ResponseEntity.ok(findAllPokemonUseCase.execute(pageable).map(PokemonResponseMapper::toResponse));

    }

    @Operation(summary = "Alterar um Pokémon por ID", description = "Altera um Pokémon a partir do seu UUID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pokémon alterado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "409", description = "Já existe um Pokémon com esse nome")
    })
    @PutMapping("/{id}")
    public ResponseEntity<PokemonResponse> update(
            @Parameter(description = "UUID do Pokémon", example = "550e8400-e29b-41d4-a716-446655440000")
            @PathVariable UUID id,
            @Valid
            @RequestBody UpdatePokemonRequest request){

        var pokemon = updatePokemonUseCase.execute(id, request);

        return ResponseEntity.ok(PokemonResponseMapper.toResponse(pokemon));
    }

    @Operation(summary = "Criar um novo Pokémon", description = "Cadastra um novo Pokémon no banco de dados.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Pokémon criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "409", description = "Já existe um Pokémon com esse nome")
    })
    @PostMapping
    public ResponseEntity<PokemonResponse> create(@RequestBody @Valid CreatePokemonRequest request){
        var pokemon = createPokemonUseCase.execute(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(PokemonResponseMapper.toResponse(pokemon));
    }

    @Operation(summary = "Deletar Pokémon por ID", description = "Deleta um Pokémon a partir do seu UUID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Pokémon deletado com sucesso"),
            @ApiResponse(responseCode = "404",description = "Pokémon não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "UUID do Pokémon", example = "550e8400-e29b-41d4-a716-446655440000")
            @PathVariable UUID id){

        deletePokemonUseCase.execute(id);

        return ResponseEntity.noContent().build();
    }

}
