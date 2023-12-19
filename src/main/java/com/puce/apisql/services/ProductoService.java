package com.puce.apisql.services;
//tercero crear el servicio
import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//importar modelo y repositorio
import com.puce.apisql.models.Producto;
import com.puce.apisql.repositories.ProductoRepository;

//se requiere la anotacion @Service
@Service
public class ProductoService {
    //inyectar el repositorio

    @Autowired
    //objeto de tipo ProductoRepository
    private ProductoRepository productoRepository;

    //para interactuar con la base de datos
    //select *
    public List<Producto> listarProductos() {
        //retornar todos los productos
        return productoRepository.findAll();
    }
    //select por id
    public Producto obtenerProductoPorId(int id) {
        //buscar producto por id
        return productoRepository.findById(id).orElseThrow();
    }
    //insert
    public void guardarProducto (Producto producto) {
        //guardar producto
        productoRepository.save(producto);
    }

    //update
    public void actualizarProducto (Producto producto) {
        //actualizar producto
        productoRepository.save(producto);
    }
    //delete
    public void eliminarProducto (int id) {
        //eliminar producto
        productoRepository.deleteById(id);
    }

    //busquedas de productos por filtros
    public List<Producto> buscarPorNombre (String nombre) {
        //buscar por nombre
        return productoRepository.findByNombre(nombre);
    }

    public List<Producto> buscarPorPrecio (double precio) {
        //buscar por precio
        return productoRepository.findByPrecio(precio);
    }

    public List<Producto> buscarPorMenorPrecio(double precio) {
        //buscar por menor precio
        return productoRepository.findByPrecioLessThanEqual(precio);
    }
    
    public List<Producto> buscarPorMayorPrecio(double precio) {
        //buscar por mayor precio
        return productoRepository.findByPrecioGreaterThanEqual(precio);
    }
    //contiene o empieza con
    public List<Producto> buscarPorNombreContiene (String nombre) {
        //buscar por nombre que contiene o empieza con
        return productoRepository.findByNombreContainingOrNombreStartingWith(nombre, nombre);
    }    
}
