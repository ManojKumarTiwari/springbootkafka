package com.maddy.springbootkafkadec2019.kafkaproducer.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Service
@RestController
@RequestMapping("kafka")
public class StringKafkaProducer {
	
	private static final String TOPIC = "string_topic";
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@GetMapping("publish/{message}")
	public String sendString(@PathVariable("message") final String message) {
		kafkaTemplate.send(TOPIC,message);
		return "Publish Successfully";
	}

}
