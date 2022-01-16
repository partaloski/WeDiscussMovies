package com.wediscussmovies.project.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "users", schema = "project", catalog = "db_202122z_va_prj_wediscussmovies")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<Discussion> discussionsByUserId;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<MovieLikesEntity> movieLikesByUserId;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<MovieRatesEntity> movieRatesByUserId;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<PersonRatesEntity> personRatesByUserId;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<Reply> repliesByUserId;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<UserGenresEntity> userGenresByUserId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User that = (User) o;

        if (userId != that.userId) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public Collection<Discussion> getDiscussionsByUserId() {
        return discussionsByUserId;
    }

    public void setDiscussionsByUserId(Collection<Discussion> discussionsByUserId) {
        this.discussionsByUserId = discussionsByUserId;
    }

    public Collection<MovieLikesEntity> getMovieLikesByUserId() {
        return movieLikesByUserId;
    }

    public void setMovieLikesByUserId(Collection<MovieLikesEntity> movieLikesByUserId) {
        this.movieLikesByUserId = movieLikesByUserId;
    }

    public Collection<MovieRatesEntity> getMovieRatesByUserId() {
        return movieRatesByUserId;
    }

    public void setMovieRatesByUserId(Collection<MovieRatesEntity> movieRatesByUserId) {
        this.movieRatesByUserId = movieRatesByUserId;
    }

    public Collection<PersonRatesEntity> getPersonRatesByUserId() {
        return personRatesByUserId;
    }

    public void setPersonRatesByUserId(Collection<PersonRatesEntity> personRatesByUserId) {
        this.personRatesByUserId = personRatesByUserId;
    }

    public Collection<Reply> getRepliesByUserId() {
        return repliesByUserId;
    }

    public void setRepliesByUserId(Collection<Reply> repliesByUserId) {
        this.repliesByUserId = repliesByUserId;
    }

    public Collection<UserGenresEntity> getUserGenresByUserId() {
        return userGenresByUserId;
    }

    public void setUserGenresByUserId(Collection<UserGenresEntity> userGenresByUserId) {
        this.userGenresByUserId = userGenresByUserId;
    }
}
