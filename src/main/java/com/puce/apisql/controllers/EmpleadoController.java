package com.puce.apisql.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.puce.apisql.models.Empleado;
import com.puce.apisql.services.EmpleadoService;

@RestController
@RequestMapping("/api")

public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    //selects
    @RequestMapping("/empleados")
    public List<Empleado> listarEmpleados() {
        //retornar todos los empleados
        return empleadoService.listarEmpleados();
    }
    @RequestMapping("/empleados/buscar/nombreapellido/{nombre}")
    public List<Empleado> buscarPorNombreOApellido(@PathVariable String nombre){
        return empleadoService.buscarPorNombreOApellido(nombre);
    }

    @RequestMapping("/empleados/buscar/sueldo/{sueldo}")
    public List<Empleado> buscarPorSueldo(@PathVariable double sueldo){
        return empleadoService.buscarPorSueldo(sueldo);
    }

    @RequestMapping("/empleados/buscar/mayoredad/{edad}")
    public List<Empleado> buscarPorEdadMayor(@PathVariable int edad){
        return empleadoService.buscarPorEdadMayor(edad);
    }


    //insert post body
    @PostMapping("/empleados")
    public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
        //guardar empleado
        empleadoService.guardarEmpleado(empleado);
        return empleado;
    }

    //update by id put
    @PutMapping("/empleados/{id}")
    public Empleado actualizarEmpleado(@RequestBody Empleado empleado, @PathVariable int id) {
        //actualizar empleado
        
        empleadoService.actualizarEmpleado(empleado);
        Empleado empleadoExistente = empleadoService.obtenerEmpleadoPorId(id);
        return empleadoExistente;
    }

    //delete by id delete
    @DeleteMapping("/empleados/{id}")
    public Empleado borrarEmpleado(@PathVariable int id) {
        //borrar empleado
        Empleado empleado = empleadoService.obtenerEmpleadoPorId(id);
        if (empleado == null) {
            throw new RuntimeException("Empleado no encontrado -"+id);
        }
        empleadoService.eliminarEmpleado(id);
        return empleado;
    }



    
}
