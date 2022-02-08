package com.fkog.interviewPrep.multithreading;

class Hi implements Runnable {
	public void show() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Hi");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		show();
	}
}

class Hello implements Runnable {
	public void show() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Hello");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		show();
	}
}

public class A {
	public static void main(String[] args) throws InterruptedException {

		Runnable hi = new Hi();
		Runnable hello = new Hello();

		Thread t1 = new Thread(hi);
		Thread t2 = new Thread(hello);
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		t1.start();
		t2.start();
	}
}
