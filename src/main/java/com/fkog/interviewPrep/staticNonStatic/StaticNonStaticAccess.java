package com.fkog.interviewPrep.staticNonStatic;

public class StaticNonStaticAccess {
	private String s;
	
	public static void main(String[] args) {
		StaticNonStaticAccess snsa = new StaticNonStaticAccess();
		System.out.println(snsa.s);
		throw new IllegalArgumentException();
	}
}
