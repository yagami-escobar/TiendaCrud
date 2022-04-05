package com.tutorial.crud.service;

import com.tutorial.crud.entity.Producto;
import com.tutorial.crud.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    //CREATE PRODUCT
    public void save(Producto producto){
        productoRepository.save(producto);
    }

    //CREATE PRODUCT
    public void saveList(List<Producto> listProducts) {
        productoRepository.saveAll(listProducts);
    }

    //READ PRODUCTOS
    public List<Producto> list(){
        return productoRepository.findAll();
    }

    //DELETE PRODUCT
    public void delete(int id){
        productoRepository.deleteById(id);
    }

    // FIND PRODUCT BY ID
    public Optional<Producto> getOne(int id){
        return productoRepository.findById(id);
    }

    // FIND PRODUCT BY NOMBRE
    public Optional<Producto> getNombre(String nombre){
        return productoRepository.findByNombre(nombre);
    }


    // EXIST PRODUCT BY ID
    public boolean existsById(int id){
        return productoRepository.existsById(id);
    }

    //EXIST PRODUCT BY NOMBRE
    public boolean existByNombre(String nombre){
        return productoRepository.existsByNombre(nombre);
    }



}
