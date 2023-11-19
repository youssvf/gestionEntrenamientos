package com.example.gestionEntrenamientos.tests;

import com.example.gestionEntrenamientos.Entrenamientos.application.EntrenamientosUseCases;
import com.example.gestionEntrenamientos.Entrenamientos.domain.Entrenamiento;
import com.example.gestionEntrenamientos.Entrenamientos.infrastructure.EntrenamientosRepositorySQL;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntrenamientosUseCasesTests {
    private EntrenamientosUseCases entrenamientosUseCases;

    public EntrenamientosUseCasesTests(){
        this.entrenamientosUseCases = new EntrenamientosUseCases(new EntrenamientosRepositorySQL());
    }

    @Test
    void getAll(){
        List<Entrenamiento> entrenamientos = entrenamientosUseCases.getAll();
        assertEquals(3,entrenamientos.size());
    }
}
