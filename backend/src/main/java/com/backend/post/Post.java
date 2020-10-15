package com.backend.post;

import com.backend.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date postdate;
    @ManyToOne
    private User user;
    private String body;

    //empty constructor
    public Post() {}

    public Post(Date postdate, User user, String body) {
        this.postdate = postdate;
        this.user = user;
        this.body = body;
    }


    public Date getPostdate() {
        return postdate;
    }

    public void setPostdate(Date postdate) {
        this.postdate = postdate;
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