package com.example.app;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyConsumer {
	@RabbitListener(queues="${pet.rabbitmq.queue}")
	public void catchMessage(String msg) {
		System.out.println("We've done it: "+msg);
	}
}
