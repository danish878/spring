package com.danny.kafka.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PracticalAdvice {
    private final String message;
    private final int identifier;

    public PracticalAdvice(@JsonProperty("message") final String message,
                           @JsonProperty("identifier") final int identifier) {
        this.message = message;
        this.identifier = identifier;
    }
}