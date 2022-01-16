package com.wediscussmovies.project.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class MovieRatesPK implements Serializable {

    @Id
    @Column(name = "movie_id")
    private Long movieId;

    @Id
    @Column(name = "user_id")
    private Long userId;

}
