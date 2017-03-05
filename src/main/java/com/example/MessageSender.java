package com.example;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;


public class MessageSender {

    @Autowired
    private Producer producer;

    public void send(String str, String topic) {
        producer.send(new ProducerRecord(topic,str));
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
