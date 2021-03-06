package com.tutorial.crud.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private int idProducto;
    @Getter @Setter
    private String nombre;
    @Getter @Setter
    private float precio;

    public Producto(){

    }

    public Producto(String nombre, float precio){
        this.nombre = nombre;
        this.precio = precio;
    }


}
