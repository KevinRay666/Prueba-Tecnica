package com.Hero.Marvel.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Hero.Marvel.dto.ResponseGet;

@Service
public class HeroService {
    

    //Por temas ajenos a mi tuve que consumir esta api para realizar la prueba tecnica
    private final String API_URL = "https://pokeapi.co/api/v2/pokemon?limit=25";

    public  ResponseGet getResponse(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseGet response = restTemplate.getForObject(API_URL, ResponseGet.class);
        response.setItems(response.getResults().size());
        return response;
    }
    
}
