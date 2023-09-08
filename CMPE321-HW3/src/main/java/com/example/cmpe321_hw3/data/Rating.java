package com.example.cmpe321_hw3.data;

public class Rating {
    private String username;
    private String movieId;
    private double rating;

    // Constructors
    public Rating(String username, String movieId, double rating) {
        this.username = username;
        this.movieId = movieId;
        this.rating = rating;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}

