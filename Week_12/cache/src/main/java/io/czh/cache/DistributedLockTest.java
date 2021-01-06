package io.czh.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DistributedLockTest {
	private final static String LOCK_ID = "happyjava";​
	@Autowired
	DistributedLock distributedLock;
	@Scheduled(cron = "0/10 * * * * ? ")
	public void doSomething() {
		boolean lock = distributedLock.getLock(LOCK_ID, 10 * 1000);
		if (lock) {
			System.out.println("执行任务");
			distributedLock.releaseLock(LOCK_ID);
		} else {
			System.out.println("没有抢到锁");
		}
	}
}