package com.wediscussmovies.project.repository;

import com.wediscussmovies.project.model.*;
import com.wediscussmovies.project.model.enumerations.PersonType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    public List<Person> findAllByType(Character type);
    public List<Person> findAllByTypeAndNameLike(Character type, String name);
    public List<Person> findAllByTypeAndSurnameLike(Character type, String surname);
    public Optional<Person> findPersonByPersonIdAndType(Integer id, Character type);
}
