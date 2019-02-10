package com.company.service;

import com.company.data.Comment;
import com.company.data.Post;
import com.company.data.User;
import com.company.data.UserActive;
import com.company.exception.FlipKartException;
import javafx.geometry.Pos;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.awt.print.Pageable;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by guna on 14/07/18.
 */
@Component
public class FeedServiceImpl implements FeedService {

    private List<User> userList = new ArrayList<>();
    private List<Post> allPosts = new ArrayList<>();

    private AtomicInteger userCount = new AtomicInteger(0);

    private AtomicInteger postCount = new AtomicInteger(0);

    private AtomicInteger commentCount = new AtomicInteger(0);


    @Override
    public void logInUser(String userName) {
        for (User user : userList) {
            if (user.getName().equals(userName)) {
                makeAllInactive();
                user.makeUserActive();
                return;
            }
        }
        throw new FlipKartException("UserNotRegistered!");

    }

    @Override
    public void signUpUser(String name) {
        User user = new User(Integer.toString(getUserId()), name, new Date());
        userList.add(user);
        logInUser(user.getName());
    }

    @Override
    public void post(String message) {
        User user = getActiveUser();
        if (user == null) {
            throw new FlipKartException("message can't be posted, as the user isn't registered");
        }
        Post post = new Post(Integer.toString(getPostId()), message, new Date(), user.getId(), user.getName());
        this.allPosts.add(post);
    }

    @Override
    public void upvote(String postId) {
        for (Post post : allPosts) {
            if (post.getId().equals(postId)) {
                post.upVotePost();
                return;
            }
        }
        throw new FlipKartException("PostId doesnt exist");
    }

    @Override
    public void downVote(String postId) {
        for (Post post : allPosts) {
            if (post.getId().equals(postId)) {
                post.downVotePost();
                return;
            }
        }
        throw new FlipKartException("PostId doesnt exist");
    }

    @Override
    public void follow(String name) {
        User activeUser = getActiveUser();
        for (User user : userList) {
            if (user.getName().equals(name)) {
                activeUser.addAUserToFollowingList(user.getId());
                return;
            }
        }
        throw new FlipKartException("Mentioned name doesn't exist");
    }

    @Override
    public void reply(String message, String postId) {
        User activeUser = getActiveUser();
        Post post = getPostById(postId);

        if (activeUser != null && post != null) {
            post.addComment(new Comment(Integer.toString(getCommentId()), message, new Date()));
            return;
        }
        throw new FlipKartException("postId or active User id wrong");
    }


    @Override
    public List<Post> showNewsFeed() {
        User user = getActiveUser();
        List<String> followingUserId = user.getFollowingUserIds();
        int i=0;

        Collections.sort(allPosts, new Comparator<Post>() {
            @Override
            public int compare(Post a1, Post a2) {
                return (a2.getCreatedDate().compareTo(a1.getCreatedDate()));
            }
        });

        Collections.sort(allPosts, new Comparator<Post>() {
            @Override
            public int compare(Post a1, Post a2) {
                return (a2.getCommentCount() - a1.getCommentCount());
            }
        });

        Collections.sort(allPosts, new Comparator<Post>() {
            @Override
            public int compare(Post a1, Post a2) {
                return (a2.getScore() - a1.getScore());
            }
        });


        for(int j=0; j< allPosts.size(); j++) {
            if(followingUserId.contains(allPosts.get(j).getUserInfo().getId()) && i <=allPosts.size()-1) {
                Collections.swap(allPosts, i, j );
                i++;
            }
        }
        return allPosts;
    }




    public Post getPostById(String postId) {
        for (Post post : allPosts) {
            if (post.getId().equals(postId)) {
                return post;
            }
        }
        return null;
    }

    public void makeAllInactive() {
        for (User user : userList) {
            user.makeUserInactive();
        }
    }

    public int getUserId() {
        return this.userCount.incrementAndGet();
    }

    public int getPostId() {
        return this.postCount.incrementAndGet();
    }

    public int getCommentId() {
        return this.commentCount.incrementAndGet();
    }


    public User getActiveUser() {
        for (User user : userList) {
            if (user.getUserActive() == UserActive.ACTIVE) {
                return user;
            }
        }
        return null;
    }

    public User getUserById(String id) {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
}
