package com.company.data;

import java.util.Date;

/**
 * Created by guna on 14/07/18.
 */

public class Reply {
    String id;
    String replyMessage;
    Date createdDate;

    UserInfo userInfo;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReplyMessage() {
        return replyMessage;
    }

    public void setReplyMessage(String replyMessage) {
        this.replyMessage = replyMessage;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
