package com.example;

import com.example.event.BookEvent;
import com.example.event.OperationType;
import com.example.model.Book;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.UUID;

public class BookGenerator {

    public static Book getRandomBook() {
        Random random = new Random();
        return new Book(UUID.randomUUID().toString().substring(0,10),
                random.nextInt()/100000,
                UUID.randomUUID().toString().substring(0,10),
                UUID.randomUUID().toString().substring(0,10),
                UUID.randomUUID().toString().substring(0,10),
                Double.parseDouble(new DecimalFormat("##.##").format(random.nextDouble() * 1000)));
    }

    public static BookEvent getRandomBookEvent() {
        BookEvent event = new BookEvent();
        event.setBook(getRandomBook());
        event.setOperation(OperationType.ADD);
        event.setIdBookEvent(UUID.randomUUID().toString().substring(0,10));
        return event;
    }
}
