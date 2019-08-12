package com.danny.kafka.resource;

import com.danny.kafka.model.User;
import com.danny.kafka.service.KafkaProducer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor

@RestController
@RequestMapping("kafka")
public class UserResource {
    //    private static final Logger logger = LoggerFactory.getLogger(UserResource.class);
//
//    private final KafkaTemplate<String, Object> template;
//    private final String topicName;
//    private final int messagesPerRequest;
    private KafkaProducer kafkaProducer;
//
//    public UserResource(
//            final KafkaTemplate<String, Object> template,
//            KafkaProducer kafkaProducer,
//            @Value("${example.topic.name}") final String topicName,
//            @Value("${example.topic.messages-per-request}") final int messagesPerRequest) {
//
//        this.template = template;
//        this.kafkaProducer = kafkaProducer;
//        this.topicName = topicName;
//        this.messagesPerRequest = messagesPerRequest;
//    }

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name) {

        kafkaProducer.sendMessage(new User(name, "dept", 25000L));

        return "Published successfully";
    }

//    @GetMapping("/hello")
//    public String hello() throws Exception {
//        CountDownLatch latch = new CountDownLatch(messagesPerRequest);
//        IntStream.range(0, messagesPerRequest)
//                .forEach(i -> this.template.send(topicName, String.valueOf(i),
//                        new PracticalAdvice("A Practical Advice", i))
//                );
//        latch.await(60, TimeUnit.SECONDS);
//        logger.info("All messages received");
//        return "Hello Kafka!";
//    }

}