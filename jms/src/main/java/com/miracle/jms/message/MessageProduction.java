package com.miracle.jms.message;



import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;



@EnableJms
public class MessageProduction {
	{
		final String MASSAGE_QUEUE="message_queue";
		
		ConfigurableApplicationContext context = null;
		JmsTemplate jmsTemplate=context.getBean(JmsTemplate.class);
		
		for(int i=0;i<10;i++)
		{
			ProductDetails details=new ProductDetails(i, i, MASSAGE_QUEUE);
			details.setProduct_id(i);
			details.setProduct_name("mobile");
			details.setProduct_price(1000+i);
			
			System.out.println("sending a product"+i);
			jmsTemplate.convertAndSend(MASSAGE_QUEUE,details);
		}
		
	}
}
