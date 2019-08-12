package com.danny.netflux.bootstrap;

import com.danny.netflux.domain.Movie;
import com.danny.netflux.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class BootstrapCLR implements CommandLineRunner {

    private final MovieRepository movieRepository;

    public BootstrapCLR(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) {

        //clear old data
//        movieRepository.deleteAll().block();
//
//        Flux.just("Silence of the Lambdas", "AEon Flux", "Enter the Mono<Void>", "The Fluxxinator",
//                "Back to the Future", "Meet the Fluxes", "Lord of the Fluxes")
////                .map(title -> new Movie(title))
//                .map(Movie::new)
//                .flatMap(movieRepository::save)
//                .subscribe(null, null,
//                        () -> movieRepository.findAll().subscribe(System.out::println));

        movieRepository.deleteAll()
                .thenMany(
                        Flux.just("Silence of the Lambdas", "AEon Flux", "Enter the Mono<Void>", "The Fluxxinator",
                                "Back to the Future", "Meet the Fluxes", "Lord of the Fluxes")
                                .map(Movie::new)
                                .flatMap(movieRepository::save)
                ).subscribe(null, null, () -> movieRepository.findAll().subscribe(System.out::println));

    }
}
