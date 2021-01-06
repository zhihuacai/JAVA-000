package io.czh.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class Counter {
	 @Autowired
	 private StringRedisTemplate redisTemplate;
	 private String key;
	 
	 public Counter(String key) {
		 this.key = key;
	 }
	 
	 public Long increase(int delta) {
		 return redisTemplate.opsForValue().increment(key, delta);
		 }
	 
	 public Long decrease(int delta) { 
		 return redisTemplate.opsForValue().increment(key, (-1)*delta); 
		 }
}
