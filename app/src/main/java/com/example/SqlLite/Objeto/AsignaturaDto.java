package com.example.SqlLite.Objeto;

public class AsignaturaDto {
    private String nombre ="";
    private float ratingBar = 0;
    private int id_asignatura = 0;
    public AsignaturaDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getRatingBar() {
        return ratingBar;
    }

    public void setRatingBar(float ratingBar) {
        this.ratingBar = ratingBar;
    }

    public int getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(int id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public AsignaturaDto(String nombre, float ratingBar, int id_asignatura) {
        this.nombre = nombre;
        this.ratingBar = ratingBar;
        this.id_asignatura = id_asignatura;
    }
}
