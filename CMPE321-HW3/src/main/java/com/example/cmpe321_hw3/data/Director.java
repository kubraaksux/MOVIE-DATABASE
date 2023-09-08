package com.example.cmpe321_hw3.data;

public class Director extends User {
    private String nation;
    private String platformId;

    // Constructors
    public Director(String username, String password, String name, String surname, String nation, String platformId) {
        super(username, password, name, surname);
        this.nation = nation;
        this.platformId = platformId;
    }

    // Getters and setters
    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }
}
