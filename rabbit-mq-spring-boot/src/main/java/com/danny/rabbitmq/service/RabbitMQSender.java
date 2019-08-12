package com.danny.rabbitmq.service;

import com.danny.rabbitmq.model.Employee;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${danny.rabbitmq.exchange}")
    private String exchange;

    @Value("${danny.rabbitmq.routingkey}")
    private String routingkey;

    public void send(Employee company) {
        amqpTemplate.convertAndSend(exchange, routingkey, company);
        System.out.println("Send msg = " + company);

    }
}