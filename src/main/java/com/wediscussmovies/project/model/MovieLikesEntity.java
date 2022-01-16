package com.wediscussmovies.project.model;

import javax.persistence.*;

@Entity
@Table(name = "movie_likes", schema = "project", catalog = "db_202122z_va_prj_wediscussmovies")
@IdClass(MovieLikesEntityPK.class)
public class MovieLikesEntity {
    @Id
    @Column(name = "movie_id")
    private int movieId;
    @Id
    @Column(name = "user_id")
    private int userId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieLikesEntity that = (MovieLikesEntity) o;

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
