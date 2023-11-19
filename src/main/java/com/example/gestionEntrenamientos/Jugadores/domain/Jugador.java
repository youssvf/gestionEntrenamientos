package com.example.gestionEntrenamientos.Jugadores.domain;

public class Jugador {
    private String dni, nombre, apellidos, fechanac;
    private Integer resistencia, recuperacion, velocidad;

    public Jugador(String dni, String nombre, String apellidos, String fechanac, Integer resistencia, Integer recuperacion, Integer velocidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechanac = fechanac;
        this.resistencia = resistencia;
        this.recuperacion = recuperacion;
        this.velocidad = velocidad;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechanac() {
        return fechanac;
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
}
