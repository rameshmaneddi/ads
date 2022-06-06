package com.miracle.jms.message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReciever 
{
	private static final String MESSAGE_QUEUE ="message_queue";
	
	@JmsListener(destination = MESSAGE_QUEUE)
	public void receiveMessage(ProductDetails details)
	{
		System.out.println("recieved"+details);
		
	}

}
