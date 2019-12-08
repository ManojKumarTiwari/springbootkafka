package com.maddy.springbootkafkadec2019.kafkaproducer.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class FixedRateProducer {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private int count = 0;
	
	private static final Logger log = LoggerFactory.getLogger(FixedRateProducer.class);
	
	private static final String TOPICS = "fixed_rate_topic_2";
	
	//@Scheduled(fixedRate = 1000)
	public void sendFixedRate() {
		count++;
		log.info("count is {}",count);
		kafkaTemplate.send(TOPICS,"Fixed Rate" + count);
	}

}
