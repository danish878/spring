package com.danny.oauth;

import com.danny.oauth.data.entity.Role;
import com.danny.oauth.data.entity.User;
import com.danny.oauth.data.repository.RoleRepository;
import com.danny.oauth.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OAuthDemoApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

//	@Autowired
//	private RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(OAuthDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//		Role role_user = new Role();
//		role_user.setName("ROLE_USER");
//
//		Role role_admin = new Role();
//		role_admin.setName("ROLE_ADMIN");
//
//		User user = new User();
//		user.setName("danny");
//		user.setPassword("{noop}danny");
//		user.getRoles().add(role_admin);
//
//		User user1 = new User();
//		user1.setName("totha");
//		user1.setPassword("{noop}totha");
//		user1.getRoles().add(role_user);
//
//		userRepository.save(user);
//		userRepository.save(user1);
    }
}
