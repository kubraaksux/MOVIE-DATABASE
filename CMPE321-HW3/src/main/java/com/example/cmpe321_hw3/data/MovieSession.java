package com.example.cmpe321_hw3.data;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public final class MovieSession {
    private final String sessionId;
    private final String movieId;
    private final String movieName;
    private final int duration;
    private final List<String> genreList;
    private final double averageRating;
    private final String directorUsername;
    private final String platformId;
    private final List<String> predecessors;
    private final String theatreId;
    private final String theatreName;
    private final int theatreCapacity;
    private final String theatreDistrict;
    private final int timeSlot;
    private final Date date;

    public MovieSession(String sessionId, String movieId, String movieName, int duration, List<String> genreList, double averageRating, String directorUsername, String platformId, List<String> predecessors, String theatreId, String theatreName, int theatreCapacity, String theatreDistrict, int timeSlot, Date date) {
        this.sessionId = sessionId;
        this.movieId = movieId;
        this.movieName = movieName;
        this.duration = duration;
        this.genreList = genreList;
        this.averageRating = averageRating;
        this.directorUsername = directorUsername;
        this.platformId = platformId;
        this.predecessors = predecessors;
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.theatreCapacity = theatreCapacity;
        this.theatreDistrict = theatreDistrict;
        this.timeSlot = timeSlot;
        this.date = date;
    }

    public String sessionId() {
        return sessionId;
    }

    public String movieId() {
        return movieId;
    }

    public String movieName() {
        return movieName;
    }

    public int duration() {
        return duration;
    }

    public List<String> genreList() {
        return genreList;
    }

    public double averageRating() {
        return averageRating;
    }

    public String directorUsername() {
        return directorUsername;
    }

    public String platformId() {
        return platformId;
    }

    public List<String> predecessors() {
        return predecessors;
    }

    public String theatreId() {
        return theatreId;
    }

    public String theatreName() {
        return theatreName;
    }

    public int theatreCapacity() {
        return theatreCapacity;
    }

    public String theatreDistrict() {
        return theatreDistrict;
    }

    public int timeSlot() {
        return timeSlot;
    }

    public Date date() {
        return date;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (MovieSession) obj;
        return Objects.equals(this.sessionId, that.sessionId) &&
                Objects.equals(this.movieId, that.movieId) &&
                Objects.equals(this.movieName, that.movieName) &&
                this.duration == that.duration &&
                Objects.equals(this.genreList, that.genreList) &&
                Double.doubleToLongBits(this.averageRating) == Double.doubleToLongBits(that.averageRating) &&
                Objects.equals(this.directorUsername, that.directorUsername) &&
                Objects.equals(this.platformId, that.platformId) &&
                Objects.equals(this.predecessors, that.predecessors) &&
                Objects.equals(this.theatreId, that.theatreId) &&
                Objects.equals(this.theatreName, that.theatreName) &&
                this.theatreCapacity == that.theatreCapacity &&
                Objects.equals(this.theatreDistrict, that.theatreDistrict) &&
                this.timeSlot == that.timeSlot &&
                Objects.equals(this.date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId, movieId, movieName, duration, genreList, averageRating, directorUsername, platformId, predecessors, theatreId, theatreName, theatreCapacity, theatreDistrict, timeSlot, date);
    }

    @Override
    public String toString() {
        return "MovieSession[" +
                "sessionId=" + sessionId + ", " +
                "movieId=" + movieId + ", " +
                "movieName=" + movieName + ", " +
                "duration=" + duration + ", " +
                "genreList=" + genreList + ", " +
                "averageRating=" + averageRating + ", " +
                "directorUsername=" + directorUsername + ", " +
                "platformId=" + platformId + ", " +
                "predecessors=" + predecessors + ", " +
                "theatreId=" + theatreId + ", " +
                "theatreName=" + theatreName + ", " +
                "theatreCapacity=" + theatreCapacity + ", " +
                "theatreDistrict=" + theatreDistrict + ", " +
                "timeSlot=" + timeSlot + ", " +
                "date=" + date + ']';
    }


}

