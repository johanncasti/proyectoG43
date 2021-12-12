package com.nahoj.api_rest.services;

import java.util.ArrayList;
import java.util.Optional;

import com.nahoj.api_rest.models.modeloproducto;
import com.nahoj.api_rest.repositories.productorepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class productoservicio {

    @Autowired
    productorepositorio productorepositorio;

    public ArrayList<modeloproducto> obtenerproductos(){
        return (ArrayList<modeloproducto>) productorepositorio.findAll();            

    }

    public modeloproducto guardarproducto(modeloproducto producto){
        return productorepositorio.save(producto);

    }

    public boolean eliminarproducto(String id){
        if(productorepositorio.existsById(id)){
            productorepositorio.deleteById(id);
            return true;
        }
        else{
            return false;
        }

    }

    public Optional<modeloproducto> obtenerporid(String id){
        return productorepositorio.findById(id);
    }

    public ArrayList<modeloproducto> obtenerporcategoria(String categoria){

        return productorepositorio.findByCategoria(categoria);
    }

    public ArrayList<modeloproducto> obtenerpornombre(String nombre){

        return productorepositorio.findByNombre(nombre);
    }

    public ArrayList<modeloproducto> obtenerporcantidad(Long cantidad){

        return productorepositorio.findBycantidadGreaterThanEqual(cantidad);
    }


    
}
