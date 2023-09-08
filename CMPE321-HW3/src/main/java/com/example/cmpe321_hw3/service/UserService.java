package com.example.cmpe321_hw3.service;

import com.example.cmpe321_hw3.data.User;
import com.example.cmpe321_hw3.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User getUserByUsername(String username) {
        try {
            return userRepository.getUserByUsername(username);
        } catch (SQLException e) {
            // Handle the exception, e.g., log the error
            e.printStackTrace();
            return null; // or throw a custom exception
        }
    }

    public void addUser(User user) throws UserServiceException {
        try {
            userRepository.addUser(user);
        } catch (SQLException e) {
            throw new UserServiceException("Error adding user", e);
        }
    }


    public void updateUser(User user) throws UserServiceException {
        try {
            userRepository.updateUser(user);
        } catch (Exception e) {
            throw new UserServiceException("Error updating user", e);
        }
    }

    public void deleteUser(String username) throws UserServiceException {
        try {
            userRepository.deleteUser(username);
        } catch (SQLException e) {
            throw new UserServiceException("Error deleting user", e);
        }
    }
}

