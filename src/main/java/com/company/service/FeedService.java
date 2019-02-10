package com.company.service;

import com.company.data.Post;

import java.util.List;
import java.util.Map;

/**
 * Created by guna on 14/07/18.
 */
public interface FeedService {

    public void logInUser(String userId);

    public void signUpUser(String name);

    public void post(String message);

    public void upvote(String postId);

    public void downVote(String postId);

    public void follow(String name);

    public void reply(String message, String postId);

    public List<Post> showNewsFeed();


}
