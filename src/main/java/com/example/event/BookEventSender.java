package com.example.event;

import com.example.BookGenerator;
import com.example.MessageSender;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BookEventSender {

    @Value("${kafka.book.topic}")
    private String booksTopic;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MessageSender messageSender;

    public void sendRandomBookEvent() throws JsonProcessingException {
        messageSender.send(objectMapper.writeValueAsString(BookGenerator.getRandomBookEvent()), booksTopic);
    }

}
