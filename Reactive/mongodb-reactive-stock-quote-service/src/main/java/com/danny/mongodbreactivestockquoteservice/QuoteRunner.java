package com.danny.mongodbreactivestockquoteservice;

import com.danny.mongodbreactivestockquoteservice.client.StockQuoteClient;
import com.danny.mongodbreactivestockquoteservice.domain.Quote;
import com.danny.mongodbreactivestockquoteservice.repository.QuoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

@AllArgsConstructor

@Component
public class QuoteRunner implements CommandLineRunner {

    private final StockQuoteClient stockQuoteClient;
    private final QuoteRepository quoteRepository;

    @Override
    public void run(String... args) {
//        Flux<Quote> quoteStream = stockQuoteClient.getQuoteStream();
//        quoteStream.subscribe(System.out::println);

        Flux<Quote> quoteFlux = quoteRepository.findWithTailableCursorBy();

        Disposable disposable = quoteFlux.subscribe(quote -> {
            System.out.println("===================>>>>>>>>>>>>>>>>" + quote.getId());
        });

        disposable.dispose();
    }
}
