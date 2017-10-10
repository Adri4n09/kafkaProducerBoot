package com.example;

import com.example.event.BookEventSender;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Properties;

@Configuration
@PropertySource("classpath:kafka.properties")
@ComponentScan("com.example")
public class ProducerConfiguration {

    @Value("${kafka.server}")
    private String SERVER_CONFIG;
    @Value("${kafka.key.serializer}")
    private String KEY_SERIALIZER;
    @Value("${kafka.value.serializer}")
    private String VALUE_SERIALIZER;

    @Bean
    public Producer producer() {
        return new KafkaProducer(config());
    }

    private Properties config() {
        Properties configProp = new Properties();
        configProp.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, SERVER_CONFIG);
        configProp.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KEY_SERIALIZER);
        configProp.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, VALUE_SERIALIZER);
        configProp.put(ProducerConfig.ACKS_CONFIG, "all");
        return configProp;
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public ConsoleProducer consoleProducer() {
        return new ConsoleProducer();
    }

    @Bean
    public BookEventSender bookEventSender() {
        return new BookEventSender();
    }

    @Bean
    public MessageSender messageSender() {
        return new MessageSender();
    }
}
