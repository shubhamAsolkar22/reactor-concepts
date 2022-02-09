package com.fkog.interviewPrep.QG;

public class SingletonThreadSafe {

	private static SingletonThreadSafe INSTANCE = null;
	
	private SingletonThreadSafe() {

	}
	
	public synchronized static SingletonThreadSafe getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new SingletonThreadSafe(); 
		}
		
		return INSTANCE;
	}
	
}
