package com.example.actividadandroid;

public class Aviso {

    public String id_aviso;
    public String nombreProfesor;
    public String avisoProfesor;


    public Aviso(){}

    public Aviso(String id_aviso, String nombreProfesor, String avisoProfesor) {
        this.id_aviso = id_aviso;
        this.nombreProfesor = nombreProfesor;
        this.avisoProfesor = avisoProfesor;
    }

    public String getId_aviso() {
        return id_aviso;
    }

    public void setId_aviso(String id_aviso) {
        this.id_aviso = id_aviso;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getAvisoProfesor() {
        return avisoProfesor;
    }

    public void setAvisoProfesor(String avisoProfesor) {
        this.avisoProfesor = avisoProfesor;
    }
}
