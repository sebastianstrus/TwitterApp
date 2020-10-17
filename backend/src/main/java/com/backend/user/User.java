package com.backend.user;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String bio;
    // TODO, add followings
    /*@ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="Twitter_Following",
            joinColumns={@JoinColumn(name="user_id")},
            inverseJoinColumns={@JoinColumn(name="following_id")})
    private Set<User> followings = new HashSet<>();
    @ManyToMany(mappedBy="followings", cascade={CascadeType.ALL})
    private Set<User> followers = new HashSet<>();*/

    //empty constructor
    public User() {}

    public User(Integer id, String username, String password, String bio) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.bio = bio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    // TODO, add followings
    /*public Set<User> getFollowings() {
        return followings;
    }

    public void setFollowings(Set<User> followings) {
        this.followings = followings;
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<User> followers) {
        this.followers = followers;
    }*/
}