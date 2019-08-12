package com.danny.mongodb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Document(collection = "book")
public class Book {

    @Id
//    public ObjectId _id;
    public String id;

    private String bookName;
    private String authorName;

    // ObjectId needs to be converted to string
//    public String get_id() {
//        return _id.toHexString();
//    }
}
