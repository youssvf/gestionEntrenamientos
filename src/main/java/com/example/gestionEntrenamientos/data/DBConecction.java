package com.example.gestionEntrenamientos.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConecction {
    private static Connection connection;

    private DBConecction(){}

    public static Connection getInstance(){
        if (connection == null){
            try {
                connection = DriverManager.getConnection("jdbc:mysql://database-1.cabn5upwsapr.us-east-1.rds.amazonaws.com/gestionEntrenamientos","admin","admin1234");
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return connection;
    }
}
