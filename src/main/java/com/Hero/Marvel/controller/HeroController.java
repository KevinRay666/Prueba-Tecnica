package com.Hero.Marvel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hero.Marvel.dto.ApiResponse;
import com.Hero.Marvel.dto.ResponseGet;
import com.Hero.Marvel.service.HeroService;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/heroes")
public class HeroController {

    @Autowired
    private HeroService heroService;

    @GetMapping("/character")
    public ResponseEntity<ApiResponse> getAll(){

        ResponseGet list = heroService.getResponse();
        ApiResponse response = new ApiResponse("SUCCES", list);
        return new ResponseEntity<>(response,HttpStatus.OK);
        
    }
    
}
