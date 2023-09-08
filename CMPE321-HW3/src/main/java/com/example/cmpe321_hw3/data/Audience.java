package com.example.cmpe321_hw3.data;

import java.util.List;

public class Audience extends User {
    private List<String> boughtTickets;
    private List<String> subscribedPlatforms;

    public Audience(String username, String password, String name, String surname, List<String> boughtTickets, List<String> subscribedPlatforms) {
        super(username, password, name, surname);
        this.boughtTickets = boughtTickets;
        this.subscribedPlatforms = subscribedPlatforms;
    }

    public List<String> getBoughtTickets() {
        return boughtTickets;
    }

    public void setBoughtTickets(List<String> boughtTickets) {
        this.boughtTickets = boughtTickets;
    }

    public List<String> getSubscribedPlatforms() {
        return subscribedPlatforms;
    }

    public void setSubscribedPlatforms(List<String> subscribedPlatforms) {
        this.subscribedPlatforms = subscribedPlatforms;
    }
}

