package com.example.gestionEntrenamientos.Entrenamientos.domain;

import com.example.gestionEntrenamientos.Jugadores.domain.Jugador;

import java.util.List;

public interface EntrenamientosRepository {
    public List<Entrenamiento> getAll();
    public Entrenamiento getEntrenamiento(Integer id);
    public Entrenamiento save(Entrenamiento entrenamiento);
    public Entrenamiento saveAsistentes(Integer id, List<Jugador> jugadores);
    public Entrenamiento delete(Integer id);
}
