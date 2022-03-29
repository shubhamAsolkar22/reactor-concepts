package com.fkog.stackOverflow;

import java.util.Optional;

public class Question1 {
	public static void main(String args[]) {
		String sNull = null;
		Optional<String> sOptional = Optional.empty();
		
		System.out.println(sOptional.orElse("RRRR"));
	}
}
