package com.fkog.interviewPrep.identifierEG;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "default")
@Scope("singleton")
public class HelloImpl1 implements Hello {
	private String  abc;
	
	@Override
	public void print() {
		System.err.println("default hello");
	}

	public String getAbc() {
		return abc;
	}

	public void setAbc(String abc) {
		this.abc = abc;
	}
	
	@Override
	public String toString() {
		return "<"+abc+">";
	}
}
