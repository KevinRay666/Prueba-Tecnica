package com.Hero.Marvel.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ResponseGet {

    private int items;
    private List<PokemonSummary> results;
    
}
