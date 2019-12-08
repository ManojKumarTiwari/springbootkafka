package com.maddy.springbootkafkadec2019.kafkaconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maddy.springbootkafkadec2019.kafkaconsumer.entity.FoodOrder;

@Service
public class FoodOrderConsumer {
	
	private static final String TOPICS = "food_order_topic";
	
	private static final Logger log = LoggerFactory.getLogger(FoodOrderConsumer.class);
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	private static final int MAX_AMOUNT = 7;
	
	@KafkaListener(topics = TOPICS, errorHandler = "myFoodOrderErrorHandler")
	public void consumeMessage(String message) throws JsonMappingException, JsonProcessingException {
		FoodOrder foodOrder = objectMapper.readValue(message, FoodOrder.class);
		
		if(foodOrder.getAmount() > MAX_AMOUNT) {
			throw new IllegalArgumentException("Food order amount is too many");
		}
		
		log.info("Food order valid: {}", foodOrder);
	}

}
