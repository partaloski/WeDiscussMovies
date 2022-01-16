package com.wediscussmovies.project.service.impl;

import com.wediscussmovies.project.model.Person;
import com.wediscussmovies.project.model.PersonType;
import com.wediscussmovies.project.repository.PersonRepository;
import com.wediscussmovies.project.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAllDirectors() {
        return personRepository.findAllByPersonType(PersonType.D);
    }

    @Override
    public Optional<Person> findActorById(Integer id) {
        return personRepository.findPersonByPerson_idAndPersonType(id, PersonType.A);
    }

    @Override
    public Optional<Person> findById(Integer person_id) {
        return personRepository.findById(person_id);
    }

    @Override
    public Optional<Person> findDirectorById(Integer id) {
        return personRepository.findPersonByPerson_idAndPersonType(id, PersonType.D);
    }

    @Override
    public List<Person> findAllActors() {
        return personRepository.findAllByPersonType(PersonType.A);
    }

    @Override
    public boolean save(Person person) {
        Person p = personRepository.save(person);
        if(p != null)
            return true;
        return false;
    }

    @Override
    public List<Person> findActorsByNameLike(String name) {
        return personRepository.findAllByPersonTypeAndNameLike(PersonType.A, name);
    }

    @Override
    public List<Person> findActorsBySurnameLike(String surname) {
        return personRepository.findAllByPersonTypeAndSurnameLike(PersonType.A, surname);
    }

    @Override
    public List<Person> findDirectorsByNameLike(String name) {
        return personRepository.findAllByPersonTypeAndNameLike(PersonType.D, name);
    }

    @Override
    public List<Person> findDirectorsBySurnameLike(String surname) {
        return personRepository.findAllByPersonTypeAndSurnameLike(PersonType.D, surname);
    }
}
