package org.example;

import java.sql.*;

public class JDBC_test {
    private static final String url = "jdbc:mysql://localhost:3306/entries";
    private static final String user = "root";
    private static final String password = "12345678";

    private static Connection connection = null;
    public JDBC_test() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String tableName = resultSet.getString("word");
                System.out.println("Bảng: " + tableName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(statement, resultSet);
        }
    }

    private void closeResources() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeResources(Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String query = "select * from entries";
        JDBC_test test = new JDBC_test();
        test.executeQuery(query);
    }
}
