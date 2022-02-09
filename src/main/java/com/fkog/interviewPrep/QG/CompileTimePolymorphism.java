package com.fkog.interviewPrep.QG;

public class CompileTimePolymorphism {

	private void print(String s){
		System.out.println("from String "+s);
	}
	
	private void print(int i){
		System.out.println("from int "+i);
	}
	
	public static void main(String[] args) {
		CompileTimePolymorphism obj = new CompileTimePolymorphism();
		obj.print(0);
		obj.print("0");
	}
}
