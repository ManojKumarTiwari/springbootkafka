package com.maddy.springbootkafkadec2019.kafkaconsumer.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//@Service
public class StringKafkaConsumer {
	
	private static final String TOPIC = "string_topic";
	
	@KafkaListener(topics = TOPIC)
	public void consumeString(String message) {
		System.out.println("Consumed Message:" + message);
	}

}
