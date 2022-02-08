package com.fkog.interviewPrep.swap2Strings;

public class SwapString {
	public static void main(String[] args) {
		String a = "abcd";
		String b = "xyz";
		a = a + b;
		b = a.substring(0,a.length()-b.length());
		a = a.substring(b.length());
		
		System.out.println(a);
		System.out.println(b);
	}
}
