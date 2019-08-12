package com.danny.jwtspringsecurityboot.repository;

import com.danny.jwtspringsecurityboot.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);
}
