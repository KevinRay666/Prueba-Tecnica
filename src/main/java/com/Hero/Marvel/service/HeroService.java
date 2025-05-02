package com.Hero.Marvel.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.Hero.Marvel.dto.PokemonDto;
import com.Hero.Marvel.dto.ResponseGet;

@Service
public class HeroService {
    

    //Por temas ajenos a mi tuve que consumir otra api para realizar la prueba tecnica
    @Value("${pokemon.api.url.all}")
    private String API_URL_GET_ALL;

    @Value("${pokemon.api.url.id}")
    private String API_URL_GET_ID;

    public  ResponseGet getResponse(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseGet response = restTemplate.getForObject(API_URL_GET_ALL, ResponseGet.class);
        response.setItems(response.getResults().size());
        return response;
    }

    public PokemonDto getById(int id){
        try {

            RestTemplate restTemplate = new RestTemplate();
            PokemonDto pokemon = restTemplate.getForObject(API_URL_GET_ID + id, PokemonDto.class);
            return pokemon;

        } catch (HttpClientErrorException e) {
            
            return null;

        }

    }
    
}
