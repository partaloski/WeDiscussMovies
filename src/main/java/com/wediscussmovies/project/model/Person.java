package com.wediscussmovies.project.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name="persons")
public class Person {
    @Id
    @GeneratedValue
    private int person_id;

    @Column(name="name", length=100, nullable=false, unique=false)
    private String name;

    @Column(name="surname", length=100, nullable=false, unique=false)
    private String surname;

    @Column(name="type", nullable = false)
    private PersonType personType;

    @Column(name="date_of_birth", nullable=false)
    private Date date_of_birth;

    @Column(name="image_url", length=300, nullable=false, unique=false)
    private String image_url;

    @Column(name="description", length=300, nullable=false, unique=false)
    private String description;

    @ManyToMany
    private List<Movie> acts_in;
}


/*
        create table persons(
        person_id serial primary key,
        name varchar(100) not null,
        surname varchar(100) not null,
        type char(1) not null,
        date_of_birth date not null,
        image_url varchar(300) not null,
        description varchar(300) not null,
        constraint ck_type check (type ='A' or type='D')
    );
 */