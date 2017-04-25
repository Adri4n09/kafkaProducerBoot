package com.example.controllers;


import com.example.event.BookEventSender;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookEventSender bookEventSender;

    @RequestMapping(value = "/addRandomBook", method = RequestMethod.POST)
    public void addBook() throws JsonProcessingException {
        bookEventSender.sendRandomBookEvent();
    }



}
