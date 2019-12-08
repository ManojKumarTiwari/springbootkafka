package com.maddy.springbootkafkadec2019.kafkaproducer.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maddy.springbootkafkadec2019.kafkaproducer.entity.Commodity;

@Service
public class CommodityJsonProducer {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private ObjectMapper obj = new ObjectMapper();
	
	private static final String TOPICS = "commodity_topic";
	
	public void sendCommodityJson(Commodity commodity) throws JsonProcessingException {
		String json = obj.writeValueAsString(commodity);
		kafkaTemplate.send(TOPICS,commodity.getName(),json);
	}

}
