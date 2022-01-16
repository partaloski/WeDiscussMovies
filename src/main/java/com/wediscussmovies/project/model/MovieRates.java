package com.wediscussmovies.project.model;

import javax.persistence.*;

@Entity
@Table(name = "movie_rates", schema = "project", catalog = "db_202122z_va_prj_wediscussmovies")
@IdClass(MovieRatesPK.class)
public class MovieRates {

    @Id
    @Column(name = "movie_id")
    private Long movieId;

    @Id
    @Column(name = "user_id")
    private Long userId;

    private String reason;

    @Column(name = "stars_rated")
    private int stars;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id", nullable = false, insertable = false, updatable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false)
    private User user;

    public MovieRates(Long movieId, Long userId, String reason, int starsRated) {
        this.movieId = movieId;
        this.userId = userId;
        this.reason = reason;
        this.stars = starsRated;
    }

    public MovieRates() {
    }
}