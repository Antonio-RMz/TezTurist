package com.example.tezturist;

public class MainModelTres {
    String descripcion, imagen, nombre;
MainModelTres(){


}
    public MainModelTres(String descripcion, String imagen, String nombre) {
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.nombre = nombre;
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
