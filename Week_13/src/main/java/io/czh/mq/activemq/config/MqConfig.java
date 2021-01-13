package io.czh.mq.activemq.config;

import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.czh.activemq.service.MqConsumeQueue;
import io.czh.activemq.service.MqConsumeTopic;
import io.czh.activemq.service.MqMessageListener;
import io.czh.activemq.service.MqProducer;
import io.czh.activemq.demo.MqDemo;


@Configuration
public class MqConfig {
	    
    @Bean(name = "session")
    public Session session() throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        ActiveMQConnection activeMQConnection = (ActiveMQConnection) factory.createConnection();
    	activeMQConnection.start();
    	Session session = activeMQConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    	return session;

    }
    
    @Bean(name = "topic")
    public Topic topic(){

    	return new ActiveMQTopic("test.topic");
    }
    
    
    @Bean(name = "queue")
    public Queue queue() {
        return new ActiveMQQueue("test.queue");
    }
	
    
    @Bean(name = "mqListener")
    public MessageListener listener() {
    	 return new MqMessageListener(topic());
    }
    
    @Bean(name = "topicConsumer")
    public MessageConsumer topicConsumer() throws JMSException {
    	return session().createConsumer(topic());
    }
    
    @Bean(name = "queueConsumer")
    public MessageConsumer queueConsumer() throws JMSException {
    	return session().createConsumer(queue());
    }
    
    @Bean(name = "mqConsumeQueue")
    public MqConsumeQueue mqConsumeQueue() throws JMSException {
    	return new MqConsumeQueue(queueConsumer());
    }
    
    @Bean(name = "mqConsumeTopic")
    public MqConsumeTopic mqConsumeTopic() throws JMSException {
    	return new MqConsumeTopic(listener(),topicConsumer());
    }
    
    @Bean(name = "mqProducerTopic")
    public MqProducer mqProducerTopic() throws JMSException {
    	return new MqProducer(topic(),session());
    }
    
    @Bean(name = "mqProducerQueue")
    public MqProducer mqProducerQueue() throws JMSException {
    	return new MqProducer(queue(),session());
    }
    
    @Bean(name = "mqDemo")
    public MqDemo MqDemo() throws JMSException {
    	return new MqDemo(mqConsumeQueue(),mqConsumeTopic(),mqProducerTopic(),mqProducerQueue());
    }
    
    
    
    
}
