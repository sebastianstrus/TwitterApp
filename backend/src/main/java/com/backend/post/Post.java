package com.backend.post;

import com.backend.user.User;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer timestamp = (int)((new Date()).getTime() / 1000); // TODO: move to constructor?
    @ManyToOne
    private User user;
    private String body;

    //empty constructor
    public Post() {}

    public Post(Integer id, Integer timestamp, User user, String body) {
        this.id = id;
        this.timestamp = timestamp;
        this.user = user;
        this.body = body;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}