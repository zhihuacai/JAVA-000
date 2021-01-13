package io.czh.activemq.service;

import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;

public class MqMessageListener implements MessageListener{
	@Autowired
	private Topic topic;
	public MqMessageListener(Topic topic) {
		this.topic = topic;
	}
	
	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
        try {
            // 打印所有的消息内容
            // Thread.sleep();
       	 final AtomicInteger count = new AtomicInteger(0);
            System.out.println(count.incrementAndGet() + " => receive from " + topic.toString() + ": " + message);
            // message.acknowledge(); // 前面所有未被确认的消息全部都确认。

        } catch (Exception e) {
            e.printStackTrace(); // 不要吞任何这里的异常，
        }
    }
	}
