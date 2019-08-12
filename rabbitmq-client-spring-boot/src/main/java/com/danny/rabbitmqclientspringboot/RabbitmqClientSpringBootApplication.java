package com.danny.rabbitmqclientspringboot;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class RabbitmqClientSpringBootApplication implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public RabbitmqClientSpringBootApplication(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending message...");
        for (int i = 1; i < 1000; i++) {
            String message = "[" + i + "] Hello from RabbitMQ!";
            rabbitTemplate.convertAndSend(Config.topicExchangeName, "foo.bar.baz", message);
            Thread.sleep(2000);
        }

//		receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqClientSpringBootApplication.class, args);
    }

}
