package com.wediscussmovies.project.service.impl;

import com.wediscussmovies.project.model.User;
import com.wediscussmovies.project.model.exception.PasswordsDontMatchException;
import com.wediscussmovies.project.model.exception.UserWithEmailAlreadyExists;
import com.wediscussmovies.project.model.exception.UserWithUsernameAlreadyExists;
import com.wediscussmovies.project.repository.UserRepository;
import com.wediscussmovies.project.service.UserService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> login(String email, String password) {
        Optional<User> userEmail = userRepository.findByEmailAndPassword(email, password);
        Optional<User> userUsername = userRepository.findByUsernameAndPassword(email, password);
        if(userEmail.isPresent())
            return userEmail;
        else if(userUsername.isPresent())
            return userUsername;
        else
            return Optional.empty();
    }

    @Override
    public Optional<User> register(HttpServletRequest request, String email, String password, String confirmPassword,
                                   String username, String name, String surname) {
        if(email == null || email.isEmpty() || password == null || password.isEmpty() ||
                confirmPassword == null || confirmPassword.isEmpty() || username == null || username.isEmpty() ||
                name == null || name.isEmpty() || surname == null || surname.isEmpty()) {
            request.getSession().setAttribute("error", "Not all of the fields had a value in them, check again.");
            return Optional.empty();
        }
            if(userRepository.findByUsername(username).isPresent()){
            request.getSession().setAttribute("error", new UserWithUsernameAlreadyExists(username).getMessage());
            return Optional.empty();
        }
        if(userRepository.findByEmail(email).isPresent()){
            request.getSession().setAttribute("error", new UserWithEmailAlreadyExists(email).getMessage());
            return Optional.empty();
        }
        if(!password.equals(confirmPassword)){
            request.getSession().setAttribute("error", new PasswordsDontMatchException().getMessage());
            return Optional.empty();
        }
        User user = new User(email, username, password, name, surname);
        return Optional.of(userRepository.save(user));
    }
}
