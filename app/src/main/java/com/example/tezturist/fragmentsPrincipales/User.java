package com.example.tezturist.fragmentsPrincipales;
//clase usada para fragmento tres, quien almacena informacino del usuario
public class User {
    private String firstName;
    private String lastName;
    private String middleName;
    private String imageUrl; // Nuevo campo para la URL de la imagen


    // Constructor vacío requerido por Firebase
    public User() {
    }

    public User(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
