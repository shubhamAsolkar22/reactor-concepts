package com.fkog.interviewPrep.neilsenIQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class NielsenIQ {

	static int getAmplitude(List<Integer> l) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (Integer i: l)
	    {
	        if (min > i) {
	            min = i;
	        }
	        if (max < i) {
	            max = i;
	        }
	    }
		return max - min;
	}

	public static void findCombinations(int[] A, int i, int k, Set<List<Integer>> subarrays, List<Integer> out) {
		if (A.length == 0 || k > A.length) {
			return;
		}

		if (k == 0) {
			subarrays.add(new ArrayList<>(out));
			return;
		}

		for (int j = i; j < A.length; j++) {
			out.add(A[j]);
			findCombinations(A, j + 1, k - 1, subarrays, out);
			out.remove(out.size() - 1); // backtrack
		}
	}

	public static Set<List<Integer>> findCombinations(int[] A, int k) {
		Set<List<Integer>> subarrays = new HashSet<>();
		findCombinations(A, 0, k, subarrays, new ArrayList<>());
		return subarrays;
	}

	public static void main(String[] args) {
		int[] A = { 1, 1, 2, 3 };
		List<Integer> A_ = Arrays.stream(A).boxed().collect(Collectors.toList());
		int k = 2;

		Set<List<Integer>> combinations = findCombinations(A, k);
		
		int minAmplitude = Integer.MAX_VALUE;
		List<Integer> combinationWithMinAmplitude = Collections.EMPTY_LIST;
		
		for (List<Integer> combination : combinations) {
			List<Integer> remainingList = new ArrayList<>(A_);
			combination.forEach(e -> remainingList.remove(e));
			int amplitude = getAmplitude(remainingList);
			System.err.println("combination:"+combination);
			System.err.println("remaining:"+remainingList);
			System.err.println("amplitude:"+amplitude);
			if (amplitude < minAmplitude) {
				minAmplitude = amplitude;
				combinationWithMinAmplitude = combination;
			}
		}

		System.out.println(combinationWithMinAmplitude + " Must be removed to get minimum amplitude of "+minAmplitude);
	}


}