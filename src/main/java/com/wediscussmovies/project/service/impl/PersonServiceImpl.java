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
    public Optional<Person> findDirectorById(Integer id) {
        return personRepository.findPersonByPerson_idAndPersonType(id, PersonType.D);
    }

    @Override
    public List<Person> findAllActors() {
        return personRepository.findAllByPersonType(PersonType.A);
    }
}
