package com.czh.springboot.multiple.source;

import java.util.concurrent.atomic.AtomicInteger;

public class DBContextHolder {
	
	private static final ThreadLocal <DataSourceType> CONTEXT_HOLDER = new ThreadLocal();
	private static final AtomicInteger COUNTER = new AtomicInteger(0);
	
	public static void set(DataSourceType dsType) {
		CONTEXT_HOLDER.set(dsType);
	}
	
	public static DataSourceType get() {
		return CONTEXT_HOLDER.get();
	}
	
	
	public static void master() {
		set(DataSourceType.MASTER);
	}
	
	public static void slave() {
		int index = COUNTER.getAndIncrement() %(DataSourceType.values().length - 1);
		if (COUNTER.get() > 999) {
			COUNTER.set(0);
		}
		set(DataSourceType.values()[index+1]);
		
		
	}
	

}
