package com.serialization.repository;

import com.serialization.model.SerializedUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerializedUserRepository extends JpaRepository<SerializedUser, Integer> {

}
