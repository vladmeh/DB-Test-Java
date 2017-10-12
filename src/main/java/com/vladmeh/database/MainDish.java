package com.vladmeh.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Calendar;

/**
 * @autor mvl on 12.10.2017.
 */
public class MainDish {

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        DBWorker worker = new DBWorker();
        Connection connection = worker.getConnection();

        createDish(connection);
        getDish(connection);
        deleteDish(connection);

        connection.close();
    }

    public static void createDish(Connection connection) throws SQLException, FileNotFoundException {
        String query = "INSERT INTO dish VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1,1);
        preparedStatement.setString(2, "title");
        preparedStatement.setString(3, "desc");
        preparedStatement.setFloat(4, 0.2f);
        preparedStatement.setBoolean(5, true);
        preparedStatement.setDate(6, new Date(Calendar.getInstance().getTimeInMillis()));
        preparedStatement.setBlob(7, new FileInputStream("zf-logo.png"));

        preparedStatement.execute();

        preparedStatement.close();

        System.out.println("Новая запись создана");
    }

    public static void getDish(Connection connection) throws SQLException{
        String query = "SELECT * FROM dish";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        ResultSet res = preparedStatement.executeQuery();

        while (res.next()){
            int id = res.getInt("id");
            String title = res.getString("title");
            String desc = res.getString("description");
            double rating = res.getDouble("rating");
            boolean publoshed = res.getBoolean("published");
            Date date = res.getDate("created");
            byte[] icon = res.getBytes("icon");

            System.out.printf("id: %d, title: %s, desc: %s, rating: %.2f, published: %b, date: %tD, icon length: %d %n",
                    id, title, desc, rating, publoshed, date, icon.length);
        }

        preparedStatement.close();
    }

    public static void deleteDish(Connection connection) throws SQLException{
        String query = "DELETE FROM dish WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1,2);
        preparedStatement.executeUpdate();

        System.out.println("Запись удалена");

        preparedStatement.close();
    }
}
