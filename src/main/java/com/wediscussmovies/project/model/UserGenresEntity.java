package com.wediscussmovies.project.model;

import javax.persistence.*;

@Entity
@Table(name = "user_genres", schema = "project", catalog = "db_202122z_va_prj_wediscussmovies")
@IdClass(UserGenresEntityPK.class)
public class UserGenresEntity {
    @Id
    @Column(name = "user_id")
    private int userId;
    @Id
    @Column(name = "genre_id")
    private int genreId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false,insertable = false, updatable = false)
    private User usersByUserId;
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "genre_id", nullable = false,insertable = false, updatable = false)
    private Genre genresByGenreId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

        UserGenresEntity that = (UserGenresEntity) o;

        if (userId != that.userId) return false;
        if (genreId != that.genreId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + genreId;
        return result;
    }

    public User getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(User usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    public Genre getGenresByGenreId() {
        return genresByGenreId;
    }

    public void setGenresByGenreId(Genre genresByGenreId) {
        this.genresByGenreId = genresByGenreId;
    }
}
