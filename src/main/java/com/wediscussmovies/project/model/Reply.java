package com.wediscussmovies.project.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "replies", schema = "project", catalog = "db_202122z_va_prj_wediscussmovies")
@IdClass(RepliesEntityPK.class)
public class Reply {
    @Id
    @Column(name = "discussion_id",insertable = false, updatable = false)
    private int discussionId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "reply_id")
    private int replyId;
    @Basic
    @Column(name = "text")
    private String text;
    @Basic
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "user_id")
    private int userId;
    @ManyToOne
    @JoinColumn(name = "discussion_id", referencedColumnName = "discussion_id", nullable = false,insertable = false, updatable = false)
    private Discussion discussionsByDiscussionId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false,insertable = false, updatable = false)
    private User usersByUserId;

    public int getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(int discussionId) {
        this.discussionId = discussionId;
    }

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reply that = (Reply) o;

        if (discussionId != that.discussionId) return false;
        if (replyId != that.replyId) return false;
        if (userId != that.userId) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = discussionId;
        result = 31 * result + replyId;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + userId;
        return result;
    }

    public Discussion getDiscussionsByDiscussionId() {
        return discussionsByDiscussionId;
    }

    public void setDiscussionsByDiscussionId(Discussion discussionsByDiscussionId) {
        this.discussionsByDiscussionId = discussionsByDiscussionId;
    }

    public User getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(User usersByUserId) {
        this.usersByUserId = usersByUserId;
    }
}
