package io.czh.activemq.service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

public class MqProducer {
	@Autowired
	private Destination destination;
	private Session session; 
	
	public MqProducer(Destination destination,Session session) {
		this.destination = destination; 
		this.session = session;
	}
	
	public void sendMessage() {
        MessageProducer producer;
		try {
			producer = session.createProducer(destination);
	        int index = 0;
	        while (index++ < 100) {
	            TextMessage message = session.createTextMessage(index + " message.");
	            producer.send(message);
	        }
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	

}
