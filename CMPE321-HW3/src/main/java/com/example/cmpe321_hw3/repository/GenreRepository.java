package com.example.cmpe321_hw3.repository;

import com.example.cmpe321_hw3.data.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreRepository {
    private Connection connection;

    public GenreRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Genre> getAllGenres() throws SQLException {
        List<Genre> genres = new ArrayList<>();
        String query = "SELECT * FROM Genre";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String genreId = resultSet.getString("genreId");
                String genreName = resultSet.getString("genreName");
                Genre genre = new Genre(genreId, genreName);
                genres.add(genre);
            }
        }
        return genres;
    }

}
