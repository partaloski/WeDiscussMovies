package com.wediscussmovies.project.model;


import javax.persistence.*;
import java.util.Collection;
import lombok.Data;


@Entity
@Table(name = "genres", schema = "project", catalog = "db_202122z_va_prj_wediscussmovies")
@Data
public class Genre {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "genre_id")
    private Long id;

    @Column(name = "genre_type")
    private String genre;

    public Genre(String genre) {
        this.genre = genre;
    }

    public Genre() {
    }

}
