package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class KafkaProducerBootApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(KafkaProducerBootApplication.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(ProducerConfiguration.class);
		ConsoleProducer consoleProducer = context.getBean(ConsoleProducer.class);
		consoleProducer.runProducer();
	}

}

