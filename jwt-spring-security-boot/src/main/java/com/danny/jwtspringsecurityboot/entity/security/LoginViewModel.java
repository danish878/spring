package com.danny.jwtspringsecurityboot.entity.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginViewModel {

    private String username;
    private String password;
}