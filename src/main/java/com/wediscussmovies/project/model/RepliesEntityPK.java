package com.wediscussmovies.project.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class RepliesEntityPK implements Serializable {
    @Column(name = "discussion_id")
    @Id
    private int discussionId;
    @Column(name = "reply_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int replyId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RepliesEntityPK that = (RepliesEntityPK) o;

        if (discussionId != that.discussionId) return false;
        if (replyId != that.replyId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = discussionId;
        result = 31 * result + replyId;
        return result;
    }
}
