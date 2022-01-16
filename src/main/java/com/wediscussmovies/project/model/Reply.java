package com.wediscussmovies.project.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Optional;

@Entity
@Table(name = "replies", schema = "project", catalog = "db_202122z_va_prj_wediscussmovies")
@IdClass(RepliesEntityPK.class)
@Data
public class Reply {
    @Id
    @Column(name = "discussion_id")
    private Long discussionId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "reply_id")
    private Long replyId;

    private String text;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "discussion_id", referencedColumnName = "discussion_id", nullable = false,insertable = false, updatable = false)
    private Discussion discussion;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;




    public Reply(Discussion discussion, User user, Date date, String text) {
        this.discussion = discussion;
        this.user = user;
        this.date = date;
        this.text = text;

    }

    public Reply() {

    }


}
