package com.danny.jwtspringsecurityboot.service;

import com.danny.jwtspringsecurityboot.entity.Role;
import com.danny.jwtspringsecurityboot.entity.User;
import com.danny.jwtspringsecurityboot.repository.RoleRepository;
import com.danny.jwtspringsecurityboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class InitDb implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        if (roleRepository.findByName("ROLE_ADMIN") == null) {
            Role roleAdmin = new Role();
            roleAdmin.setName("ROLE_ADMIN");
            roleRepository.save(roleAdmin);

            Role roleManager = new Role();
            roleManager.setName("ROLE_MANAGER");
            roleRepository.save(roleManager);

            Role roleUser = new Role();
            roleUser.setName("ROLE_USER");
            roleRepository.save(roleUser);

            User user = new User();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("user"));
            user.getRoles().add(roleUser);
            userRepository.save(user);

            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.getRoles().add(roleAdmin);
            userRepository.save(admin);

            User manager = new User();
            manager.setUsername("manager");
            manager.setPassword(passwordEncoder.encode("manager"));
            manager.getRoles().add(roleManager);
            userRepository.save(manager);
        }

    }
}