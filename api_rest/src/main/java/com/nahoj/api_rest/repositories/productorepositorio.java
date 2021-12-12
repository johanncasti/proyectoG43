package com.nahoj.api_rest.repositories;

import java.util.ArrayList;

import com.nahoj.api_rest.models.modeloproducto;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface productorepositorio extends MongoRepository<modeloproducto,String> {

    ArrayList<modeloproducto> findByCategoria (String categoria);
    ArrayList<modeloproducto> findByNombre (String nombre);
    ArrayList<modeloproducto> findBycantidadGreaterThanEqual (Long cantidad);
    
    
}
