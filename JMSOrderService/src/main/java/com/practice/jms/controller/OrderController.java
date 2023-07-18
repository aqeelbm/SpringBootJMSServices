package com.practice.jms.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.jms.pojo.Order;

@RestController
@RequestMapping("/order")
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	JmsTemplate jmsTemplate;

	Map<Integer, Order> orderMap = new HashMap<>();

	@GetMapping("/order")
	public void send() throws IOException, InterruptedException {
		logger.info("--- inside send()");

		orderGenerator();

		Random generator = new Random();
		Object[] values = orderMap.values().toArray();

		for(int i=0; i<orderMap.size()-1; i++) {

			Thread.sleep(2000);

			Order randomOrder = (Order) values[generator.nextInt(values.length)];

			logger.info("sending order data to queue.");
			
			jmsTemplate.convertAndSend("OrderMessageQueue", randomOrder);

		}

		logger.info("--- exiting from send()");
	}


	public void orderGenerator() {
		logger.info("--- inside orderGenerator()");

		orderMap.put(1, new Order(1, "iPhone 12", "Your order has been places."));
		orderMap.put(2, new Order(2, "Samsung Galaxry A32", "Your order in reday to deliver."));
		orderMap.put(3, new Order(3, "Huawei P60", "Your order in on the way for delivery."));
		orderMap.put(4, new Order(4, "Oppo Reno10 Pro", "Order delivered"));
		orderMap.put(5, new Order(5, "RealMe C53", "Your order is pending."));

		logger.info("--- exiting from orderGenerator()");
	}

}
