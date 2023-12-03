package com.example.tezturist.atoluca.fragmentsBotones.firebaseActividades;

import java.util.Map;

public class MainModelAtolucaActividades {
    String descripcion, imagen, nombre;


    // Constructor por defecto
    MainModelAtolucaActividades() {
    }

    public MainModelAtolucaActividades(String descripcion, String imagen, String nombre) {
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.nombre = nombre;
        ;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}

