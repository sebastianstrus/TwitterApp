package com.backend.post;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Integer> {

    public List<Post> findByUserId(Integer userId);
}
