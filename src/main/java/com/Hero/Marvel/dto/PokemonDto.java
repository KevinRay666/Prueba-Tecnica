package com.Hero.Marvel.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PokemonDto {

    Integer id;
    String name;
    Integer height;
    List<Abilities> abilities;
    
}
