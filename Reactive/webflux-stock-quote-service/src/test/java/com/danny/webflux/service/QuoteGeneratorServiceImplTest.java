package com.danny.webflux.service;

import com.danny.webflux.model.Quote;
import org.junit.Before;
import org.junit.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;

public class QuoteGeneratorServiceImplTest {

    private QuoteGeneratorServiceImpl quoteGeneratorService = new QuoteGeneratorServiceImpl();

    @Before
    public void setUp() {
    }

    @Test
    public void fetchQuoteStream() {

        //get quoteFlux of quotes
        Flux<Quote> quoteFlux = quoteGeneratorService.fetchQuoteStream(Duration.ofMillis(1L));

        quoteFlux.take(22000)
                .subscribe(System.out::println);

    }

    @Test
    public void fetchQuoteStreamCountDown() throws Exception {

        //get quoteFlux of quotes
        Flux<Quote> quoteFlux = quoteGeneratorService.fetchQuoteStream(Duration.ofMillis(100L));

        //subscriber lambda
        Consumer<Quote> println = System.out::println;

        //error handler
        Consumer<Throwable> errorHandler = e -> System.out.println("Some Error Occurred");

        //set Countdown latch to 1
        CountDownLatch countDownLatch = new CountDownLatch(1);

        //runnable called upon complete, count down latch
        Runnable allDone = () -> countDownLatch.countDown();

        quoteFlux.take(30)
                .subscribe(println, errorHandler, allDone);

        countDownLatch.await();
    }
}