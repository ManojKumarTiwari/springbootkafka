package com.maddy.springbootkafkadec2019.kafkaconsumer.config;

import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.adapter.RecordFilterStrategy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maddy.springbootkafkadec2019.kafkaconsumer.entity.CarLocation;

@Configuration
public class KafkaConfig {
	
	@Autowired
	private KafkaProperties kafkaProperties;
	
	@Bean
	public ConsumerFactory<Object, Object> consumerFactory(){
		Map<String, Object> config = kafkaProperties.buildConsumerProperties();
		
		return new DefaultKafkaConsumerFactory<Object, Object>(config);
	}
	
	@Bean(name="farLocationContainerFactory")
	public ConcurrentKafkaListenerContainerFactory<Object, Object> farLocationContainerFactory(
			ConcurrentKafkaListenerContainerFactoryConfigurer configurer){
		ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<Object, Object>();
		configurer.configure(factory, consumerFactory());
		
		factory.setRecordFilterStrategy(new RecordFilterStrategy<Object, Object>() {
			
			ObjectMapper objectMapper = new ObjectMapper();

			@Override
			public boolean filter(ConsumerRecord<Object, Object> consumerRecord) {
				try {
					CarLocation carLocation = objectMapper.readValue(consumerRecord.value().toString(), CarLocation.class);
					
					return carLocation.getDistance() <= 100;
					
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
				
			}
		});
		
		return factory;
		
	}

}
