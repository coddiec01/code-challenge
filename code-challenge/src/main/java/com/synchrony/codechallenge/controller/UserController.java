package com.synchrony.codechallenge.controller;

import com.synchrony.codechallenge.model.User;
import com.synchrony.codechallenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//Methods to handle incoming HTTP requests and send responses to the client
@RestController
public class UserController {

    private final UserService userService; //immutability for data integrity

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService; //initialized
    }

    @GetMapping("/user") // convert to handler method to retrieve data from the server (fetches and displays data --> to view)
    public User getUserById(@RequestParam Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/user") // handler method that submits data to the server (as an HTTP request)
    public void addUser(@RequestBody User user) {
        userService.addUser(user); // Adds new user
    }

    @PostMapping("/login") // Handler method implemented to return HTTP responses to
    // verify user's credentials and return a status code
    public ResponseEntity<User> authenticate(@RequestBody User user) {
        User authenticatedUser = userService.authenticate(user.getUsername(), user.getPassword());
        if (authenticatedUser != null) {
            return ResponseEntity.ok(authenticatedUser); // Credentials validated
        } else {
            return ResponseEntity.status(401).build(); // Invalid authentication credentials
        }
    }
    @PostMapping("/register")
    public User registerUser(@RequestParam String username, @RequestParam String password) {
        // Registers the user with username and password
        return userService.registerUser(username, password);
    }
}


