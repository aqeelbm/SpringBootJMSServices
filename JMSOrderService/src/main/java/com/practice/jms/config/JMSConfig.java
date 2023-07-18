package com.practice.jms.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
@EnableJms
public class JMSConfig {
	
	@Bean
	public JmsListenerContainerFactory<?> jmsfactory(
			ConnectionFactory conncetionFactory,
			DefaultJmsListenerContainerFactoryConfigurer configurer) {
		
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		
		configurer.configure(factory, conncetionFactory);
		
		return factory;
	}
	
	@Bean
	public CachingConnectionFactory connetionFactory() {
		CachingConnectionFactory factory = new CachingConnectionFactory();
		
		ActiveMQConnectionFactory activeMQFactory = new ActiveMQConnectionFactory();
		activeMQFactory.setBrokerURL("");
		factory.setTargetConnectionFactory(activeMQFactory);
		factory.setClientId("client123");
		return factory;
	}
	
	
	
	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.BYTES);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}
	
}
