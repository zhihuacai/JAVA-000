package io.czh.activemq.demo;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;

import io.czh.activemq.service.MqConsumer;
import io.czh.activemq.service.MqProducer;

public class MqDemo {
	@Autowired
	private  MqConsumer mqConsumeQueue; 
	private  MqConsumer mqConsumeTopic; 
	private  MqProducer mqProducerTopic; 
	private  MqProducer mqProducerQueue; 
	
	public MqDemo(MqConsumer mqConsumeQueue,MqConsumer mqConsumeTopic,MqProducer mqProducerTopic,MqProducer mqProducerQueue) {
		this.mqConsumeQueue = mqConsumeQueue;
		this.mqConsumeTopic = mqConsumeTopic; 
		this.mqProducerTopic = mqProducerTopic; 
		this.mqProducerQueue = mqProducerQueue;
	}
	
    public static void main(String[] args) {
    	mqProducerQueue.sendMessage();
    	mqConsumeQueue.consumeMessage();
    	//mqConsumeTopic.consumeMessage();
    }

}
