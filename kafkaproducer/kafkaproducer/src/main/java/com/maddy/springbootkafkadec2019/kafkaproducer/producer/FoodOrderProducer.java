package com.maddy.springbootkafkadec2019.kafkaproducer.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maddy.springbootkafkadec2019.kafkaproducer.entity.FoodOrder;

@Service
public class FoodOrderProducer {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	private static final String TOPICS = "food_order_topic";
	
	public void sendFoodOrder(FoodOrder foodOrder) throws JsonProcessingException {
		String json = objectMapper.writeValueAsString(foodOrder);
		kafkaTemplate.send(TOPICS, json);
	}

}
