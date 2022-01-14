package com.wediscussmovies.project.model;

import javax.persistence.*;
import java.sql.Date;

@Entity(name="replies")
public class Reply {
    @Id
    @GeneratedValue
    @Column(name = "reply_id")
    private int reply_id;

    @ManyToOne
    @Column(name = "discussion_id")
    private Discussion discussion;

    @ManyToOne
    @Column(name = "user_id")
    private User user;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name= "text", length = 1000, nullable = false)
    private String text;
}


/*

    create table replies(
        discussion_id integer,
        reply_id serial,
        text varchar(1000) not null,
        date date not null,
        user_id integer not null,
        constraint pk_replies primary key(discussion_id,reply_id),
        constraint fk_user_create_reply foreign key (user_id) references users(user_id)
        on delete cascade on update cascade,
        constraint fk_reply_discussion foreign key (discussion_id) references discussions(discussion_id)
        on delete cascade on update cascade


    );
 */