package com.example.cmpe321_hw3.repository;

import com.example.cmpe321_hw3.data.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManagerRepository {
    private Connection connection;

    public DatabaseManagerRepository(Connection connection) {
        this.connection = connection;
    }

    public DatabaseManager getDatabaseManagerByUsername(String username) throws SQLException {
        String query = "SELECT * FROM DatabaseManager WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String dbmUsername = resultSet.getString("username");
                    String dbmPassword = resultSet.getString("password");
                    return new DatabaseManager(dbmUsername, dbmPassword);
                }
            }
        }
        return null;
    }

}
