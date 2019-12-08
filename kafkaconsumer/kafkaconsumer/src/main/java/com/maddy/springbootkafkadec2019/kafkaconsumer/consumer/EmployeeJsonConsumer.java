package com.maddy.springbootkafkadec2019.kafkaconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maddy.springbootkafkadec2019.kafkaconsumer.entity.Employee;

@Service
public class EmployeeJsonConsumer {
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	private Logger log = LoggerFactory.getLogger(EmployeeJsonConsumer.class);
	
	private static final String TOPICS = "employee_json_topic_2";
	
	@KafkaListener(topics = TOPICS)
	public void consumeEmployeeJson(String message) throws JsonMappingException, JsonProcessingException {
		Employee emp = objectMapper.readValue(message, Employee.class);
		log.info("Employee is {}",emp);
	}

}
