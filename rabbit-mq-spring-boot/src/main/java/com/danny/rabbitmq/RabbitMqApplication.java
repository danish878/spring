package com.danny.rabbitmq;

import com.danny.rabbitmq.service.RabbitMQReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class RabbitMqApplication implements CommandLineRunner {

    @Autowired
    RabbitMQReceiver receiver;

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        receiver.getLatch().await(1000, TimeUnit.MILLISECONDS);
    }
}
