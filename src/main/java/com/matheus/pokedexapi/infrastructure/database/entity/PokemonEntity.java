package com.matheus.pokedexapi.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "pokemon")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PokemonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    private Integer height;

    private Integer weight;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

}
