package com.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

/**
 * @author ankidaemon
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan(basePackages = "com.demo.config")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    private final String userQuery = "SELECT username, password, enabled FROM users WHERE username=?";
    private final String authQuery = "SELECT username, role FROM user_roles WHERE username=?";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // @formatter:off
//		auth.inMemoryAuthentication()
//			.withUser("danny").password("{noop}danny").roles("CHIEF")
//			.and()
//			.withUser("test").password("{noop}test").roles("USER");

//		auth.jdbcAuthentication()
//			.dataSource(dataSource)
//			.passwordEncoder(new BCryptPasswordEncoder())
//			.usersByUsernameQuery(userQuery)
//			.authoritiesByUsernameQuery(authQuery);

        auth.userDetailsService(customUserDetailsService());

//		auth.ldapAuthentication()
//			.contextSource()
//			.url("ldap://127.0.0.1:389/dc=packt,dc=com")
//			.managerDn("uid=admin,ou=system")
//			.managerPassword("danny")
//			.and()
//				.userDnPatterns("uid={0},ou=finance")
//			.groupSearchBase("ou=groups");


        // @formatter:on
    }

    @Bean
    public UserDetailsService customUserDetailsService() {
        JdbcDaoImpl jdbcUserDetailService = new JdbcDaoImpl();

        jdbcUserDetailService.setDataSource(dataSource);
        jdbcUserDetailService.setUsersByUsernameQuery(userQuery);
        jdbcUserDetailService.setAuthoritiesByUsernameQuery(authQuery);

        return jdbcUserDetailService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off

        http.authorizeRequests()
//			.regexMatchers("/chief/.*")
//				.hasRole("CHIEF")
//			.regexMatchers("/agent/.*")
//				.access("hasRole('AGENT') and principal.name='James Bond'")
                .anyRequest().authenticated();
//			.requiresChannel()
//				.anyRequest()
//					.requiresSecure()
//			.and()
//				.rememberMe().key("HashTokenkeyName").tokenValiditySeconds(100);
//				.rememberMe().key("PersistenceTokenkeyName").tokenRepository(persistentTokenRepository()).tokenValiditySeconds(100);

        http.formLogin()
                .loginPage("/login")
//				.loginProcessingUrl("/auth")
//				.defaultSuccessUrl("/")
//				.failureUrl("/login?error")
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/accessDenied");

//		http.logout()
//			.permitAll();

        http.logout()
                .logoutUrl("/customlogout")
                .logoutSuccessUrl("/")
                .logoutSuccessHandler(new CustomLogoutSuccessHandler());

//		http.headers()
//		.cacheControl()
//		.and().contentTypeOptions()
//		.and().httpStrictTransportSecurity()
//				.includeSubDomains(true)
//				.maxAgeInSeconds(31536000)
//		.and().httpPublicKeyPinning()
//				.includeSubDomains(true)
//				.reportUri("https://report-uri.io/")  //<Reporting URL - https://report-uri.io/>
//				.addSha256Pins("U3ByaW5nU2VjdXJpdHlJbkVhc3lTdGVwcw==") //< Base64 encoded Subject Public Key Information (SPKI) fingerprint >
//		.and().xssProtection().block(false)
//		.and().addHeaderWriter(new StaticHeadersWriter("Custom-Security-Header","value"));
//		
//		http.sessionManagement()
//			.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//			.maximumSessions(1)
//			.maxSessionsPreventsLogin(true)
//			.expiredUrl("/login")
//			.and()
//			.invalidSessionUrl("/login") // If specified, logout().delete-cookies("JSESSIONID") should be specified.
//			.sessionFixation().changeSessionId();


        // @formatter:on
    }


//	@Bean
//	public PersistentTokenRepository persistentTokenRepository() {
//		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
//		db.setDataSource(dataSource);
//		return db;
//	}

}
