package com.practicos.ejercicio1.modelo;

public class Plato {

    private Integer numPlato;
    private String nombre;
    private Double precio;
    private String descripcion;
    
    public Plato(Integer numPlato, String nombre, Double precio, String descripcion) {
        this.numPlato = numPlato;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public Integer getNumPlato() {
        return numPlato;
    }

    public void setNumPlato(Integer numPlato) {
        this.numPlato = numPlato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}