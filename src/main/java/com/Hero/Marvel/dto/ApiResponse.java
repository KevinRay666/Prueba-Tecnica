package com.Hero.Marvel.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
    
    String status;
    Object data;

    public ApiResponse(String status, Object data){
        this.data = data;
        this.status = status;
    }
    
}
