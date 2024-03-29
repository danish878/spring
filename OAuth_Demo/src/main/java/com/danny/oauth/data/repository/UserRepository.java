package com.danny.oauth.data.repository;

import com.danny.oauth.data.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByName(String name);
}
