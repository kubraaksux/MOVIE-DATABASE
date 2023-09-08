package com.example.cmpe321_hw3.repository;
import com.example.cmpe321_hw3.data.Movie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MovieRepository {
    private Connection connection;

    public MovieRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Movie> getAllMovies() throws SQLException {
        List<Movie> movies = new ArrayList<>();
        String query = "SELECT * FROM Movie";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getString("movieId"),
                        resultSet.getString("movieName"),
                        resultSet.getInt("duration")
                );
                movies.add(movie);
            }
        }
        return movies;
    }

}

