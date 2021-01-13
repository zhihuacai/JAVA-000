package io.czh.activemq.service;


import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;

public class MqConsumeQueue implements MqConsumer{
	
	@Autowired
	private MessageConsumer queueConsumer; 
	
	public MqConsumeQueue(MessageConsumer queueConsumer) {
		this.queueConsumer = queueConsumer;
	}
	
	@Override 
	public void consumeMessage() {        
		try {
			queueConsumer.receive();
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	

}
