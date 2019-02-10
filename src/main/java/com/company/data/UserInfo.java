package com.company.data;

/**
 * Created by guna on 14/07/18.
 */
public class UserInfo {
    String id;
    String name;

    public UserInfo(String id, String name) {
        this.id = id;
        this.name = name;
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
}
