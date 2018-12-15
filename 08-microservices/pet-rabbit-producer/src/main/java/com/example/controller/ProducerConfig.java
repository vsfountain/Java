package com.example.controller;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ProducerConfig {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Value("${pet.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${pet.rabbitmq.routingkey}")
	private String routingKey;
	
	@Value("${pet.rabbitmq.queue}")
	private String queueName;
	
	public void produceMsg(String msg) {
		rabbitTemplate.convertAndSend(exchange, routingKey, msg);
		System.out.println("Sending a message: "+msg);
	}
	
	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}
	
	@Bean
	TopicExchange exchange() {
		return new TopicExchange(exchange);
	}
	
	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(routingKey);
	}
}

