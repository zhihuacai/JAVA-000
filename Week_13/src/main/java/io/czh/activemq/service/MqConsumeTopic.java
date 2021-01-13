package io.czh.activemq.service;


import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;

public class MqConsumeTopic implements MqConsumer{
	
	@Autowired
	private MessageListener mqListener;
	private MessageConsumer topicConsumer; 
	
	public MqConsumeTopic(MessageListener mqListener,MessageConsumer topicConsumer) {
		this.mqListener = mqListener; 
		this.topicConsumer = topicConsumer;
	}
	
	@Override 
	public void consumeMessage() {        
		try {
	        // 绑定消息监听器
			topicConsumer.setMessageListener(mqListener);
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	

}
