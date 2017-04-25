package com.example;

import com.example.event.BookEventSender;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

@SpringBootApplication
public class KafkaProducerBootApplication {

	private static Scanner in;

	private static final String otherTopic = "otherTopic";

	private static BookEventSender eventSender;

	private static MessageSender messageSender;


	public static void main(String[] args) throws Exception {
		SpringApplication.run(KafkaProducerBootApplication.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(ProducerConfiguration.class);
		messageSender = (MessageSender) context.getBean("messageSender");
		eventSender = (BookEventSender) context.getBean("bookEventSender");
		runProducer();
	}

	private static void runProducer() throws IOException {
		in = new Scanner(System.in);
		System.out.println("Enter message(type exit to quit)");
		String line = in.nextLine();

		while (!line.equals("exit")) {
			line = in.nextLine();
			if (line.equals("randomBooks")) {
				IntStream.range(0,1000).forEach((i) -> {
					try {
						eventSender.sendRandomBookEvent();
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

