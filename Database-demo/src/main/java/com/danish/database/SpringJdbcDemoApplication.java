package com.danish.database;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.danish.database.entity.Person;
import com.danish.database.jdbc.PersonJdbcDao;

//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJdbcDao dao;

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All users -> {}", dao.findAll());
        logger.info("User id 10001 -> {}", dao.findById(10001));
        logger.info("Deleting id 10001 -> No. of Rows Deleted - {}", dao.deleteById(10002));
        logger.info("Inserting id 10004 -> {}", dao.insert(new Person(10004, "Daood", "Mississauga", new Date())));
        logger.info("Updating id 10001 -> {}", dao.update(new Person(10001, "Danish", "Manitoba", new Date())));
    }

}
