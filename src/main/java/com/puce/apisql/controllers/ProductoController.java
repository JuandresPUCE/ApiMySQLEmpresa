package com.puce.apisql.controllers;
// es el 4to el controlador
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//importar el modelo y el servicio
import com.puce.apisql.models.Producto;
import com.puce.apisql.services.ProductoService;

    //rutas
    @RestController
    @RequestMapping("/api")

public class ProductoController {
    //inyectar el servicio    
    @Autowired
    //llamado del objeto
    private ProductoService productoService;

    //selects
    @GetMapping("/productos")
    public List<Producto> listarProductos() {
        //retornar todos los productos
        return productoService.listarProductos();
    }
    //producto por id
    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable int id) {
        //buscar producto por id
        try{
            Producto producto = productoService.obtenerProductoPorId(id);
            return new ResponseEntity<Producto>(producto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //insert por body
    //metodo post
    @PostMapping("/productos")
    public Producto guardarProducto(@RequestBody Producto producto) {
        //guardar producto
        productoService.guardarProducto(producto);
        return producto;
    }

    //borrar por id

    @DeleteMapping("/productos/{id}")
    public Producto eliminarProducto(@PathVariable int id) {
        //eliminar producto
        Producto producto = productoService.obtenerProductoPorId(id);
        if (producto == null) {
            throw new RuntimeException("Producto no encontrado -"+id);
        }
        productoService.eliminarProducto(id);
        return producto;
    }
    //version simple borrar 
    /*
     * @DeleteMapping("/productos/{id}") 
     * public void eliminarProducto(@PathVariable int id) { 
     * Producto producto = productoService.obtenerProductoPorId(id);
     * productoService.eliminarProducto(id);
     * }
     */
    // actualizar por id
    // metodo put
     @PutMapping("/productos/{id}")
     public Producto actualizaProducto(@RequestBody Producto producto, @PathVariable int id) {
         //actualizar producto
         productoService.actualizarProducto(producto);
         Producto productoExistente = productoService.obtenerProductoPorId(id);
         return productoExistente;
     }
     //Select por filtros
    //buscar por nombre
    @GetMapping("/productos/buscar/nombre/{nombre}")
    public List<Producto> buscarPorNombre(@PathVariable String nombre) {
        //buscar por nombre
        return productoService.buscarPorNombre(nombre);
    }
    //buscar por precio
     @GetMapping("/productos/buscar/precio/{precio}")
        public List<Producto> buscarPorPrecio(@PathVariable double precio) {
            //buscar por precio
            return productoService.buscarPorPrecio(precio);
        }
    
    //buscar por menor precio
    @GetMapping("/productos/buscar/menorprecio/{precio}")
    public List<Producto> buscarPorMenorPrecio(@PathVariable double precio) {
        //buscar por menor precio
        return productoService.buscarPorMenorPrecio(precio);
    }
    //buscar por mayor precio
    @GetMapping("/productos/buscar/mayorprecio/{precio}")
    public List<Producto> buscarPorMayorPrecio(@PathVariable double precio) {
        //buscar por mayor precio
        return productoService.buscarPorMayorPrecio(precio);
    }
    
    //contiene o comienza con
    @GetMapping("/productos/buscar/nombrecontiene/{nombre}")
    public List<Producto> buscarPorNombreContiene(@PathVariable String nombre) {
        //buscar por nombre que contiene o empieza con
        return productoService.buscarPorNombreContiene(nombre);
    }








}
