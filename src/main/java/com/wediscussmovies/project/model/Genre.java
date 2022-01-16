package com.wediscussmovies.project.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "genres", schema = "project", catalog = "db_202122z_va_prj_wediscussmovies")
public class Genre {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "genre_id")
    private int genreId;
    @Basic
    @Column(name = "genre_type")
    private String genreType;
    @OneToMany(mappedBy = "genresByGenreId")
    private Collection<MovieGenresEntity> movieGenresByGenreId;
    @OneToMany(mappedBy = "genresByGenreId")
    private Collection<UserGenresEntity> userGenresByGenreId;

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenreType() {
        return genreType;
    }

    public void setGenreType(String genreType) {
        this.genreType = genreType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre that = (Genre) o;

        if (genreId != that.genreId) return false;
        if (genreType != null ? !genreType.equals(that.genreType) : that.genreType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = genreId;
        result = 31 * result + (genreType != null ? genreType.hashCode() : 0);
        return result;
    }

    public Collection<MovieGenresEntity> getMovieGenresByGenreId() {
        return movieGenresByGenreId;
    }

    public void setMovieGenresByGenreId(Collection<MovieGenresEntity> movieGenresByGenreId) {
        this.movieGenresByGenreId = movieGenresByGenreId;
    }

    public Collection<UserGenresEntity> getUserGenresByGenreId() {
        return userGenresByGenreId;
    }

    public void setUserGenresByGenreId(Collection<UserGenresEntity> userGenresByGenreId) {
        this.userGenresByGenreId = userGenresByGenreId;
    }

    public Genre(String genreType) {
        this.genreType = genreType;
    }

    public Genre() {
    }
}
