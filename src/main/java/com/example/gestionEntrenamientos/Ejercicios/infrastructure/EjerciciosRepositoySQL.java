package com.example.gestionEntrenamientos.Ejercicios.infrastructure;

import com.example.gestionEntrenamientos.Ejercicios.domain.Ejercicio;
import com.example.gestionEntrenamientos.Ejercicios.domain.EjerciciosRepository;
import com.example.gestionEntrenamientos.data.DBConecction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EjerciciosRepositoySQL implements EjerciciosRepository {

    @Override
    public List<Ejercicio> getAll() {
        List<Ejercicio> ejercicios = new ArrayList<>();
        Statement statement = null;
        try {
            statement = DBConecction.getInstance().createStatement();
            ResultSet rs = statement.executeQuery("select * from ejercicios;");
             while (rs.next()){
                 String titulo = rs.getString("titulo");
                 Integer id = rs.getInt("id");
                 Integer resistencia = rs.getInt("resistencia");
                 Integer recuperacion = rs.getInt("recuperacion");
                 Integer velocidad = rs.getInt("velocidad");

                 ejercicios.add(new Ejercicio(id,titulo,resistencia,recuperacion,velocidad));
             }

        } catch (SQLException e) {
            System.err.println(e.getMessage());;
        }

        return ejercicios;
    }

    @Override
    public Ejercicio getEjercicio(Integer id) {
        Ejercicio ejercicio = null;
        try {
            PreparedStatement preparedStatement = DBConecction.getInstance().prepareStatement("select * from ejercicios where id = ?");
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                ejercicio = new Ejercicio(
                rs.getInt("id"), rs.getString("titulo"),
                rs.getInt("resistencia"),
                rs.getInt("recuperacion"),
                rs.getInt("velocidad")
                );
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return ejercicio;
    }

    @Override
    public Ejercicio save(Ejercicio ejercicio) {
        try {
            PreparedStatement preparedStatement = DBConecction.getInstance().prepareStatement("insert into ejercicios values(?,?,?,?,?)");
            preparedStatement.setInt(1,ejercicio.getId());
            preparedStatement.setString(2,ejercicio.getTitulo());
            preparedStatement.setInt(3,ejercicio.getResistencia());
            preparedStatement.setInt(4,ejercicio.getRecuperacion());
            preparedStatement.setInt(5, ejercicio.getVelocidad());

            preparedStatement.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return ejercicio;
    }
}
