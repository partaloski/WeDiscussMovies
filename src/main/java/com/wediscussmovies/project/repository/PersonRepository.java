package com.wediscussmovies.project.repository;

import com.wediscussmovies.project.model.Person;
import com.wediscussmovies.project.model.PersonType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    public List<Person> findAllByPersonType(PersonType type);
    public List<Person> findAllByPersonTypeAndNameLike(PersonType type, String name);
    public List<Person> findAllByPersonTypeAndSurnameLike(PersonType type, String surname);
    public Optional<Person> findPersonByPerson_idAndPersonType(Integer id, PersonType type);
}
