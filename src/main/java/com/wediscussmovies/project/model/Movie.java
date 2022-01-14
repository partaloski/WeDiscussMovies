package com.wediscussmovies.project.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name="movies")
public class Movie {
    @Id
    @GeneratedValue
    @Column(name="movie_id", nullable = false)
    private int movie_id;

    @Column(name="title", length = 150, unique = true, nullable = false)
    private String Title;

    @Column(name="description", nullable = false, length = 1000)
    private String description;

    @Column(name="image_url", length = 300, nullable = false)
    private String image_url;

    @Column(name="airing_date")
    private Date airing_date;

    @Column(name="imdb_rating")
    private float imdb_rating;

    @Column(name="director_id")
    @ManyToOne
    private Person director;

    @ManyToMany(mappedBy = "movie_actors")
    private List<Person> actors;

    @ManyToMany(mappedBy = "movie_genres")
    private List<Genre> genres;
}


/*

    create table movies(
        movie_id serial primary key,
        title varchar(150) not null unique,
        description varchar(1000) not null,
        image_url varchar(300) not null,
        airing_date date not null,
        imdb_rating float,
        director_id integer,
        constraint fk_movie_director foreign key (director_id) references persons(person_id)
        on delete cascade on update cascade,
        constraint ck_person_is_director check( check_constraint_person(director_id) = 'D')
    );
 */