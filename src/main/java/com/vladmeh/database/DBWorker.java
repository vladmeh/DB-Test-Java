package com.vladmeh.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @autor mvl on 10.10.2017.
 */
public class DBWorker {
    private final static String URL =
            "jdbc:mysql://localhost:3306/test";
    private final static String URLFIXED =
            "jdbc:mysql://localhost:3306/test?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
                    "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final static String USERNAME = "admin";
    private final static String PASSWORD = "admin";

    private Connection connection;

    public DBWorker() {
        try {
            connection = DriverManager.getConnection(URLFIXED, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
