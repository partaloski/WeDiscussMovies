package com.wediscussmovies.project.service;

import com.wediscussmovies.project.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
     List<Person> findAllDirectors();
     List<Person> findAllActors();
    Optional<Person> findById(Integer person_id);
    Optional<Person> findActorById(Integer id);
    Optional<Person> findDirectorById(Integer id);
    boolean save(Person person);
    List<Person> findActorsByNameLike(String name);
    List<Person> findActorsBySurnameLike(String surname);
    List<Person> findDirectorsByNameLike(String name);
    List<Person> findDirectorsBySurnameLike(String surname);

}
