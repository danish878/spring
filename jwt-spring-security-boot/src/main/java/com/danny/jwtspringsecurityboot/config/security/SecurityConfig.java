package com.danny.jwtspringsecurityboot.config.security;

import com.danny.jwtspringsecurityboot.repository.UserRepository;
import com.danny.jwtspringsecurityboot.service.security.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

@EnableWebSecurity
public class SecurityConfig {

    private static final String SALT = "hIO$jhu&bL7T3_dk*4J7";
    private static UserRepository userRepository;
    private final UserSecurityService userSecurityService;

    public SecurityConfig(UserSecurityService userSecurityService, UserRepository userRepository) {
        this.userSecurityService = userSecurityService;
        SecurityConfig.userRepository = userRepository;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder());
    }

    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

        protected void configure(HttpSecurity http) throws Exception {
            JwtAuthenticationFilter authenticationFilter = new JwtAuthenticationFilter(authenticationManager());
            authenticationFilter.setFilterProcessesUrl("/api/login");
            http
                    // remove csrf and state in session because in jwt we do not need them
                    .csrf().disable()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    // add jwt filters (1. authentication, 2. authorization)
//                    .addFilter(authenticationFilter)
                    .addFilter(authenticationFilter)
                    .addFilter(new JwtAuthorizationFilter(authenticationManager(), userRepository))
                    .antMatcher("/api/**")
                    .authorizeRequests()
                    // configure access rules
                    .antMatchers(HttpMethod.POST, "/api/login").permitAll()
                    .antMatchers("/api/public/management/*").hasRole("MANAGER")
                    .antMatchers("/api/public/admin/*").hasRole("ADMIN")
                    .anyRequest().authenticated();
        }
    }

    @Configuration
    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin();
        }
    }

}