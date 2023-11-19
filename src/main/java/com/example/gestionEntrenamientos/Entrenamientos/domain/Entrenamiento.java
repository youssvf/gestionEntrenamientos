package com.example.gestionEntrenamientos.Entrenamientos.domain;

import com.example.gestionEntrenamientos.Ejercicios.domain.Ejercicio;
import com.example.gestionEntrenamientos.Jugadores.domain.Jugador;

import java.util.ArrayList;
import java.util.List;

public class Entrenamiento {
    private Integer id;
    private String fecha;
    private List<Ejercicio> ejercicios;
    private List<Jugador> asistentes;

    public Entrenamiento(Integer id, String fecha) {
        this.id = id;
        this.fecha = fecha;
        this.ejercicios = new ArrayList<>();
        this.asistentes = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public List<Jugador> getAsistentes() {
        return asistentes;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public void setAsistentes(List<Jugador> asistentes) {
        this.asistentes = asistentes;
    }
}
