package com.maddy.springbootkafkadec2019.kafkaconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maddy.springbootkafkadec2019.kafkaconsumer.entity.Commodity;

//@Service
public class CommodityNotificationConsumer {
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	private Logger log = LoggerFactory.getLogger(CommodityNotificationConsumer.class);
	
	private static final String TOPICS = "commodity_topic";
	
	@KafkaListener(topics = TOPICS, groupId = "cg-notification")
	public void consume(String message) throws JsonMappingException, JsonProcessingException {
		Commodity commodity = objectMapper.readValue(message, Commodity.class);
		log.info("Notification info {}",commodity);
	}

}
