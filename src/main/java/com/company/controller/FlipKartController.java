package com.company.controller;

import com.company.data.Post;
import com.company.service.FeedService;
import com.company.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

/**
 * Created by gunaass
 */
@Controller
public class FlipKartController {


    @Autowired
    FeedService feedService;

    @RequestMapping(value = "api/v1/flipkart/run", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> startDistribution() {
        feedService.signUpUser("lucious");
        feedService.signUpUser("albus");
        feedService.signUpUser("tom");
        feedService.logInUser("tom");
        feedService.post("I am going to be the drakest wizard of all time");
        feedService.post("I am lord vodemort btw ");
        feedService.logInUser("albus");
        feedService.post("Happiness can be found , even in the drakest of times, of one only remembers to turn on the light.");
        feedService.logInUser("lucious");
        feedService.upvote("1");
//        feedService.follow("tom");
        feedService.reply("I am with you darkLord","1");

        Map<String, Integer> a = new HashMap<String, Integer>();
//        feedService.logInUser("albus");
//        feedService.post("Happiness can be found , even in the drakest of times, of one only remembers to turn on the light.");
//        feedService.follow("tom");
//        feedService.downVote("1");
//        feedService.downVote("2");
//        feedService.reply("LOL","2");
        List<Post> posts = feedService.showNewsFeed();

        return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
    }

}
