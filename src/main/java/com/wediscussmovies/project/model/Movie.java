package com.wediscussmovies.project.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "movies", schema = "project", catalog = "db_202122z_va_prj_wediscussmovies")
public class Movie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "movie_id")
    private int movieId;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "image_url")
    private String imageUrl;
    @Basic
    @Column(name = "airing_date")
    private Date airingDate;
    @Basic
    @Column(name = "imdb_rating")
    private Double imdbRating;
    @Basic
    @Column(name = "director_id")
    private Integer directorId;
    @OneToMany(mappedBy = "moviesByMovieId")
    private Collection<Discussion> discussionsByMovieId;
    @OneToMany(mappedBy = "moviesByMovieId")
    private Collection<MovieActorsEntity> movieActorsByMovieId;
    @OneToMany(mappedBy = "moviesByMovieId")
    private Collection<MovieGenresEntity> movieGenresByMovieId;
    @OneToMany(mappedBy = "moviesByMovieId")
    private Collection<MovieLikesEntity> movieLikesByMovieId;
    @OneToMany(mappedBy = "moviesByMovieId")
    private Collection<MovieRatesEntity> movieRatesByMovieId;
    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "person_id",insertable = false, updatable = false)
    private Person personsByDirectorId;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getAiringDate() {
        return airingDate;
    }

    public void setAiringDate(Date airingDate) {
        this.airingDate = airingDate;
    }

    public Double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(Double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public Integer getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Integer directorId) {
        this.directorId = directorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie that = (Movie) o;

        if (movieId != that.movieId) return false;
        if (!Objects.equals(title, that.title)) return false;
        if (!Objects.equals(description, that.description)) return false;
        if (!Objects.equals(imageUrl, that.imageUrl)) return false;
        if (!Objects.equals(airingDate, that.airingDate)) return false;
        if (!Objects.equals(imdbRating, that.imdbRating)) return false;
        if (!Objects.equals(directorId, that.directorId)) return false;

        return true;
    }

    public Movie(String title, String description, String imageUrl, Date airingDate, Double imdbRating, Integer directorId) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.airingDate = airingDate;
        this.imdbRating = imdbRating;
        this.directorId = directorId;
    }

    public Movie() {
    }

    @Override
    public int hashCode() {
        int result = movieId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (airingDate != null ? airingDate.hashCode() : 0);
        result = 31 * result + (imdbRating != null ? imdbRating.hashCode() : 0);
        result = 31 * result + (directorId != null ? directorId.hashCode() : 0);
        return result;
    }

    public Collection<Discussion> getDiscussionsByMovieId() {
        return discussionsByMovieId;
    }

    public void setDiscussionsByMovieId(Collection<Discussion> discussionsByMovieId) {
        this.discussionsByMovieId = discussionsByMovieId;
    }

    public Collection<MovieActorsEntity> getMovieActorsByMovieId() {
        return movieActorsByMovieId;
    }

    public void setMovieActorsByMovieId(Collection<MovieActorsEntity> movieActorsByMovieId) {
        this.movieActorsByMovieId = movieActorsByMovieId;
    }

    public Collection<MovieGenresEntity> getMovieGenresByMovieId() {
        return movieGenresByMovieId;
    }

    public void setMovieGenresByMovieId(Collection<MovieGenresEntity> movieGenresByMovieId) {
        this.movieGenresByMovieId = movieGenresByMovieId;
    }

    public Collection<MovieLikesEntity> getMovieLikesByMovieId() {
        return movieLikesByMovieId;
    }

    public void setMovieLikesByMovieId(Collection<MovieLikesEntity> movieLikesByMovieId) {
        this.movieLikesByMovieId = movieLikesByMovieId;
    }

    public Collection<MovieRatesEntity> getMovieRatesByMovieId() {
        return movieRatesByMovieId;
    }

    public void setMovieRatesByMovieId(Collection<MovieRatesEntity> movieRatesByMovieId) {
        this.movieRatesByMovieId = movieRatesByMovieId;
    }

    public Person getPersonsByDirectorId() {
        return personsByDirectorId;
    }

    public void setPersonsByDirectorId(Person personsByDirectorId) {
        this.personsByDirectorId = personsByDirectorId;
    }
}
