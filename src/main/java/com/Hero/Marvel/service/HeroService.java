package com.Hero.Marvel.service;

import org.springframework.stereotype.Service;

import com.Hero.Marvel.dto.Response;

@Service
public class HeroService {

    public Response getResponse(){
        Response response = new Response();
        response.setName("Hola");
        response.setEdad(123);
        return response;
    }
    
}
