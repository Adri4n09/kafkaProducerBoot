package com.example.controllers;


import com.example.BookGenerator;
import com.example.MessageSender;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private MessageSender kafkaMessageSender;

    @Value("${kafka.book.topic}")
    private String bookTopic;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(value = "/addRandomBook", method = RequestMethod.POST)
    public void addBook() throws JsonProcessingException {
        kafkaMessageSender.send(objectMapper.writeValueAsString(BookGenerator.getRandomBookEvent()),bookTopic);
    }



}
