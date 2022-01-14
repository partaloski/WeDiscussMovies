package com.wediscussmovies.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="genres")
public class Genre {
    @Id
    @GeneratedValue
    @Column(name="genre_id", nullable = false, unique = true)
    private int genre_id;

    @Column(name="genre_type", length = 100, nullable = false, unique = true)
    private String genre_type;
}

/*

create table genres(
    genre_id serial primary key,
    genre_type varchar(100) not null unique
);

 */