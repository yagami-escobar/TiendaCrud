package com.tutorial.crud.dto;

import lombok.Getter;
import lombok.Setter;

public class Mensaje {
    @Getter @Setter
    private String mensaje;


    public Mensaje(String mensaje){
        this.mensaje = mensaje;
    }



}
