package com.example.proyectoapi;

public class Juegos {

    private String Nombre;
    private String Rating;
    private String Imagen;

    public Juegos() {
    }

    public Juegos(String nombre, String rating, String imagen) {
        Nombre = nombre;
        Rating = rating;
        Imagen = imagen;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getRating() {
        return Rating;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }
}
