package com.maddy.springbootkafkadec2019.kafkaproducer.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.maddy.springbootkafkadec2019.kafkaproducer.entity.CarLocation;
import com.maddy.springbootkafkadec2019.kafkaproducer.producer.CarLocationProducer;

@Service
public class CarLocationScheduler {
	
	private static final Logger log = LoggerFactory.getLogger(CarLocationScheduler.class);
	
	@Autowired
	private CarLocationProducer producer;
	
	private CarLocation carOne;
	private CarLocation carTwo;
	private CarLocation carThree;
	
	public CarLocationScheduler() {
		
		long now = System.currentTimeMillis();
		
		carOne = new CarLocation("car-one", now, 0);
		carTwo = new CarLocation("car-two", now, 110);
		carThree = new CarLocation("car-three", now, 95);
	}
	
	//@Scheduled(fixedRate = 10000)
	public void generateCarLocation() {
		
		long now = System.currentTimeMillis();
		
		carOne.setTimestamp(now);
		carTwo.setTimestamp(now);
		carThree.setTimestamp(now);
		
		carOne.setDistance(carOne.getDistance() + 1);
		carTwo.setDistance(carTwo.getDistance() - 1);
		carThree.setDistance(carThree.getDistance() + 1);
		
		try {
			producer.sendMessage(carOne);
			log.info("Sent: {}", carOne);
			
			producer.sendMessage(carTwo);
			log.info("Sent: {}", carTwo);
			
			producer.sendMessage(carThree);
			log.info("Sent: {}", carThree);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn("Error happened: {}", e);
		}
		
		
	}

}
