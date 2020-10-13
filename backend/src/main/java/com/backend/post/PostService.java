package com.backend.post;


import org.springframework.stereotype.Service;
import com.backend.user.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PostService {

    User user1 = new User("u1", "Sebek3257", "password1", "I'm happy.");
    User user2 = new User("u2", "Jadon", "password2", "All good.");
    Post post1 = new Post("p1","01-Jan-19", user1, "Its good to love and be loved");
    Post post2 = new Post("p2", "02-Jan-19", user2, "We all need someone");

    List<Post> posts = new ArrayList<>(Arrays.asList(post1, post2));


    public List<Post> getAllPosts() {
        return posts;
    }

    public Post getPost(String id) {
        Post post = posts.stream()
                .filter(t -> id.equals(t.getId()))
                .findFirst()
                .orElse(null);
        return post;
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public void updatePost(String id, Post post) {
        for(int i = 0; i < posts.size(); i++) {
            Post p = posts.get(i);
            if(p.equals(post)) {
                posts.set(i, post);
            }
        }
    }

    public void deletePost(String id) {
        posts.removeIf(p -> p.getId().equals(id));
    }
}
