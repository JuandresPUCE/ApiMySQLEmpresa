package com.puce.apisql.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.puce.apisql.models.Producto;
//segundo crear el repositorio
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    //metodo para buscar por nombre
    List<Producto> findByNombre(String nombre);
    //metodo para buscar por precio
    List<Producto> findByPrecio(double precio);
    //metodo para buscar por precio menor o igual
    List<Producto> findByPrecioLessThanEqual(double precio);
    //metodo para buscar por precio mayor o igual
    List<Producto> findByPrecioGreaterThanEqual(double precio);
    //buscar nombre que contiene o empieza con
    List<Producto> findByNombreContainingOrNombreStartingWith(String nombre, String nombre2);
}
