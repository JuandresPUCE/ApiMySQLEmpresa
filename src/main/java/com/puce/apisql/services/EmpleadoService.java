package com.puce.apisql.services;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puce.apisql.models.Empleado;
import com.puce.apisql.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    //select 
    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    public Empleado obtenerEmpleadoPorId(int id) {
        return empleadoRepository.findById(id).orElseThrow();
    }

    public List<Empleado> buscarPorNombre(String nombre) {
        return empleadoRepository.findByNombre(nombre);
    }

    public List<Empleado> buscarPorApellido(String apellido){
        return empleadoRepository.findByApellido(apellido);
    }

    public List<Empleado> buscarPorCorreo(String correo){
        return empleadoRepository.findByCorreo(correo);
    }

    public List<Empleado> buscarPorEdad(int edad){
        return empleadoRepository.findByEdad(edad);
    }


    //insert
    public void guardarEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    //update
    public void actualizarEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    //delete
    public void eliminarEmpleado(int id) {
        empleadoRepository.deleteById(id);
    }

    //select where
    public List<Empleado> buscarPorNombreOApellido(String nombre) {
        return empleadoRepository.findByNombreContainingOrApellidoStartingWith(nombre, nombre);
    }

    //select where sueldo 
    public List<Empleado> buscarPorSueldo(double sueldo) {
        return empleadoRepository.findBySueldo(sueldo);
    }
    //select where sueldo menor
    public List<Empleado> buscarPorSueldoMenor(double sueldo){
        return empleadoRepository.findBySueldoLessThanEqual(sueldo);
    }

    public List<Empleado> buscarPorSueldoMayor(double sueldo){
        return empleadoRepository.findBySueldoLessThanEqual(sueldo);
    }
    //edad
    public List<Empleado> buscarPorEdadMayor(int edad){
        return empleadoRepository.findByEdadGreaterThanEqual(edad);
    }

    
}
