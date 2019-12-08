package com.maddy.springbootkafkadec2019.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.maddy.springbootkafkadec2019.kafkaproducer.entity.FoodOrder;
import com.maddy.springbootkafkadec2019.kafkaproducer.producer.FoodOrderProducer;

@SpringBootApplication
//@EnableScheduling
public class KafkaproducerApplication implements CommandLineRunner{
	
	@Autowired
	private FoodOrderProducer producer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaproducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		FoodOrder chickenOrder = new FoodOrder(3, "chicken");
		FoodOrder fishOrder = new FoodOrder(10, "fish");
		FoodOrder pizzaOrder = new FoodOrder(5, "pizza");
		
		producer.sendFoodOrder(chickenOrder);
		producer.sendFoodOrder(fishOrder);
		producer.sendFoodOrder(pizzaOrder);
		
	}

}
