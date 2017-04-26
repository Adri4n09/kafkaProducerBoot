package com.example;


import com.example.event.BookEventSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

@Component
public class ConsoleProducer {

    @Value("${kafka.other.topic}")
    private String otherTopic;

    @Autowired
    private BookEventSender bookEventSender;

    @Autowired
    private MessageSender messageSender;

    public void runProducer() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter message(type exit to quit)");
        String line = in.nextLine();

        while (!line.equals("exit")) {
            line = in.nextLine();
            if (line.equals("randomBooks")) {
                IntStream.range(0,1000).forEach((i) -> {
                    try {
                        bookEventSender.sendRandomBookEvent();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } else {
                messageSender.send(line, otherTopic);
            }
        }
    }
}
