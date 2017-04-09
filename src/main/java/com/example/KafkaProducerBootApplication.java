package com.example;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

@SpringBootApplication
public class KafkaProducerBootApplication {

	private static Scanner in;
	private static final String topicName = "test15";
	private static MessageSender messageSender;


	public static void main(String[] args) throws Exception {
		SpringApplication.run(KafkaProducerBootApplication.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(ProducerConfiguration.class);
	//	messageSender = (MessageSender) context.getBean("messageSender");
	//	runProducer();
	}

//	private static void runProducer() throws IOException {
//		in = new Scanner(System.in);
//		System.out.println("Enter message(type exit to quit)");
//		String line = in.nextLine();
//		ObjectMapper objectMapper = new ObjectMapper();
//
//		while (!line.equals("exit")) {
//			line = in.nextLine();
//			if (line.equals("books")) {
//				IntStream.range(0,100000).forEach((i) -> {
//					try {
//						messageSender.send(objectMapper.writeValueAsString(BookGenerator.getRandomBook()), topicName);
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				});
//				IntStream.range(0,100000).forEach((i) -> {
//						messageSender.send("exit", topicName);
//				});
//			} else {
//				messageSender.send(line, topicName);
//			}
//		}
//	}
}

//TODO: 1. Make an model book
//TODO: 2. Object mapper
//TODO: 3. generate random data for producer
