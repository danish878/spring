package com.danny.oauth.data.repository;

import com.danny.oauth.data.entity.Role;
import com.danny.oauth.data.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    User findByName(String name);
}
