package com.wediscussmovies.project.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "movies", schema = "project", catalog = "db_202122z_va_prj_wediscussmovies")
@Data
public class Movie {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "movie_id")
    private Long id;

    private String title;

    private String description;

    @Column(name = "image_url")
    private String imageUrl;


    @Column(name = "airing_date")
    private Date aringDate;

    @Column(name = "imdb_rating")
    private Double imbdRating;

    @ManyToMany
    private List<Genre> genres;

    @ManyToMany
    private List<Person> likes;

    @ManyToMany
    private List<Person> actors;




    @ManyToOne
    @JoinColumn(name = "director_id")
    private Person director;






    public boolean isFromGenre(Genre genre){

     return    genres
                .stream()
                .anyMatch(g -> Objects.equals(g.getId(), genre.getId()));

    }
    public boolean hasActor(Person p){
        return
                actors
                        .stream()
                        .anyMatch(a -> Objects.equals(a.getPersonId(), p.getPersonId()));


    }

    public boolean isDirectedBy(Person p){
        return Objects.equals(director.getPersonId(), p.getPersonId());
    }

    public static Comparator<Movie> comparatorTitle = Comparator.comparing(Movie::getTitle);


    public Movie( String title, String description, String imageUrl, Date aringDate, Double imbdRating,Person director, List<Person> actors, List<Genre> genres) {

        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.aringDate = aringDate;
        this.imbdRating = imbdRating;
        this.genres = genres;
        this.likes = likes;
        this.actors = actors;
        this.director = director;
    }

    public Movie() {
    }


}
