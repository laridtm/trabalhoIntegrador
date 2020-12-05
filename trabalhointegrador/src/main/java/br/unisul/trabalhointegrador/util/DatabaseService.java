package br.unisul.trabalhointegrador.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {

    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc: postgresql: // localhost: 5432/database", "transportadora",
                    "database");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
        return conn;
    }

}
