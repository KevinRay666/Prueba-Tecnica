package com.Hero.Marvel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Hero.Marvel.dto.ApiResponse;
import com.Hero.Marvel.dto.PokemonDto;
import com.Hero.Marvel.dto.ResponseGet;
import com.Hero.Marvel.service.HeroService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/v1")
public class HeroController {

    @Autowired
    private HeroService heroService;

    @GetMapping("/pokemon")
    public ResponseEntity<ApiResponse> getAll(){

        ResponseGet list = heroService.getResponse();
        ApiResponse response = new ApiResponse("SUCCES", list);
        return new ResponseEntity<>(response,HttpStatus.OK);
        
    }

    @GetMapping("/pokemon/{id}")
    public ResponseEntity<ApiResponse> getById(@PathVariable int id){

            PokemonDto pokemon = heroService.getById(id);

            if(pokemon == null){

                ApiResponse response = new ApiResponse("BAD_REQUEST", null);
                return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

            }

            ApiResponse response = new ApiResponse("SUCCES", pokemon);
            return new ResponseEntity<>(response,HttpStatus.OK);
        
    }
    
}
