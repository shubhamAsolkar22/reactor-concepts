package com.fkog.interviewPrep.charOccuranceAsc;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class CharOccuranceAscending {

	public static void main(String[] args) {
		HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();

		char[] strArray = "azzbbbb".toCharArray();

		for (char c : strArray) {
			if (charCountMap.containsKey(c)) {

				charCountMap.put(c, charCountMap.get(c) + 1);
			} else {

				charCountMap.put(c, 1);
			}
		}
		
		charCountMap.entrySet().stream().sorted((e1, e2) -> Integer.compare(e1.getValue(), e2.getValue()))
				.forEach(System.out::println);
	}
}
