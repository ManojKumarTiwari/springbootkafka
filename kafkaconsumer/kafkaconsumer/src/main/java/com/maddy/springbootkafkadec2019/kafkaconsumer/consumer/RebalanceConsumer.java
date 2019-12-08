package com.maddy.springbootkafkadec2019.kafkaconsumer.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//@Service
public class RebalanceConsumer {
	
	private static final String TOPICS = "rebalance_topic";
	
	private Logger log = LoggerFactory.getLogger(RebalanceConsumer.class);
	
	@KafkaListener(topics = TOPICS)
	public void consume(ConsumerRecord<String, String> message) {
		log.info("Partition: {}, Offset: {}, Message: {}", message.partition(),message.offset(),message.value());
	}

}
