package com.wediscussmovies.project.model;

import javax.persistence.*;

@Entity
@Table(name = "movie_genres", schema = "project", catalog = "db_202122z_va_prj_wediscussmovies")
@IdClass(MovieGenresEntityPK.class)
public class MovieGenresEntity {
    @Id
    @Column(name = "movie_id", insertable = false, updatable = false)
    private int movieId;
    @Id
    @Column(name = "genre_id",insertable = false, updatable = false)
    private int genreId;
    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id", nullable = false,insertable = false, updatable = false)
    private Movie moviesByMovieId;
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "genre_id", nullable = false,insertable = false, updatable = false)
    private Genre genresByGenreId;

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

        MovieGenresEntity that = (MovieGenresEntity) o;

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

    public Movie getMoviesByMovieId() {
        return moviesByMovieId;
    }

    public void setMoviesByMovieId(Movie moviesByMovieId) {
        this.moviesByMovieId = moviesByMovieId;
    }

    public Genre getGenresByGenreId() {
        return genresByGenreId;
    }

    public void setGenresByGenreId(Genre genresByGenreId) {
        this.genresByGenreId = genresByGenreId;
    }
}
