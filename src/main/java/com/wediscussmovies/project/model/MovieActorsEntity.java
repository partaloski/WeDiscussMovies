package com.wediscussmovies.project.model;

import javax.persistence.*;

@Entity
@Table(name = "movie_actors", schema = "project", catalog = "db_202122z_va_prj_wediscussmovies")
@IdClass(MovieActorsEntityPK.class)
public class MovieActorsEntity {
    @Id
    @Column(name = "movie_id")
    private int movieId;
    @Id
    @Column(name = "actor_id")
    private int actorId;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id", nullable = false,insertable = false, updatable = false)
    private Movie moviesByMovieId;
    @ManyToOne
    @JoinColumn(name = "actor_id", referencedColumnName = "person_id", nullable = false,insertable = false, updatable = false)
    private Person personsByActorId;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieActorsEntity that = (MovieActorsEntity) o;

        if (movieId != that.movieId) return false;
        if (actorId != that.actorId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = movieId;
        result = 31 * result + actorId;
        return result;
    }

    public Movie getMoviesByMovieId() {
        return moviesByMovieId;
    }

    public void setMoviesByMovieId(Movie moviesByMovieId) {
        this.moviesByMovieId = moviesByMovieId;
    }

    public Person getPersonsByActorId() {
        return personsByActorId;
    }

    public void setPersonsByActorId(Person personsByActorId) {
        this.personsByActorId = personsByActorId;
    }
}
