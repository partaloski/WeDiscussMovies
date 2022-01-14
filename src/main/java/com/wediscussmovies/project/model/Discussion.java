package com.wediscussmovies.project.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Discussion {
    @Id
    @GeneratedValue
    private int discussion_id;

    @ManyToOne
    @Column(name = "movie_id")
    private Movie movie;

    @ManyToOne()
    @Column(name = "person_id")
    private Person person;

    @ManyToOne
    @Column(name = "user_id")
    private User user;

    @Column(name = "text", length = 1000, nullable = false)
    private String text;

    @Column(name = "title", length = 1000, nullable = false)
    private String title;

    @Column(name = "date", nullable = false)
    private Date date;

    @OneToMany
    private List<Reply> replies;
}


/*
    create table discussions(
        discussion_id serial primary key,
        type char(1) not null,
        text varchar(1000) not null,
        title varchar(250) not null,
        date date not null,
        user_id integer not null,
        movie_id integer,
        person_id integer,
        constraint fk_user_created foreign key (user_id) references users(user_id)
        on delete cascade on update cascade,
        constraint ck_type_discussion check( (type = 'M' and movie_id notnull and person_id isnull)
        or (type='P' and person_id  notnull and movie_id isnull)),
        constraint fk_discussion_movie foreign key (movie_id) references movies(movie_id)
        on delete cascade on update cascade,
        constraint fk_discussion_person foreign key (person_id) references persons(person_id)
        on delete cascade on update cascade
    );

 */