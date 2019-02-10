package com.company.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by guna on 14/07/18.
 */
public class User {
    String id;
    String name;
    Date loggedInTime;
    Enum userActive;

    List<String> followingUserIds = new ArrayList<>();

    public User(String id, String name, Date loggedInTime) {
        this.id = id;
        this.name = name;
        this.loggedInTime = loggedInTime;
        this.userActive = UserActive.INACTIVE;
    }

    public boolean addAUserToFollowingList(String userId) {
        this.followingUserIds.add(userId);
        return true;
    }

    public List<String> getFollowingUserIds() {
        return followingUserIds;
    }

    public boolean makeUserActive() {
        this.userActive = UserActive.ACTIVE;
        return true;
    }

    public boolean makeUserInactive() {
        this.userActive = UserActive.INACTIVE;
        return true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLoggedInTime() {
        return loggedInTime;
    }

    public void setLoggedInTime(Date loggedInTime) {
        this.loggedInTime = loggedInTime;
    }

    public Enum getUserActive() {
        return userActive;
    }

    public void setUserActive(Enum userActive) {
        this.userActive = userActive;
    }
}
