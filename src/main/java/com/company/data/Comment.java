package com.company.data;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by guna on 14/07/18.
 */
public class Comment {
    String id;
    String commentMessage;
    Date createdDate;
    List<Reply> replyList;

    public Comment(String id, String commentMessage, Date createdDate) {
        this.id = id;
        this.commentMessage = commentMessage;
        this.createdDate = createdDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommentMessage() {
        return commentMessage;
    }

    public void setCommentMessage(String commentMessage) {
        this.commentMessage = commentMessage;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
