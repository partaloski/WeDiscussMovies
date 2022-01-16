package com.wediscussmovies.project.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "discussions", schema = "project", catalog = "db_202122z_va_prj_wediscussmovies")
public class Discussion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "discussion_id")
    private int discussionId;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "text")
    private String text;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "movie_id")
    private Integer movieId;
    @Basic
    @Column(name = "person_id")
    private Integer personId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false,insertable = false, updatable = false)
    private User usersByUserId;
    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id",insertable = false, updatable = false)
    private Movie moviesByMovieId;
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id",insertable = false, updatable = false)
    private Person personsByPersonId;
    @OneToMany(mappedBy = "discussionsByDiscussionId")
    private Collection<Reply> repliesByDiscussionId;

    public int getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(int discussionId) {
        this.discussionId = discussionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Discussion that = (Discussion) o;

        if (discussionId != that.discussionId) return false;
        if (userId != that.userId) return false;
        if (!Objects.equals(type, that.type)) return false;
        if (!Objects.equals(text, that.text)) return false;
        if (!Objects.equals(title, that.title)) return false;
        if (!Objects.equals(date, that.date)) return false;
        if (!Objects.equals(movieId, that.movieId)) return false;
        if (!Objects.equals(personId, that.personId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = discussionId;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + (movieId != null ? movieId.hashCode() : 0);
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        return result;
    }

    public User getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(User usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    public Movie getMoviesByMovieId() {
        return moviesByMovieId;
    }

    public void setMoviesByMovieId(Movie moviesByMovieId) {
        this.moviesByMovieId = moviesByMovieId;
    }

    public Person getPersonsByPersonId() {
        return personsByPersonId;
    }

    public void setPersonsByPersonId(Person personsByPersonId) {
        this.personsByPersonId = personsByPersonId;
    }

    public Collection<Reply> getRepliesByDiscussionId() {
        return repliesByDiscussionId;
    }

    public void setRepliesByDiscussionId(Collection<Reply> repliesByDiscussionId) {
        this.repliesByDiscussionId = repliesByDiscussionId;
    }

    public Discussion() {
    }

    public Discussion(String type, String text, String title, Date date, int userId, Integer movieId, Integer personId) {
        this.type = type;
        this.text = text;
        this.title = title;
        this.date = date;
        this.userId = userId;
        this.movieId = movieId;
        this.personId = personId;
    }
}
