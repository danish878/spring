package com.springsecuritydbdemo.service;

import com.springsecuritydbdemo.UserRepository;
import com.springsecuritydbdemo.model.CustomUserDetails;
import com.springsecuritydbdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> optionalUsers = userRepository.findByName(username);

        optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        return optionalUsers.map(CustomUserDetails::new).get();
    }
}
