package com.Hero.Marvel.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
    
    String status;
    String action;
    Object data;

    public ApiResponse(String status, String action, Object data){
        this.data = data;
        this.status = status;
        this.action = action;
    }
    
}
