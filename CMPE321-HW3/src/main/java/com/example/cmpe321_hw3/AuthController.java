package com.example.cmpe321_hw3;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.cmpe321_hw3.LoginRequest;


@RestController
public class AuthController {

    @PostMapping("/api/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        // Perform authentication logic
        boolean isAuthenticated = authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());

        if (isAuthenticated) {
            // Authentication successful
            return "Login successful";
        } else {
            // Authentication failed
            return "Login failed";
        }
    }

    private boolean authenticateUser(String username, String password) {
        // Perform validation against your user database or authentication provider
        // Replace this with your own authentication logic

        // Example validation with hardcoded values
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

}
