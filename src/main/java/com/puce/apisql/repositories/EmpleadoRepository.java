package com.puce.apisql.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.puce.apisql.models.Empleado;


public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{

    List<Empleado> findByNombre(String nombre);
    List<Empleado> findByApellido(String apellido);
    List<Empleado> findByCorreo(String correo);
    List<Empleado> findByEdad(int edad);
    List<Empleado> findBySueldo(double sueldo);
    List<Empleado> findByNombreContainingOrApellidoStartingWith(String nombre, String apellido);
    List<Empleado> findBySueldoLessThanEqual(double sueldo);
    List<Empleado> findBySueldoGreaterThanEqual(double sueldo);
    List<Empleado> findByEdadGreaterThanEqual(int edad);

}
