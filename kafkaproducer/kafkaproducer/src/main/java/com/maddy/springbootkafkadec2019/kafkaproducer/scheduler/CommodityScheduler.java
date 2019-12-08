package com.maddy.springbootkafkadec2019.kafkaproducer.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.maddy.springbootkafkadec2019.kafkaproducer.entity.Commodity;
import com.maddy.springbootkafkadec2019.kafkaproducer.producer.CommodityJsonProducer;

@Service
public class CommodityScheduler {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	private CommodityJsonProducer producer;
	
	@Scheduled(fixedRate = 5000)
	public void fetchCommodities() {
		List<Commodity> commodities = restTemplate.exchange("http://localhost:8091/api/commodity/v1/all", 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Commodity>>() {
		}).getBody();
		
		commodities.forEach(c -> {
			try {
				producer.sendCommodityJson(c);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

}
