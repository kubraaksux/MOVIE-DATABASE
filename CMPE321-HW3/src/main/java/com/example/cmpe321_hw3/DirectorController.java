package com.example.cmpe321_hw3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class DirectorController {

    @Autowired
    SqlService sql;

    @GetMapping("/director/test")
    public String getDatabaseManagers() throws SQLException {
        return sql.getDatabaseManagers();
    }

    @GetMapping("/director/test2")
    public String test2() throws SQLException {
        return "asdafds";
    }

}
