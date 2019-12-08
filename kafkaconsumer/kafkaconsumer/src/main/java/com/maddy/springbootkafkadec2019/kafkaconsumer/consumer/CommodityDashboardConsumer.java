package com.maddy.springbootkafkadec2019.kafkaconsumer.consumer;

import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maddy.springbootkafkadec2019.kafkaconsumer.entity.Commodity;

//@Service
public class CommodityDashboardConsumer {
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	private Logger log = LoggerFactory.getLogger(CommodityDashboardConsumer.class);
	
	private static final String TOPICS = "commodity_topic";
	
	@KafkaListener(topics = TOPICS, groupId = "cg-dashboard")
	public void consume(String message) throws JsonMappingException, JsonProcessingException, InterruptedException {
		Commodity commodity = objectMapper.readValue(message, Commodity.class);
		
		Thread.sleep(ThreadLocalRandom.current().nextLong(500,1000));
		
		log.info("Dashboard info {}",commodity);
	}

}
