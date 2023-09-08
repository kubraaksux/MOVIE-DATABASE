package com.example.cmpe321_hw3.repository;

import com.example.cmpe321_hw3.data.MovieSession;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieSessionRepository {
    private Connection connection;

    public MovieSessionRepository(Connection connection) {
        this.connection = connection;
    }

    public List<MovieSession> getAllMovieSessions() throws SQLException {
        List<MovieSession> movieSessions = new ArrayList<>();
        String query = "SELECT * FROM MovieSession";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                MovieSession movieSession = new MovieSession(
                        resultSet.getString("sessionId"),
                        resultSet.getString("movieId"),
                        resultSet.getString("movieName"),
                        resultSet.getInt("duration"),
                        parseGenreList(resultSet.getString("genreList")),
                        resultSet.getDouble("averageRating"),
                        resultSet.getString("directorUsername"),
                        resultSet.getString("platformId"),
                        parsePredecessors(resultSet.getString("predecessors")),
                        resultSet.getString("theatreId"),
                        resultSet.getString("theatreName"),
                        resultSet.getInt("theatreCapacity"),
                        resultSet.getString("theatreDistrict"),
                        resultSet.getInt("timeSlot"),
                        resultSet.getDate("date")
                );
                movieSessions.add(movieSession);
            }
        }
        return movieSessions;
    }

    private List<String> parseGenreList(String genreList) {
        List<String> genres = new ArrayList<>();
        if (genreList != null && !genreList.isEmpty()) {
            String[] genreArray = genreList.split(",");
            genres.addAll(Arrays.asList(genreArray));
        }
        return genres;
    }

    private List<String> parsePredecessors(String predecessors) {
        List<String> predecessorList = new ArrayList<>();
        if (predecessors != null && !predecessors.isEmpty()) {
            String[] predecessorIds = predecessors.split(",");
            predecessorList.addAll(Arrays.asList(predecessorIds));
        }
        return predecessorList;
    }

}
