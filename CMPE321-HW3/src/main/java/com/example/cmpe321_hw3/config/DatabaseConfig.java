package com.example.cmpe321_hw3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DatabaseConfig {

    @Bean
    public Connection connection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proj1", "root", "root");
        return connection;
    }

}
