package com.hillel.lesson24.hw17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static SingletonConnection instance;
    private Connection connection;
    private final String name = "postgres";
    private final String password = "postgres";

    private SingletonConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Hillel", name, password);
        } catch (SQLException e) {
            System.err.println("Cannot connect to database");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static SingletonConnection getInstance() {
        if (instance == null) {
            instance = new SingletonConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

}
