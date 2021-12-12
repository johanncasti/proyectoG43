package com.nahoj.api_rest.models;

import org.springframework.data.annotation.Id;

public class modeloproducto {

    @Id

    private String id;
    private String categoria;
    private String nombre;
    private String descripcion;
    private Long precio;
    private boolean disponibilidad;
    private Long cantidad;
    

    public modeloproducto() {
    }

    

    public modeloproducto(String id, String categoria, String nombre, String descripcion, Long precio, Long cantidad) {
        this.id = id;
        this.categoria = categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getdescripcion() {
        return descripcion;
    }

    public void setdescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getprecio() {
        return precio;
    }

    public void setprecio(Long precio) {
        this.precio = precio;
    }

    public Long getcantidad() {
        return cantidad;
    }

    public void setcantidad(Long cantidad) {
        this.cantidad = cantidad;
    }



    public String getCategoria() {
        return categoria;
    }



    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }



    public boolean isDisponibilidad() {
        return disponibilidad;
    }



    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    
    
}

