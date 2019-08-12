package com.danny.springbatch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class User {

    @Id
    private Integer id;
    private String name;
    private String dept;
    private Integer salary;
    private Date time;

}
