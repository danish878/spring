package com.danish.mysqlconnect.repository;

import org.springframework.data.repository.CrudRepository;

import com.danish.mysqlconnect.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
