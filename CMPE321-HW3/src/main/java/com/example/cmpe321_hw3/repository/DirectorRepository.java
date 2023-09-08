package com.example.cmpe321_hw3.repository;

import com.example.cmpe321_hw3.data.Director;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DirectorRepository {
    private Connection connection;

    public DirectorRepository(Connection connection) {
        this.connection = connection;
    }

    public Director getDirectorByUsername(String username) throws SQLException {
        String query = "SELECT * FROM Director WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Director director = new Director(
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            resultSet.getString("name"),
                            resultSet.getString("surname"),
                            resultSet.getString("nation"),
                            resultSet.getString("platformId")
                    );
                    return director;
                }
            }
        }
        return null;
    }

}

