package com.backbone.kafkaInteractions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class KafkaInteractionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaInteractionsApplication.class, args);
	}

}
