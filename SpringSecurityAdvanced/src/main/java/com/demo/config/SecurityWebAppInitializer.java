package com.demo.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebAppInitializer extends AbstractSecurityWebApplicationInitializer {

    public SecurityWebAppInitializer() {
        super(SecurityConfig.class, RootConfig.class);
    }

//	@Override
//	protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
//		super.insertFilters(servletContext, new CustomSpringSecurityFilterChain());
//	}

}
