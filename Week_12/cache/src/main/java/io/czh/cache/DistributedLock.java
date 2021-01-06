package io.czh.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class DistributedLock {
	 @Autowired
	 private StringRedisTemplate redisTemplate;

	 public boolean getLock(String lockId, long millisecond) {
		 Boolean success = redisTemplate.opsForValue().setIfAbsent(lockId, "lock");
		 return success != null && success;
		 
		 }
	 
	 public void releaseLock(String lockId) {
		 redisTemplate.delete(lockId);
		 }
	 
	 
	

}
