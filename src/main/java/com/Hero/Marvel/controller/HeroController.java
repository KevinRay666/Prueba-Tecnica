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
import com.Hero.Marvel.util.BadResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/v1")
public class HeroController {

    @Autowired
    private HeroService heroService;

    @GetMapping("/pokemon")
    public ResponseEntity<ApiResponse> getAll(@RequestParam int limit){

        if(limit <= 0 || limit >=100){

            BadResponse badResponse = new BadResponse(null, null);
            badResponse.setErrorCode("INVALID_LIMIT");
            badResponse.setMessage("Limit Invalido");
            ApiResponse response = new ApiResponse("ERROR", "CANCEL",badResponse);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

        }

        ResponseGet list = heroService.getResponse(limit);
        ApiResponse response = new ApiResponse("SUCCES","CONTINUE",list);
        return new ResponseEntity<>(response,HttpStatus.OK);
        
    }

    @GetMapping("/pokemon/{id}")
    public ResponseEntity<ApiResponse> getById(@PathVariable int id){

            PokemonDto pokemon = heroService.getById(id);

            if(pokemon == null){

                BadResponse badResponse = new BadResponse(null, null);
                badResponse.setErrorCode("ID_INVALIDO");
                badResponse.setMessage("Ingrese un Id valido");
                ApiResponse response = new ApiResponse("ERROR", "CANCEL",badResponse);
                return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

            }

            ApiResponse response = new ApiResponse("SUCCES","CONTINUE",pokemon);
            return new ResponseEntity<>(response,HttpStatus.OK);
        
    }
    
}
