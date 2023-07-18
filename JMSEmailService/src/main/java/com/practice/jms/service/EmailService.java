package com.practice.jms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.practice.jms.pojo.Order;

@Service
public class EmailService {
	
	Logger logger = LoggerFactory.getLogger(EmailService.class);
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@JmsListener(destination = "OrderMessageQueue")
	public void messageListener(Order order) throws InterruptedException {
		
		Thread.sleep(1000);
		logger.info(String.format("recieved order notification: %s ", order));
		
	}

}
