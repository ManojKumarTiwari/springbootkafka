package com.maddy.springbootkafkadec2019.kafkaconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//@Service
public class FixedRateConsumer {
	
	private static final Logger log = LoggerFactory.getLogger(FixedRateConsumer.class);
	
	private static final String TOPICS = "fixed_rate_topic_2";
	
	@KafkaListener(topics = TOPICS)
	public void consumeFixedRate(String fixedrate) {
		log.info("Consumed {}", fixedrate);
	}

}
