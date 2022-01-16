package com.wediscussmovies.project.service;

import com.wediscussmovies.project.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public interface UserService {
    public Optional<User> login(String email, String password);
    public Optional<User> register(HttpServletRequest request, String email, String password, String confirmPassword, String username, String name, String surname);
}
