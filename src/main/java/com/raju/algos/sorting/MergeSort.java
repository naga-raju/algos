package com.raju.algos.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
	
	public List<Integer> mergeSort(List<Integer> numbers) {
		if (null == numbers || numbers.size() <= 1) {
			return numbers;
		}
		List<Integer> leftHalf = mergeSort(numbers.subList(0, (numbers.size()/2)));
		List<Integer> rightHalf = mergeSort(numbers.subList((numbers.size()/2), numbers.size()));
		
		int i = 0,j = 0;
		List<Integer> sortedList = new ArrayList<Integer>();
		while ((i <= (leftHalf.size() - 1)) && (j <= (rightHalf.size()) - 1)) {
			if (leftHalf.get(i) < rightHalf.get(j)) {
				sortedList.add(leftHalf.get(i++));
			} else {
				sortedList.add(rightHalf.get(j++));
			}
		}
		for (; i< leftHalf.size(); i++) {
			sortedList.add(leftHalf.get(i));
		}
		for (; j< rightHalf.size(); j++) {
			sortedList.add(rightHalf.get(j));
		}
		return sortedList;
	}
	
	public static void main (String args[]) {
		MergeSort ms = new MergeSort();
		List<Integer> list = new ArrayList<Integer>();
		list.add(20);
		list.add(10);
		list.add(50);
		list.add(2);
		list.add(200);
		List<Integer> sortedList = ms.mergeSort(list);
		for (Integer num : sortedList) {
			System.out.println(num);
		}
	}
}
