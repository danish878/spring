package com.danny.kafka.config;

import com.danny.kafka.model.User;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfiguration {

    @Value("${bootstrapAddress.kafka}")
    private String KAFKA_HOST;

    @Value("${group_id.kafka}")
    private String GROUP_ID;

    @Value("${group_json.kafka}")
    private String GROUP_JSON;

//    @Autowired
//    private KafkaProperties kafkaProperties;
//
////    @Value("${tpd.topic-name}")
////    private String topicName;
//
//    // Producer configuration
//    // omitted...
//
//    // Consumer configuration
//
//    // If you only need one kind of deserialization, you only need to set the
//    // Consumer configuration properties. Uncomment this and remove all others below.
////    @Bean
////    public Map<String, Object> consumerConfigs() {
////        Map<String, Object> props = new HashMap<>(
////                kafkaProperties.buildConsumerProperties()
////        );
////        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
////                StringDeserializer.class);
////        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
////                JsonDeserializer.class);
////        props.put(ConsumerConfig.GROUP_ID_CONFIG,
////                "tpd-loggers");
////
////        return props;
////    }
//    @Bean
//    public Map<String, Object> producerConfigs() {
//
//        Map<String, Object> props = new HashMap<>(kafkaProperties.buildProducerProperties());
//        //host set in application.properties
////        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.15.60:9092");
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//
//        return props;
//    }
//
//    @Bean
//    public ProducerFactory<String, Object> producerFactory() {
//        return new DefaultKafkaProducerFactory<>(producerConfigs());
//    }
//
//    @Bean
//    public KafkaTemplate<String, Object> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//
//    @Bean
//    public ConsumerFactory<String, Object> consumerFactory() {
//        final JsonDeserializer<Object> jsonDeserializer = new JsonDeserializer<>();
//        jsonDeserializer.addTrustedPackages("*");
//        return new DefaultKafkaConsumerFactory<>(
//                kafkaProperties.buildConsumerProperties(), new StringDeserializer(), jsonDeserializer
//        );
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, Object> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//
//        return factory;
//    }
//
//    // String Consumer Configuration
//
//    @Bean
//    public ConsumerFactory<String, String> stringConsumerFactory() {
//        return new DefaultKafkaConsumerFactory<>(
//                kafkaProperties.buildConsumerProperties(), new StringDeserializer(), new StringDeserializer()
//        );
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerStringContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, String> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(stringConsumerFactory());
//
//        return factory;
//    }
//
//    // Byte Array Consumer Configuration
//
//    @Bean
//    public ConsumerFactory<String, byte[]> byteArrayConsumerFactory() {
//        return new DefaultKafkaConsumerFactory<>(
//                kafkaProperties.buildConsumerProperties(), new StringDeserializer(), new ByteArrayDeserializer()
//        );
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, byte[]> kafkaListenerByteArrayContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, byte[]> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(byteArrayConsumerFactory());
//        return factory;
//    }


    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_HOST);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(config);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }


    @Bean
    public ConsumerFactory<String, User> userConsumerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_HOST);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_JSON);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), new JsonDeserializer<>(User.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, User> userKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, User> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(userConsumerFactory());
        return factory;
    }

}