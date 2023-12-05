package com.example.tezturist.atoluca.fragmentsBotones.firebaseHistoria;

public class MainModelAtolucaHistoria {

    String descripcionH;
    String imagenH;
    String nombreH;
    MainModelAtolucaHistoria() {
    }
    public MainModelAtolucaHistoria(String descripcionH, String imagenH, String nombreH) {
        this.descripcionH = descripcionH;
        this.imagenH = imagenH;
        this.nombreH = nombreH;
    }

    public String getDescripcionH() {
        return descripcionH;
    }

    public void setDescripcionH(String descripcionH) {
        this.descripcionH = descripcionH;
    }

    public String getImagenH() {
        return imagenH;
    }

    public void setImagenH(String imagenH) {
        this.imagenH = imagenH;
    }

    public String getNombreH() {
        return nombreH;
    }

    public void setNombreH(String nombreH) {
        this.nombreH = nombreH;
    }
}
