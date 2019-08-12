package com.danny.jwtspringsecurityboot.entity;

import com.danny.jwtspringsecurityboot.entity.security.Authority;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Setter
@Getter

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String email;
    private String password;
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles = new ArrayList<>();

    public User() {
        this.enabled = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        roles.forEach(ur -> authorities.add(new Authority(ur.getName())));
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}