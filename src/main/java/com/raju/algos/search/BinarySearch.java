package com.raju.algos.search;

public class BinarySearch {

	public int search(int[] data, int patt) {
		if (null == data || data.length == 0) {
			return -1;
		}

		int start = 0;
		int end = data.length - 1;
		
		while (end >= start) {
			int mid = (start+end)/2;
			if (data[mid] == patt) {
				return mid;
			} else if (data[mid] > patt) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String args[]) {
		System.out.println("Sample data:");
		System.out.println("Data : 1,4,10,25,32,64,190");
		System.out.println("Pattern : 190");
		
		BinarySearch bs = new BinarySearch();
		int index = bs.search(new int[]{1,4,10,25,32,64,190}, 190);
		System.out.println("Pattern found at: " + index);
	}
}
