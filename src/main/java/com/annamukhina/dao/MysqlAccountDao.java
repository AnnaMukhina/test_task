package com.annamukhina.dao;

import com.annamukhina.service.Account;

import java.sql.*;

/**
 * @author anna_mukhina
 */
public class MysqlAccountDao implements Dao {
    private final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/accounts";
    private final String DB_USER = "user";
    private final String DB_PASSWORD = "password";

    @Override
    public void changeSurname(Account account) {
        if(checkAccountExistence(account)) {
            updateAccount(account);
        }
        else {
            System.out.println("Account doesn't exist.");
        }
    }

    public boolean checkAccountExistence(Account account) {
        try {
            Class.forName(DB_DRIVER);

            Connection connection = DriverManager.getConnection(DB_URL,DB_USER, DB_PASSWORD);

            try {
                if(connection != null) {
                    PreparedStatement preparedStatement = connection.prepareStatement(
                            "SELECT * FROM accounts WHERE id = ?");

                    String id = account.getId();

                    preparedStatement.setString(1, id);

                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (!resultSet.wasNull()) {
                        resultSet.close();

                        preparedStatement.close();

                        return true;
                    }
                }
            }
            finally {
                if (connection != null) {
                    connection.close();
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("There is no driver for database connection.");
        } catch (SQLException e) {
            System.out.println("Error during connecting to database. Please try again.");
        }
        return false;
    }

    public void updateAccount(Account account) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL,DB_USER, DB_PASSWORD);

            try {
                if(connection != null) {
                    PreparedStatement preparedStatement = connection.prepareStatement(
                            "UPDATE accounts SET surname = ? WHERE id = ?");

                    String surname = account.getSurname();

                    String id = account.getId();

                    preparedStatement.setString(1, surname);

                    preparedStatement.setString(2, id);

                    preparedStatement.executeUpdate();

                    System.out.println("Account has been updated.");

                    preparedStatement.close();
                }
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }
        } catch (SQLException e) {
            System.out.println("Error during connecting to database. Please try again.");
        }
    }
}
