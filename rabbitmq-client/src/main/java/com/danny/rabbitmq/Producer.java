package com.danny.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {

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

        for (int i = 0; i < 5000; i++) {
            String message = "Message number " + i;
            // param 1 = exchange
            // param 2 = routingKey
            channel.basicPublish("", "my-queue", null, message.getBytes());

            System.out.println("Published message: " + message);

            Thread.sleep(2000);
        }

    }
}
