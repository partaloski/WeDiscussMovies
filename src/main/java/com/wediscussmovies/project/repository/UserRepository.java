package com.wediscussmovies.project.repository;

import com.wediscussmovies.project.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findByEmailAndPassword(String email, String password);
    public Optional<User> findByUsernameAndPassword(String email, String password);
    public Optional<User> findByUsername(String username);
    public Optional<User> findByEmail(String email);
}
