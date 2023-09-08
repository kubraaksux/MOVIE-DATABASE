package com.example.cmpe321_hw3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication(scanBasePackages = "com.example.cmpe321_hw3")
public class Cmpe321Hw3Application {


    public Connection connection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proj1", "root", "root");
        return connection;
    }

    public static void main(String[] args) {
        SpringApplication.run(Cmpe321Hw3Application.class, args);
    }

}
