package com.wediscussmovies.project.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Comparator;
import java.util.List;
@Data
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

    public boolean isFromGenre(Genre genre){
        for(Genre g: genres){
            if(g.getGenre_id() == genre.getGenre_id())
                return true;
        }
        return false;
    }
    public boolean hasActor(Person p){
        for(Person person: actors){
            if(person.getPerson_id() == p.getPerson_id())
                return true;
        }
        return false;
    }

    public boolean isDirectedBy(Person p){
        return director.getPerson_id() == p.getPerson_id();
    }

    public static Comparator<Movie> comparatorTitle = Comparator.comparing(Movie::getTitle);

    public Movie(String title, String description, String image_url, Date airing_date, float imdb_rating, Person director, List<Person> actors, List<Genre> genres) {
        Title = title;
        this.description = description;
        this.image_url = image_url;
        this.airing_date = airing_date;
        this.imdb_rating = imdb_rating;
        this.director = director;
        this.actors = actors;
        this.genres = genres;
    }
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