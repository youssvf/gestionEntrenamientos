package com.example.gestionEntrenamientos.Ejercicios.api;

import com.example.gestionEntrenamientos.Ejercicios.application.EjerciciosUseCases;
import com.example.gestionEntrenamientos.Ejercicios.domain.Ejercicio;
import com.example.gestionEntrenamientos.Ejercicios.infrastructure.EjerciciosRepositoySQL;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EjerciciosRestController {


    private EjerciciosUseCases ejerciciosUseCases;

    public EjerciciosRestController(){
        this.ejerciciosUseCases = new EjerciciosUseCases(new EjerciciosRepositoySQL());
    }

    @GetMapping("/ejercicios")
    public List<Ejercicio> getAll(){
        return this.ejerciciosUseCases.getAll();
    }

    @GetMapping("/ejercicios/{id}")
    public Ejercicio getEjercici(@PathVariable Integer id){
        return this.ejerciciosUseCases.getEjercicio(id);
    }

    @PostMapping("/ejercicios")
    public Ejercicio save(@RequestBody Ejercicio ejercicio){
        return  this.ejerciciosUseCases.save(ejercicio);
    }
}
