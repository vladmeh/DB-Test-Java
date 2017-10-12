package com.vladmeh.database;


import java.sql.*;

public class MainAnimals {

    public static void main(String[] args) {
        DBWorker worker = new DBWorker();

        try (
                Connection connection = worker.getConnection();
                Statement statement = connection.createStatement();
        ) {

            //statement.execute("INSERT INTO animal(animal_name, animal_desc) VALUES ('name', 'desc');");
            //int res = statement.executeUpdate("UPDATE animal SET animal_name='new Name' WHERE id=1;");

            statement.addBatch("INSERT INTO animal(animal_name, animal_desc) VALUES ('batch1', 'desc');");
            statement.addBatch("INSERT INTO animal(animal_name, animal_desc) VALUES ('batch2', 'desc');");
            statement.addBatch("INSERT INTO animal(animal_name, animal_desc) VALUES ('batch3', 'desc');");

            statement.executeBatch();
            statement.clearBatch();

            boolean status = statement.isClosed();
            System.out.println(status);

            statement.getConnection();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
