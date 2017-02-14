package com.skobeev.dataBase;

import com.skobeev.exceptions.MyException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.skobeev.constants.DBConstants.*;

public class DataBaseWorker {

    public static Connection getConn() throws MyException {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void connClose(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

