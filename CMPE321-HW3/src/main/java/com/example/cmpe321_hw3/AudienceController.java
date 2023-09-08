package com.example.cmpe321_hw3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class AudienceController {

    @Autowired
    SqlService sql;

    @GetMapping("/audience/test")
    public String getDatabaseManagers() throws SQLException {
        return sql.getDatabaseManagers();
    }

    @GetMapping("/audience/test2")
    public String test2() throws SQLException {
        return "asdafds";
    }

}
