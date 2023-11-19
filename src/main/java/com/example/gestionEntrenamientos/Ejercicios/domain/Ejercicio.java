package com.example.gestionEntrenamientos.Ejercicios.domain;

public class Ejercicio {
    private Integer id, resistencia, recuperacion, velocidad;
    private String titulo;

    public Ejercicio(Integer id,String titulo , Integer resistencia, Integer recuperacion, Integer velocidad) {
        this.id = id;
        this.resistencia = resistencia;
        this.recuperacion = recuperacion;
        this.velocidad = velocidad;
        this.titulo = titulo;
    }

    public Integer getId() {
        return id;
    }

    public Integer getResistencia() {
        return resistencia;
    }

    public Integer getRecuperacion() {
        return recuperacion;
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public String getTitulo() {
        return titulo;
    }
}
