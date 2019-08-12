package com.danny.kafka.listener;

import com.danny.kafka.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

//    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    //    private final KafkaTemplate<String, Object> template;
//    private final String topicName;
//    private final int messagesPerRequest;
//    private CountDownLatch latch;
//
//    public KafkaConsumer() {
////            final KafkaTemplate<String, Object> template,
////            @Value("${example.topic.name}") final String topicName,
////            @Value("${example.topic.messages-per-request}") final int messagesPerRequest) {
////        this.template = template;
////        this.topicName = topicName;
////        this.messagesPerRequest = messagesPerRequest;
//        latch = new CountDownLatch(10);
//    }

    @KafkaListener(topics = "Kafka_Example", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }


    @KafkaListener(topics = "Kafka_Example_JSON", groupId = "group_json", containerFactory = "userKafkaListenerFactory")
    public void consumeJson(User user) {
        System.out.println("Consumed JSON Message: " + user);
    }

//    private static String typeIdHeader(Headers headers) {
//        return StreamSupport.stream(headers.spliterator(), false)
//                .filter(header -> header.key().equals("__TypeId__"))
//                .findFirst().map(header -> new String(header.value())).orElse("N/A");
//    }
//
//    @KafkaListener(topics = "Kafka_Example", clientIdPrefix = "json", containerFactory = "kafkaListenerContainerFactory")
//    public void listenAsObject(ConsumerRecord<String, PracticalAdvice> cr,
//                               @Payload PracticalAdvice payload) {
//        logger.info("Logger 1 [JSON] received key {}: Type [{}] | Payload: {} | Record: {}", cr.key(),
//                typeIdHeader(cr.headers()), payload, cr.toString());
//        latch.countDown();
//    }
//
//    @KafkaListener(topics = "Kafka_Example", clientIdPrefix = "string",
//            containerFactory = "kafkaListenerStringContainerFactory")
//    public void listenasString(ConsumerRecord<String, String> cr,
//                               @Payload String payload) {
//        logger.info("Logger 2 [String] received key {}: Type [{}] | Payload: {} | Record: {}", cr.key(),
//                typeIdHeader(cr.headers()), payload, cr.toString());
//        latch.countDown();
//    }
//
//    @KafkaListener(topics = "Kafka_Example", clientIdPrefix = "bytearray",
//            containerFactory = "kafkaListenerByteArrayContainerFactory")
//    public void listenAsByteArray(ConsumerRecord<String, byte[]> cr,
//                                  @Payload byte[] payload) {
//        logger.info("Logger 3 [ByteArray] received key {}: Type [{}] | Payload: {} | Record: {}", cr.key(),
//                typeIdHeader(cr.headers()), payload, cr.toString());
//        latch.countDown();
//    }
}