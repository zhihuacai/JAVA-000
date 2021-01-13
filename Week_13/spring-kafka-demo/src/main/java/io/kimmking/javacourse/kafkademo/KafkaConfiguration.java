package io.kimmking.javacourse.kafkademo;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfiguration {
	
    @Bean
    public NewTopic initialTopic() {
        return new NewTopic("testtopic",8, (short) 1);
    }
    
    @Bean
    public NewTopic updateTopic() {
        return new NewTopic("testtopic",10, (short) 1);
    }
	
    
    
    
}
