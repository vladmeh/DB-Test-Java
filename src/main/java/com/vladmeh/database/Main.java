package com.vladmeh.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @autor mvl on 10.10.2017.
 */
public class Main {
    public static void main(String[] args) {
        DBWorker worker = new DBWorker();

        String query = "select * from users";

        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
