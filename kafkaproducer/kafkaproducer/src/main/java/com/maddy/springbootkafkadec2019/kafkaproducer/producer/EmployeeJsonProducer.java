package com.maddy.springbootkafkadec2019.kafkaproducer.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maddy.springbootkafkadec2019.kafkaproducer.entity.Employee;

@Service
public class EmployeeJsonProducer {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private ObjectMapper obj = new ObjectMapper();
	
	private static final String TOPICS = "employee_json_topic_2";
	
	public void sendEmployeeJson(Employee emp) throws JsonProcessingException {
		String empJson = obj.writeValueAsString(emp);
		kafkaTemplate.send(TOPICS,empJson);
	}

}
