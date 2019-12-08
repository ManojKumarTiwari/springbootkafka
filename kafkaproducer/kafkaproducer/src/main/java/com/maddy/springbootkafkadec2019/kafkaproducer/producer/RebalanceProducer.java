package com.maddy.springbootkafkadec2019.kafkaproducer.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class RebalanceProducer {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private Logger log = LoggerFactory.getLogger(RebalanceProducer.class);
	
	private static final String TOPICS = "rebalance_topic";
	
	private int i = 0;
	
	@Scheduled(fixedRate = 1000)
	public void sendMessage() {
		i++;
		kafkaTemplate.send(TOPICS,"Counter is" + i);
		log.info("Message sent {}",i);
	}

}
