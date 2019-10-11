package com.example.myescuela01.repositorio;

import com.example.myescuela01.entidad.Estudiante;

import java.util.List;

public interface EstudianteRepositorio {

    long crear(Estudiante estudiante);
    void actualizar(Estudiante estudiante);
    void borrar(Estudiante estudiante);
    Estudiante buscar(int id);
    List<Estudiante> buscar();

}
