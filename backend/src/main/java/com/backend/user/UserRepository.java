package com.backend.user;

import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    public List<User> findByUsername(String userName);

    public List<User> findByUsernameContainingIgnoreCase(String str);





}
