package com.danny.webflux.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class QuoteRouter {

    private static final String PATTERN_URL = "/quotes";

    @Bean
    public RouterFunction<ServerResponse> route(QuoteHandler handler) {
        return RouterFunctions
                .route(GET(PATTERN_URL)
                        .and(accept(MediaType.APPLICATION_JSON)), handler::fetchQuotes)
                .andRoute(GET(PATTERN_URL)
                        .and(accept(MediaType.APPLICATION_STREAM_JSON)), handler::streamQuotes);
    }
}
