package com.danny.netflux.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@RequiredArgsConstructor

@Document
public class Movie {

    private String id;

    @NonNull
    private String title;

}
