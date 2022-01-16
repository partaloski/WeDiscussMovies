package com.wediscussmovies.project.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name="users")
public class User {
    @Id
    @GeneratedValue
    @Column(name="user_id", nullable = false)
    private int user_id;

    @Column(name="username", length=50, nullable=false, unique=false)
    private String username;

    @Column(name="name", length=50, nullable=false, unique=false)
    private String name;

    @Column(name="surname", length=50, nullable=false, unique=false)
    private String surname;

    @Column(name="email", length=50, nullable=false, unique=false)
    private String email;

    @Column(name="password", length=100, nullable=false, unique=true)
    private String password;

    //TODO("RATES_MOVIE")
    @ManyToMany(mappedBy = "movie_likes")
    private List<Movie> likes_movie;

    @ManyToMany(mappedBy = "user_genres")
    private List<Genre> likes_genres;

}


/*
    create table users(
      user_id serial primary key,
      username varchar(50) not null unique,
      name varchar(50) not null,
      surname varchar(50) not null,
      email varchar(100) not null unique,
      password varchar(30) not null,
      constraint ck_password check(length(password) >= 9)
    );
 */