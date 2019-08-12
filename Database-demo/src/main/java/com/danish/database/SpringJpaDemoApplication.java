package com.danish.database;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.danish.database.entity.Person;
import com.danish.database.jpa.PersonJpaRepository;

@SpringBootApplication
public class SpringJpaDemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJpaRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("User id 10001 -> {}", repository.findById(10001));
        logger.info("Inserting id 1 -> {}", repository.insert(new Person("Daood", "Mississauga", new Date())));
        logger.info("Inserting id 2 -> {}", repository.insert(new Person("Daood", "Mississauga", new Date())));
        logger.info("Updating id 1 -> {}", repository.insert(new Person(1, "Danish", "Manitoba", new Date())));
        repository.deleteById(1);
        logger.info("All users -> {}", repository.findAll());
    }

}
