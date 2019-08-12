package com.demo.config;

import org.springframework.security.web.FilterChainProxy;

public class CustomSpringSecurityFilterChain extends FilterChainProxy {

//	public CustomSpringSecurityFilterChain() {
//		super(filterChains());
//	}
//
//	private static List<SecurityFilterChain> filterChains() {
//		List<SecurityFilterChain> filterChain = new ArrayList<SecurityFilterChain>();
//		LogoutFilter customLogoutFilter = new LogoutFilter(new CustomLogoutSuccessHandler(),
//				new SecurityContextLogoutHandler());
//		customLogoutFilter.setFilterProcessesUrl("/customlogout");
//		filterChain
//				.add(new DefaultSecurityFilterChain(new AntPathRequestMatcher("/customlogout**"), customLogoutFilter));
//		return filterChain;
//	}
}
