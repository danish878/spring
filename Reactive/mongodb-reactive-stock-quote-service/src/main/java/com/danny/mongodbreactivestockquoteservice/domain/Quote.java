package com.danny.mongodbreactivestockquoteservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.Instant;

@Data

@Document
public class Quote {

    @Id
    private String id;
    private String ticker;
    private BigDecimal price;
    private Instant instant;

//    public Quote(String ticker, BigDecimal price) {
//        this.ticker = ticker;
//        this.price = price;
//    }
}
