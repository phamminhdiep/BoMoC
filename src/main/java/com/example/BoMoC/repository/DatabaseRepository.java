package com.example.BoMoC.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseRepository {
    private String JDBC_DRIVER;
    private String DB_URL;
    private String USER;
    private String PASS;
    private Connection connection;

    public DatabaseRepository() {
        JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        DB_URL = "jdbc:mysql://localhost:3306/bomoc";
        USER = "root";
        PASS = "06032002";
        connection = null;
    }

    public Connection connect() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(getJDBC_DRIVER());
            connection = DriverManager.getConnection(getDB_URL(), getUSER(), getPASS());
            System.out.println("Connect Database Mysql Successfully");
            System.out.println("hello");
            return connection;
        } catch (Exception e) {
            return (Connection) e;
        }
    }

    public String getJDBC_DRIVER() {
        return JDBC_DRIVER;
    }

    public String getDB_URL() {
        return DB_URL;
    }

    public String getUSER() {
        return USER;
    }

    public String getPASS() {
        return PASS;
    }
}
