package com.example.gestionEntrenamientos.tests;

import com.example.gestionEntrenamientos.Ejercicios.application.EjerciciosUseCases;
import com.example.gestionEntrenamientos.Ejercicios.domain.Ejercicio;
import com.example.gestionEntrenamientos.Ejercicios.infrastructure.EjerciciosRepositoySQL;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EjerciciosUseCasesTests {
    private EjerciciosUseCases ejerciciosUseCases;

    public EjerciciosUseCasesTests(){
        this.ejerciciosUseCases = new EjerciciosUseCases(new EjerciciosRepositoySQL());
    }

    @Test
    void getAll(){
        List<Ejercicio> ejercicios = ejerciciosUseCases.getAll();
        assertEquals(3,ejercicios.size());
    }

    @Test
    void getEjercicio(){
        Integer id = 1;
        Ejercicio ejercicio = ejerciciosUseCases.getEjercicio(id);
        assertEquals(ejercicio.getId(),id);
    }

    @Test
    void save(){
        Ejercicio ejercicioguardado = new Ejercicio(18,"aa",2,2,2);
        ejerciciosUseCases.save(ejercicioguardado);
        Ejercicio ejercicioobtenido = ejerciciosUseCases.getEjercicio(18);
        assertEquals(ejercicioobtenido.getId(),ejercicioguardado.getId());
    }
}
