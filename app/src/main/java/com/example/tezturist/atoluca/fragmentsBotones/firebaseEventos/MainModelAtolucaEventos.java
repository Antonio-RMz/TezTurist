package com.example.tezturist.atoluca.fragmentsBotones.firebaseEventos;

public class MainModelAtolucaEventos {
    String descripcionE;
    String imagenE;
    String nombreE;

    MainModelAtolucaEventos() {
    }

    public MainModelAtolucaEventos(String descripcionE, String imagenE, String nombreE) {
        this.descripcionE = descripcionE;
        this.imagenE = imagenE;
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getImagenE() {
        return imagenE;
    }

    public void setImagenE(String imagenE) {
        this.imagenE = imagenE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }
}
