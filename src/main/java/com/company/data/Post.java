package com.company.data;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by guna on 14/07/18.
 */

public class Post {
    String id;
    String postMessage;
    Date createdDate;
    int commentCount;
    int score =0;
    UserInfo userInfo;
    List<Comment> commentList = new ArrayList<>();

    private AtomicInteger upVotes = new AtomicInteger(0);
    private AtomicInteger downVotes = new AtomicInteger(0);


    public int upVotePost() {
        score++;
        return  this.upVotes.incrementAndGet();
    }

    public int downVotePost() {
        score--;
        return  this.downVotes.incrementAndGet();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addComment(Comment comment) {
        this.commentList.add(comment);
        commentCount++;
    }

    public int getCommentCount(){
        return this.commentCount;
    }


    public Post(String id, String postMessage, Date createdDate, String userId, String userName) {
        this.id = id;
        this.postMessage = postMessage;
        this.createdDate = createdDate;
        this.userInfo = new UserInfo(userId, userName);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostMessage() {
        return postMessage;
    }

    public void setPostMessage(String postMessage) {
        this.postMessage = postMessage;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public AtomicInteger getUpVotes() {
        return upVotes;
    }

    public AtomicInteger getDownVotes() {
        return downVotes;
    }
}
