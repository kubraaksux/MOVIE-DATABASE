package com.example.cmpe321_hw3.repository;

import com.example.cmpe321_hw3.data.MyUserDetails;
import com.example.cmpe321_hw3.data.Rating;
import com.example.cmpe321_hw3.data.User;
import com.example.cmpe321_hw3.service.UserServiceException;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    public User getUserByUsername(String username) throws SQLException {
        String query = "SELECT * FROM User WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new User(
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            resultSet.getString("name"),
                            resultSet.getString("surname")
                    );
                }
            }
        }
        return null;
    }

    public MyUserDetails loadUserByUsername(String username) throws SQLException {
        User user = getUserByUsername(username);
        if (user != null) {
            // Load user role from the database or any other logic
            String role = getUserRoleByUsername(username);
            return new MyUserDetails(
                    user.getUsername(),
                    user.getPassword(),
                    role
            );
        }
        return null;
    }

    private String getUserRoleByUsername(String username) throws SQLException {
        String query = "SELECT role FROM UserRole WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("role");
                }
            }
        }
        return null;
    }


    public List<Rating> getRatingsByUser(String username) throws SQLException {
        List<Rating> ratings = new ArrayList<>();
        String query = "SELECT * FROM Rating WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Rating rating = new Rating(
                            resultSet.getString("username"),
                            resultSet.getString("movieId"),
                            resultSet.getDouble("rating")
                    );
                    ratings.add(rating);
                }
            }
        }
        return ratings;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM User";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getString("surname")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
        return users;
    }

    public void addUser(User user) throws SQLException {
        String query = "INSERT INTO User (username, password, name, surname) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getSurname());
            statement.executeUpdate();
        }
    }


    public void updateUser(User user) throws SQLException {
        String query = "UPDATE User SET password = ?, name = ?, surname = ? WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getPassword());
            statement.setString(2, user.getName());
            statement.setString(3, user.getSurname());
            statement.setString(4, user.getUsername());
            statement.executeUpdate();
        }
    }

    public void deleteUser(String username) throws SQLException {
        String query = "DELETE FROM User WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.executeUpdate();
        }
    }

}

