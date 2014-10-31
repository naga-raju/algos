package com.raju.algos.problemsolving;

/**
 * Take in a array of numbers and print them in the form of an wave!
 *
 */
public class PrintWave {

	private static int[] waveArrange(int[] arr) {
		boolean incr = arr[0] < arr[1];
		
		for (int i=1; i<(arr.length - 1); i++) {
			if (arr[i] < arr[i+1] && incr) {
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			} else if (arr[i] > arr[i+1] && !incr) {
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
			incr = !incr;
		}
		return arr;
	}
	
	public static void main(String args[]) {
		int[] waveArr = waveArrange(new int[]{2,4,6,8,10,12});
		for (int num : waveArr) {
			System.out.print(num + "  ");
		}
		System.out.println();
		waveArr = waveArrange(new int[]{12,10,8,6,4,2});
		for (int num : waveArr) {
			System.out.print(num + "  ");
		}
	}
}
