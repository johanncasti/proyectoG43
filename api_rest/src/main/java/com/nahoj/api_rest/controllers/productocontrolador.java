
package com.nahoj.api_rest.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.nahoj.api_rest.models.modeloproducto;
import com.nahoj.api_rest.services.productoservicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping("/producto")

public class productocontrolador {

    @Autowired
    productoservicio productoservicio;

    @GetMapping()
    public ArrayList<modeloproducto> obtenerListaproductos(){
        return productoservicio.obtenerproductos();
    }

    @PostMapping()
    public modeloproducto guardarproductoNuevo(@RequestBody modeloproducto producto) {

        return productoservicio.guardarproducto(producto);
    }

    @DeleteMapping(path ="/{id}")
    public String eliminarproducto(@PathVariable("id") String id){
        if(productoservicio.eliminarproducto(id)){

            return "se eliminó el producto con el ID: "+id;
        }else{

            return "no existe un producto con ID: "+id;


        }

    }

    @GetMapping(value="/{id}")
    public Optional<modeloproducto> obtenerproductoporid(@PathVariable("id") String id) {
        return productoservicio.obtenerporid(id);
    }

    @GetMapping(value="/categoria/{categoria}")
    public ArrayList<modeloproducto> obtenerproductoporcategoria(@PathVariable("categoria") String categoria) {
        return productoservicio.obtenerporcategoria(categoria);
    }

    @GetMapping(value="/nombre/{nombre}")
    public ArrayList<modeloproducto> obtenerproductopornombre(@PathVariable("nombre") String nombre) {
        return productoservicio.obtenerpornombre(nombre);
    }


    @GetMapping(value="/cantidad/{cantidad}")
    public ArrayList<modeloproducto> obtenerporcantidad(@PathVariable("cantidad") Long cantidad) {
        return productoservicio.obtenerporcantidad(cantidad);
    }
    
    
    
}
