package com.fkog.interviewPrep.QG;

import java.util.concurrent.atomic.AtomicBoolean;

/*Write a program for Creating the two threads. First Thread Contains Odd Array and Second Thread Contains Even Array.

and display the Thread OutPut = {1,2,3,4,,5,6,7,8} using Sychronization concept.*/
public class MergeEvenAndOddArray {
	private boolean oddTurn = true;
	private int e[] = new int[] { 2, 4, 6, 8 };
	private int o[] = new int[] { 1, 3, 5, 7 };

	private synchronized void printEven() {
		int c = 0;
		while (c < e.length) {
			while (oddTurn) {
				try {
					wait();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			System.out.println(e[c]);
			c++;
			oddTurn = true;
			notify();
		}
	}

	private synchronized void printOdd() {
		int c = 0;
		while (c < o.length) {
			while (!oddTurn) {
				try {
					wait();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			System.out.println(o[c]);
			c++;
			oddTurn = false;
			notify();
		}
	}

	public static void main(String[] args) {
		MergeEvenAndOddArray obj = new MergeEvenAndOddArray();

		Thread t1 = new Thread(() -> obj.printEven());

		Thread t2 = new Thread(() -> obj.printOdd());
		
		t1.start();
		t2.start();
	}
}