package com.wediscussmovies.project.model;

import com.wediscussmovies.project.model.enumerations.DiscussionType;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "discussions", schema = "project", catalog = "db_202122z_va_prj_wediscussmovies")
public class Discussion {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "discussion_id")
    private Long id;

    @Enumerated
    private DiscussionType type;

    private String text;

    private String title;

    private Date date;





    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person person;






    public Discussion(DiscussionType type, String text, String title, Date date, User user, Movie movie, Person person, List<Reply> replies) {
        this.type = type;
        this.text = text;
        this.title = title;
        this.date = date;
        this.user = user;
        this.movie = movie;
        this.person = person;
    }

    public Discussion() {
    }


}
