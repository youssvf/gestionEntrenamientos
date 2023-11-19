package com.example.gestionEntrenamientos.Entrenamientos.api;

import com.example.gestionEntrenamientos.Entrenamientos.application.EntrenamientosUseCases;
import com.example.gestionEntrenamientos.Entrenamientos.domain.Entrenamiento;
import com.example.gestionEntrenamientos.Entrenamientos.infrastructure.EntrenamientosRepositorySQL;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntrenamientosRestController {
    private EntrenamientosUseCases entrenamientosUseCases;

    public EntrenamientosRestController(){
        this.entrenamientosUseCases = new EntrenamientosUseCases(new EntrenamientosRepositorySQL());
    }

    @GetMapping("/entrenamientos")
    public List<Entrenamiento> getAll(){
        return this.entrenamientosUseCases.getAll();
    }

    @GetMapping("/entrenamientos/{id}")
    public Entrenamiento getEntrenamiento(@PathVariable Integer id){
        return this.entrenamientosUseCases.getEntrenamiento(id);
    }
}
