package com.example.gestionEntrenamientos.Entrenamientos.infrastructure;

import com.example.gestionEntrenamientos.Ejercicios.domain.Ejercicio;
import com.example.gestionEntrenamientos.Entrenamientos.domain.Entrenamiento;
import com.example.gestionEntrenamientos.Entrenamientos.domain.EntrenamientosRepository;
import com.example.gestionEntrenamientos.Jugadores.domain.Jugador;
import com.example.gestionEntrenamientos.data.DBConecction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EntrenamientosRepositorySQL implements EntrenamientosRepository {

    @Override
    public List<Entrenamiento> getAll() {
        List<Entrenamiento> entrenamientos = new ArrayList<>();
        try {
            Statement statement = DBConecction.getInstance().createStatement();
            ResultSet rs = statement.executeQuery("select * from entrenamientos");
            while (rs.next()){
                entrenamientos.add(new Entrenamiento(rs.getInt("id"),rs.getString("fecha")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return entrenamientos;
    }

    @Override
    public Entrenamiento getEntrenamiento(Integer id) {
        Entrenamiento entrenamiento = null;
        List<Ejercicio> ejercicios = new ArrayList<>();
        List<Jugador>   jugadores = new ArrayList<>();
        String sql = "SELECT entrenamientos.id as id_entrenamiento, entrenamientos.fecha, ej.*, ju.nombre\n" +
                "FROM entrenamientos WHERE entrenamientos.id = ? \n" +
                "LEFT JOIN entrenamientos_ejercicios ee  on ee.id_entrenamiento = entrenamientos.id\n" +
                "LEFT JOIN ejercicios ej on ej.id = ee.id_ejercicio\n" +
                "LEFT JOIN asistentes aa on aa.id_entrenamiento = entrenamientos.id\n" +
                "LEFT JOIN jugadores ju on ju.dni = aa.id_jugador;";
        try {
            PreparedStatement statement = DBConecction.getInstance().prepareStatement("select entrenamientos.id as id_entrenamiento, entrenamiento.fecha, ej.*, ju.nombre " +
                    "from entrenamientos " +
                    "where entrenamientos.id = ? " +
                    "left join entrenamientos_ejercicios ee on ee.id_entrenamiento = entrenamiento.id " +
                    "left join ejercicios ej on ej.id = ee.id_ejercicio " +
                    "left join asistentes aa on aa.id_entrenamiento = entrenamientos.id " +
                    "left join jugadores ju on ju.dni = aa.id_jugaodor ;");
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                entrenamiento = new Entrenamiento(rs.getInt("id_entrenamiento"),rs.getString("fecha"));
                ejercicios.add(new Ejercicio(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getInt("resistencia"),
                        rs.getInt("recuperacion"),
                        rs.getInt("velocidad")
                ));
                entrenamiento.setEjercicios(ejercicios);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }


        return entrenamiento;
    }

    @Override
    public Entrenamiento save(Entrenamiento entrenamiento) {
        return null;
    }

    @Override
    public Entrenamiento saveAsistentes(Integer id, List<Jugador> jugadores) {
        return null;
    }

    @Override
    public Entrenamiento delete(Integer id) {
        return null;
    }
}
