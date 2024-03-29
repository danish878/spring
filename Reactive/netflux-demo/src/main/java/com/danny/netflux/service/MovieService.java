package com.danny.netflux.service;

import com.danny.netflux.domain.Movie;
import com.danny.netflux.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {

    /**
     * Generate stream of movie events for given movie id
     *
     * @param movieId
     * @return
     */
    Flux<MovieEvent> events(String movieId);

    /**
     * Get Movie by Id
     *
     * @param id
     * @return
     */
    Mono<Movie> getMovieById(String id);

    /**
     * Return list of all movies
     *
     * @return
     */
    Flux<Movie> getAllMovies();
}
