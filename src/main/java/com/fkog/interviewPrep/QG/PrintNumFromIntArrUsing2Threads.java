package com.fkog.interviewPrep.QG;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintNumFromIntArrUsing2Threads {
	private final int a[] = new int[] { 1, 2, 3 };
	
	private int index = 0;
	public static void main(String[] args) {
		PrintNumFromIntArrUsing2Threads obj = new PrintNumFromIntArrUsing2Threads();
		
		Runnable r = () -> {
			while(obj.hasNext()) {
				obj.printNext();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread t1 = new Thread(r);
		
		Thread t2 = new Thread(r);
		
		t2.start();
		t1.start();
	}

	private synchronized void printNext() {
		System.out.println(a[index]+" from thread "+Thread.currentThread().getName());
		index++;
	}
	
	private synchronized boolean hasNext() {
		return index<a.length;
	}
}
