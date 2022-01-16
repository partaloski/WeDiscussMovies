package com.wediscussmovies.project.model;

import javax.persistence.*;

@Entity
@Table(name = "movie_rates", schema = "project", catalog = "db_202122z_va_prj_wediscussmovies")
@IdClass(MovieRatesEntityPK.class)
public class MovieRatesEntity {
    @Id
    @Column(name = "movie_id")
    private int movieId;
    @Id
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "reason")
    private String reason;
    @Basic
    @Column(name = "stars_rated")
    private int starsRated;
    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id", nullable = false,insertable = false, updatable = false)
    private Movie moviesByMovieId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false,insertable = false, updatable = false)
    private User usersByUserId;

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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getStarsRated() {
        return starsRated;
    }

    public void setStarsRated(int starsRated) {
        this.starsRated = starsRated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieRatesEntity that = (MovieRatesEntity) o;

        if (movieId != that.movieId) return false;
        if (userId != that.userId) return false;
        if (starsRated != that.starsRated) return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = movieId;
        result = 31 * result + userId;
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + starsRated;
        return result;
    }

    public Movie getMoviesByMovieId() {
        return moviesByMovieId;
    }

    public void setMoviesByMovieId(Movie moviesByMovieId) {
        this.moviesByMovieId = moviesByMovieId;
    }

    public User getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(User usersByUserId) {
        this.usersByUserId = usersByUserId;
    }
}
