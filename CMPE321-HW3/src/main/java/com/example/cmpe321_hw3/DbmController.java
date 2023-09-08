package com.example.cmpe321_hw3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.*;

@RestController
public class DbmController {

    @Autowired
    SqlService sql;

    @GetMapping("/dbm/test")
    public String getDatabaseManagers() throws SQLException {
        return sql.getDatabaseManagers();
    }

    @GetMapping("/dbm/test2")
    
    public String test2(@RequestParam String fname, @RequestParam String lname) throws SQLException {
        return "asdafds "+ fname + lname ;
    }
    @GetMapping("/dbm")
    public String mainPage() {
        return """
                <form action="/action_page.php">
                  <label for="fname">First name:</label><br>
                  <input type="text" id="fname" name="fname" value="John"><br>
                  <label for="lname">Last name:</label><br>
                  <input type="text" id="lname" name="lname" value="Doe"><br><br>
                  <input type="submit" value="Submit">
                </form>""";
    }

}
