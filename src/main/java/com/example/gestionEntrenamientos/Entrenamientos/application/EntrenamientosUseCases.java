package com.example.gestionEntrenamientos.Entrenamientos.application;

import com.example.gestionEntrenamientos.Ejercicios.domain.EjerciciosRepository;
import com.example.gestionEntrenamientos.Entrenamientos.domain.Entrenamiento;
import com.example.gestionEntrenamientos.Entrenamientos.domain.EntrenamientosRepository;
import com.example.gestionEntrenamientos.Jugadores.domain.Jugador;

import java.util.List;

public class EntrenamientosUseCases {
    private EntrenamientosRepository entrenamientosRepository;

    public EntrenamientosUseCases(EntrenamientosRepository entrenamientosRepository){
        this.entrenamientosRepository = entrenamientosRepository;
    }

    public List<Entrenamiento> getAll(){
        return this.entrenamientosRepository.getAll();
    }

    public Entrenamiento getEntrenamiento(Integer id){
        return this.entrenamientosRepository.getEntrenamiento(id);
    }

    public Entrenamiento save(Entrenamiento entrenamiento){
        return this.entrenamientosRepository.save(entrenamiento);
    }

    public Entrenamiento saveAsistentes(Integer id, List<Jugador> jugadores){
        return this.entrenamientosRepository.saveAsistentes(id,jugadores);
    }

    public Entrenamiento delete(Integer id){
        return this.entrenamientosRepository.delete(id);
    }
}
