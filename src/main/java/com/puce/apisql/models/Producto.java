package com.puce.apisql.models;

import jakarta.persistence.*;

@Entity
public class Producto {
    //entidad con los productos
    //ID, nombre, descripcion, precio
    @Id
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    
   //constructor con super() y parametros
    public Producto(int id, String nombre, String descripcion, double precio) {
        
        super();
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    //constructor vacio
    public Producto() {
        
        super();
    }


    //getters setters y constructor
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    //constructor
    

    
}
