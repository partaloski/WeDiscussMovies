package com.wediscussmovies.project.service;

import com.wediscussmovies.project.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    public List<Person> findAllDirectors();
    public List<Person> findAllActors();
    Optional<Person> findActorById(Integer id);
    Optional<Person> findDirectorById(Integer id);
}
