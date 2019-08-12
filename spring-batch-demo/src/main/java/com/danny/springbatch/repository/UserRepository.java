package com.danny.springbatch.repository;

import com.danny.springbatch.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
