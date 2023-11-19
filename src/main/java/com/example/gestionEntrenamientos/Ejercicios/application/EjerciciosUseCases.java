package com.example.gestionEntrenamientos.Ejercicios.application;

import com.example.gestionEntrenamientos.Ejercicios.domain.Ejercicio;
import com.example.gestionEntrenamientos.Ejercicios.domain.EjerciciosRepository;

import java.util.List;

public class EjerciciosUseCases {
    private EjerciciosRepository ejerciciosRepository;

    public EjerciciosUseCases(EjerciciosRepository ejerciciosRepository){
        this.ejerciciosRepository = ejerciciosRepository;
    }

    public List<Ejercicio> getAll(){
        return this.ejerciciosRepository.getAll();
    }

    public Ejercicio getEjercicio(Integer id){
        return this.ejerciciosRepository.getEjercicio(id);
    }

    public Ejercicio save(Ejercicio ejercicio){
        return this.ejerciciosRepository.save(ejercicio);
    }
}
