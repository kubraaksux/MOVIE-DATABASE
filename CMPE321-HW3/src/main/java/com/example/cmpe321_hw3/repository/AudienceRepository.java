package com.example.cmpe321_hw3.repository;

import com.example.cmpe321_hw3.data.Audience;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AudienceRepository {
    private Connection connection;

    public AudienceRepository(Connection connection) {
        this.connection = connection;
    }

    public Audience getAudienceByUsername(String username) throws SQLException {
        String query = "SELECT * FROM Audience WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    List<String> boughtTickets = parseBoughtTickets(resultSet.getString("boughtTickets"));
                    List<String> subscribedPlatforms = parseSubscribedPlatforms(resultSet.getString("subscribedPlatforms"));

                    Audience audience = new Audience(
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            resultSet.getString("name"),
                            resultSet.getString("surname"),
                            boughtTickets,
                            subscribedPlatforms
                    );
                    return audience;
                }
            }
        }
        return null;
    }

    private List<String> parseBoughtTickets(String boughtTickets) {
        List<String> tickets = new ArrayList<>();
        if (boughtTickets != null && !boughtTickets.isEmpty()) {
            String[] ticketArray = boughtTickets.split(",");
            tickets.addAll(Arrays.asList(ticketArray));
        }
        return tickets;
    }

    private List<String> parseSubscribedPlatforms(String subscribedPlatforms) {
        List<String> platforms = new ArrayList<>();
        if (subscribedPlatforms != null && !subscribedPlatforms.isEmpty()) {
            String[] platformArray = subscribedPlatforms.split(",");
            platforms.addAll(Arrays.asList(platformArray));
        }
        return platforms;
    }

}


