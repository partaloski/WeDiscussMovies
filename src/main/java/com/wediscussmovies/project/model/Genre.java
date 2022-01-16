package com.wediscussmovies.project.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="genres")
public class Genre {
    @Id
    @GeneratedValue
    @Column(name="genre_id", nullable = false, unique = true)
    private int genre_id;

    @Column(name="genre_type", length = 100, nullable = false, unique = true)
    private String genre_type;

    public Genre(String genreName) {
        this.genre_type = genreName;
    }

    public Genre() {
    }
}

/*

create table genres(
    genre_id serial primary key,
    genre_type varchar(100) not null unique
);

 */