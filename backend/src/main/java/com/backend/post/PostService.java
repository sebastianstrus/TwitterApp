package com.backend.post;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        postRepository.findAll()
                .forEach(posts::add);
        return posts;
    }

    public Optional<Post> getPost(Integer id) {
        return postRepository.findById(id);
    }

    public List<Post> getPostsByUser(Integer id) {
        List<Post> posts = new ArrayList<>();
        postRepository.findByUserId(id)
                .forEach(posts::add);
        return posts;
    }

    public void addPost(Post post) {
        postRepository.save(post);
    }

    public void updatePost(Integer id, Post post) {
        postRepository.save(post);
    }

    public void deletePost(Integer id) {
        postRepository.deleteById(id);
    }

    public List<Post> getPostsByUserId(Integer id) {
        return postRepository.findByUserId(id);
    }
}

