package com.example.myescuela01.entidad;

public class Estudiante {

    public Estudiante(){

    }

    public Estudiante(Integer id, String nombre, String matricula){
        this.id = id;
        this.nombre = nombre;
        this.matricula = matricula;
    }

    private Integer id;
    private String nombre;
    private String matricula;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}
