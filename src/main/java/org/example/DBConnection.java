package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "0974";

    public static Connection connect() throws Exception {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}