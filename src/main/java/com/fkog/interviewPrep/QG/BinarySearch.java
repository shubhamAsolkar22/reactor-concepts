package com.fkog.interviewPrep.QG;

import java.util.Arrays;

public class BinarySearch {
	public static void main(String[] args) {
		int a[] = new int[] { 1, 2, 3, 4, 5 };
		int searchFor = 30;
//		binSearchItr(a, searchFor);
		System.out.println(binSearchRec(a, searchFor, 0, a.length-1));
	}

	static void binSearchItr(int a[], int searchFor) {
		Arrays.sort(a);

		int start = 0;
		int end = a.length - 1;
		int foundAt = -1;
		while (start <= end) {
			int mid = (end + start) / 2;
			if (a[mid] == searchFor) {
				foundAt = mid;
				break;
			} else if (a[mid] > searchFor) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}

		}

		if (foundAt != -1) {
			System.out.println(searchFor + " was found at index " + foundAt);
		} else {
			System.err.println(searchFor + " was not found.");
		}
	}

	static int binSearchRec(int a[], int searchFor, int start, int end) {
		if (start <= end) {
			int mid = (end + start) / 2;

			if (a[mid] == searchFor)
				return mid;
			if (a[mid] > searchFor)
				return binSearchRec(a, searchFor, start, mid - 1);
			if (a[mid] < searchFor)
				return binSearchRec(a, searchFor, mid + 1, end);
		}
		return -1;
	}
}
