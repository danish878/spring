package com.danny.kafka.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KakfaConfig {

    @Value("${example.topic.name}")
    private String topicName;

//    private KafkaProperties kafkaProperties;
//
//    public KakfaConfig(KafkaProperties kafkaProperties) {
//        this.kafkaProperties = kafkaProperties;
//    }

    @Bean
    public Map<String, Object> producerConfigs() {

//        Map<String, Object> props = new HashMap<>(kafkaProperties.buildProducerProperties());
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.15.60:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return props;
    }

    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

//    @Bean
//    public NewTopic adviceTopic() {
//        return new NewTopic(topicName, 3, (short) 1);
//    }

}