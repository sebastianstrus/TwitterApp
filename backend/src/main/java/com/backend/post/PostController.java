package com.backend.post;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @RequestMapping(value = "/posts/{id}")
    public Optional<Post> getPost(@PathVariable Integer id) {
        return postService.getPost(id);
    }

    @RequestMapping(value = "/posts/user/{id}")
    public List<Post> getPostsByUserId(@PathVariable Integer id) {
        return postService.getPostsByUserId(id);
    }

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public Optional<Post> addPost(@RequestBody Post post) {
        postService.addPost(post);
        return postService.getPost(post.getId());
    }

    @RequestMapping(value="/posts/{id}", method = RequestMethod.PUT)
    public void updatePost(@PathVariable Integer id, @RequestBody Post post) {
        postService.updatePost(id, post);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
    }
}