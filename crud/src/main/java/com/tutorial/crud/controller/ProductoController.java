package com.tutorial.crud.controller;

import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.dto.ProductoDto;
import com.tutorial.crud.entity.Producto;
import com.tutorial.crud.service.ProductoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    // READ
    @GetMapping("/lista")
    public ResponseEntity<List<Producto>> list(){
        List<Producto> list = productoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    // FIND BY ID
    @GetMapping("/detail/{id}")
    public ResponseEntity<Producto> getById(@PathVariable("id") int id){
        if (!productoService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }else{
            Producto producto = productoService.getOne(id).get();
            return new ResponseEntity(producto, HttpStatus.OK);
        }
    }

    //FIND BY NOMBRE
    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<Producto> getByNombre(@PathVariable("nombre") String nombre){
        if (!productoService.existByNombre(nombre)){
            return new ResponseEntity(new Mensaje("No existe producto !!"), HttpStatus.NOT_FOUND);
        }else{
            Producto producto = productoService.getNombre(nombre).get();
            return new ResponseEntity(producto, HttpStatus.OK);
        }
    }

    // CREATE
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductoDto productoDto){
        if(StringUtils.isBlank(productoDto.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(productoDto.getPrecio() < 0){
            return new ResponseEntity(new Mensaje("El precio debe ser mayor a 0"), HttpStatus.BAD_REQUEST);
        }
        if(productoService.existByNombre(productoDto.getNombre())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        Producto producto = new Producto(productoDto.getNombre(), productoDto.getPrecio());
        productoService.save(producto);
        return new ResponseEntity(new Mensaje("Producto creado"), HttpStatus.OK);
    }

    @PostMapping("/createList")
    public ResponseEntity<?> createList(@RequestBody ArrayList<ProductoDto> listProductsDto){
        for (int i = 0; i < listProductsDto.size(); i++)
        {
            Producto producto = new Producto(listProductsDto.get(i).getNombre(), listProductsDto.get(i).getPrecio());
            List<Producto> list = new ArrayList<>();
            list.add(producto);
            productoService.saveList(list);

        }
        return new ResponseEntity(new Mensaje("Productos creados !!"), HttpStatus.OK);
    }




    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProductoDto productoDto){
        if(!productoService.existsById(id)){
            return new ResponseEntity(new Mensaje("El producto no existe"), HttpStatus.NOT_FOUND);
        }
        if(productoService.existByNombre(productoDto.getNombre()) && productoService.getNombre(productoDto.getNombre()).get().getIdProducto() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(productoDto.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(productoDto.getPrecio() < 0){
            return new ResponseEntity(new Mensaje("El precio debe ser mayor a 0"), HttpStatus.BAD_REQUEST);
        }

        Producto producto = productoService.getOne(id).get();
        producto.setNombre(productoDto.getNombre());
        producto.setPrecio(productoDto.getPrecio());
        productoService.save(producto);
        return new ResponseEntity(new Mensaje("Producto Actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!productoService.existsById(id)){
            return new ResponseEntity(new Mensaje("Producto no existe !!"), HttpStatus.NOT_FOUND);
        }
        productoService.delete(id);
        return new ResponseEntity(new Mensaje("Producto Eliminado !!"), HttpStatus.OK);
    }






}
