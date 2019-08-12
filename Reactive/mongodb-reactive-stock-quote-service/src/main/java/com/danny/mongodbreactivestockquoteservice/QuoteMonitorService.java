package com.danny.mongodbreactivestockquoteservice;

import com.danny.mongodbreactivestockquoteservice.client.StockQuoteClient;
import com.danny.mongodbreactivestockquoteservice.domain.Quote;
import com.danny.mongodbreactivestockquoteservice.repository.QuoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@AllArgsConstructor

@Service
public class QuoteMonitorService implements ApplicationListener<ContextRefreshedEvent> {

    private final StockQuoteClient stockQuoteClient;
    private final QuoteRepository quoteRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("==========>>>>>>>>>>>Starting Application Event...");
//        Mono<Quote> savedQuote = quoteRepository.save(new Quote("ticker", new BigDecimal(7)));
//        System.out.println(savedQuote.block().getId());
        stockQuoteClient.getQuoteStream()
                .log("quote-monitor-service")
                .subscribe(quote -> {
                    Mono<Quote> savedQuote = quoteRepository.save(quote);
//                    System.out.println(savedQuote.block());
                    System.out.println("I saved a quote! Id: " + savedQuote.block().getId());
                });
    }
}
