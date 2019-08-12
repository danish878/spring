package com.danny.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Consumer {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri("amqp://danny:danny@192.168.15.15");
        factory.setConnectionTimeout(300000);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // param 1 = queue
        // param 2 = durable
        // param 3 = exclusive
        // param 4 = auto delete
        // param 5 = arguments
        channel.queueDeclare("my-queue", true, false, false, null);

        System.out.println(" [*] Waiting for messages...");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
        };
        channel.basicConsume("my-queue", true, deliverCallback, consumerTag -> {
        });

    }
}
