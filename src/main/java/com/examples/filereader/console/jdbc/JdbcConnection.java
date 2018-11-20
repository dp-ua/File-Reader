package com.examples.filereader.console.jdbc;

import java.sql.*;

public class JdbcConnection {
    private final String JDBC_DRIVER;
    private final String DATABASE_URL;
    private final String USER;
    private final String PASSWORD;

    public JdbcConnection(String JDBC_DRIVER, String DATABASE_URL, String USER, String PASSWORD) {
        this.JDBC_DRIVER = JDBC_DRIVER;
        this.DATABASE_URL = DATABASE_URL;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        return connection;
    }

}
