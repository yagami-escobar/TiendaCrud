package com.tutorial.crud.dto;

import com.sun.istack.NotNull;
import com.tutorial.crud.entity.Producto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

public class ProductoDto {
    @NotNull
    @Getter @Setter
    private String nombre;
    @Getter @Setter
    private float precio;


    public ProductoDto(){

    }

    public ProductoDto(String nombre, float precio){
        this.nombre = nombre;
        this.precio = precio;
    }
}
