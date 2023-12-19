package com.puce.apisql.models;

import jakarta.persistence.*;


@Entity
public class Empleado {

    @Id
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private int edad;
    private double sueldo;
    
    public Empleado() {
        super();
    }

    public Empleado(int id, String nombre, String apellido, String correo, int edad, int sueldo) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.edad = edad;
        this.sueldo = sueldo;
    }

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
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public double getSueldo() {
        return sueldo;
    }
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    
}
