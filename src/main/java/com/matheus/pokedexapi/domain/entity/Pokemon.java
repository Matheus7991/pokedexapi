package com.matheus.pokedexapi.domain.entity;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Pokemon {

    private UUID id;

    private String name;

    private String type;

    private Integer height;

    private Integer weight;

    private String description;

    private String imageUrl;

    public  Pokemon(UUID id, String name, String type, Integer height, Integer weight, String description, String imageUrl){

        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Pokemon name is required");
        }

        this.id = id;
        this.name = name;
        this.type = type;
        this.height = height;
        this.weight = weight;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public void update(
            String name,
            String type,
            Integer height,
            Integer weight,
            String description,
            String imageUrl
    ){
        this.name = name;
        this.type = type;
        this.height = height;
        this.weight = weight;
        this.description = description;
        this.imageUrl = imageUrl;
    }
}
