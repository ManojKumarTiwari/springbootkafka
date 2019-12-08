package com.maddy.springbootkafkadec2019.kafkaproducer.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maddy.springbootkafkadec2019.kafkaproducer.entity.CarLocation;

@Service
public class CarLocationProducer {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private static final String TOPICS = "car_location_topic";
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public void sendMessage(CarLocation carLocation) throws JsonProcessingException {
		String json = objectMapper.writeValueAsString(carLocation);
		kafkaTemplate.send(TOPICS, carLocation.getCarId(),json);
	}

}
