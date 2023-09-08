package com.example.cmpe321_hw3.repository;

import com.example.cmpe321_hw3.data.RatingPlatform;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RatingPlatformRepository {
    private Connection connection;

    public RatingPlatformRepository(Connection connection) {
        this.connection = connection;
    }

    public List<RatingPlatform> getAllRatingPlatforms() throws SQLException {
        List<RatingPlatform> ratingPlatforms = new ArrayList<>();
        String query = "SELECT * FROM RatingPlatform";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                RatingPlatform ratingPlatform = new RatingPlatform(
                        resultSet.getString("platformId"),
                        resultSet.getString("platformName")
                );
                ratingPlatforms.add(ratingPlatform);
            }
        }
        return ratingPlatforms;
    }

}
