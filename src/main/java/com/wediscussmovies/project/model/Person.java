package com.wediscussmovies.project.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "persons", schema = "project", catalog = "db_202122z_va_prj_wediscussmovies")
public class Person {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "person_id")
    private int personId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Basic
    @Column(name = "image_url")
    private String imageUrl;
    @Basic
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "personsByPersonId")
    private Collection<Discussion> discussionsByPersonId;
    @OneToMany(mappedBy = "personsByActorId")
    private Collection<MovieActorsEntity> movieActorsByPersonId;
    @OneToMany(mappedBy = "personsByDirectorId")
    private Collection<Movie> moviesByPersonId;
    @OneToMany(mappedBy = "personsByPersonId")
    private Collection<PersonRatesEntity> personRatesByPersonId;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person that = (Person) o;

        if (personId != that.personId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(that.dateOfBirth) : that.dateOfBirth != null) return false;
        if (imageUrl != null ? !imageUrl.equals(that.imageUrl) : that.imageUrl != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Collection<Discussion> getDiscussionsByPersonId() {
        return discussionsByPersonId;
    }

    public void setDiscussionsByPersonId(Collection<Discussion> discussionsByPersonId) {
        this.discussionsByPersonId = discussionsByPersonId;
    }

    public Collection<MovieActorsEntity> getMovieActorsByPersonId() {
        return movieActorsByPersonId;
    }

    public void setMovieActorsByPersonId(Collection<MovieActorsEntity> movieActorsByPersonId) {
        this.movieActorsByPersonId = movieActorsByPersonId;
    }

    public Collection<Movie> getMoviesByPersonId() {
        return moviesByPersonId;
    }

    public void setMoviesByPersonId(Collection<Movie> moviesByPersonId) {
        this.moviesByPersonId = moviesByPersonId;
    }

    public Collection<PersonRatesEntity> getPersonRatesByPersonId() {
        return personRatesByPersonId;
    }

    public void setPersonRatesByPersonId(Collection<PersonRatesEntity> personRatesByPersonId) {
        this.personRatesByPersonId = personRatesByPersonId;
    }
}
