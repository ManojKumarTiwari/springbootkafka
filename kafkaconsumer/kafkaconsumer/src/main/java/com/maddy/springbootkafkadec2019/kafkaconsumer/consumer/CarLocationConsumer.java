package com.maddy.springbootkafkadec2019.kafkaconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maddy.springbootkafkadec2019.kafkaconsumer.entity.CarLocation;

//@Service
public class CarLocationConsumer {
	
	private static final Logger log = LoggerFactory.getLogger(CarLocation.class);
	
	private static final String TOPICS = "car_location_topic";
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@KafkaListener(topics = TOPICS, groupId = "cg-listen-all")
	public void listenAll(String message) throws JsonMappingException, JsonProcessingException {
		CarLocation json = objectMapper.readValue(message, CarLocation.class);
		log.info("Listen all {}",json);
		
	}
	
	@KafkaListener(topics = TOPICS, groupId = "cg-listen-far", containerFactory = "farLocationContainerFactory")
	public void listenFar(String message) throws JsonMappingException, JsonProcessingException {
		CarLocation json = objectMapper.readValue(message, CarLocation.class);
		log.info("Listen far {}",json);
		
	}

}
