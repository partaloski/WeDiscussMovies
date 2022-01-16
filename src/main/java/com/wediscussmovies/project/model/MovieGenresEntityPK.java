package com.wediscussmovies.project.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class MovieGenresEntityPK implements Serializable {
    @Column(name = "movie_id")
    @Id
    private int movieId;
    @Column(name = "genre_id")
    @Id
    private int genreId;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieGenresEntityPK that = (MovieGenresEntityPK) o;

        if (movieId != that.movieId) return false;
        if (genreId != that.genreId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = movieId;
        result = 31 * result + genreId;
        return result;
    }
}
