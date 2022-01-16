package com.wediscussmovies.project.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class MovieLikesEntityPK implements Serializable {
    @Column(name = "movie_id")
    @Id
    private int movieId;
    @Column(name = "user_id")
    @Id
    private int userId;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieLikesEntityPK that = (MovieLikesEntityPK) o;

        if (movieId != that.movieId) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = movieId;
        result = 31 * result + userId;
        return result;
    }
}
