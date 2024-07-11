package com.synchrony.codechallenge.service;

import com.synchrony.codechallenge.model.User;

public interface UserService {
    User getUserById(Long id);
    void addUser(User user);
    User authenticate(String username, String password);
    User registerUser(String username, String password);
}

