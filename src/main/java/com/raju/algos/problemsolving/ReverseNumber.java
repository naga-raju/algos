package com.raju.algos.problemsolving;

public class ReverseNumber {

	public static void main(String args[]) {
		///int num = 1234;
		
		System.out.println("Reverse of string abcd is: " + reverseString("abcd"));
		swapNumbers(10, 20);
		printFibonacci(10);
		printArmstrongNumbers(999);
	}
	
	private static String reverseString(String str) {
		if (str.length() <= 1) {
			return str;
		}
		return str.charAt(str.length() - 1) + 
				reverseString(str.substring(0, str.length() - 1));
	}
	
	private static void swapNumbers(int a, int b) {
		a = a+b;
		b = a-b;
		a = a-b;
		System.out.println("a: " + a + " b: " + b);
	}
	
	private static void printFibonacci(int a) {
		System.out.print("0");
		if (a == 0) {
			return;
		}
		System.out.print(" 1");
		if (a == 1) {
			return;
		}
		int n0 = 0;
		int n1 = 1;
		
		for (int i=2; i<=a; i++) {
			int n2 = n0+n1;
			System.out.print(" " + n2);
			n0 = n1;
			n1 = n2;
		}
	}
	
	/*
	 * An Armstrong number of three digits is an integer such that the sum of the 
	 * cubes of its digits is equal to the number itself. 
	 * For example, 371 is an Armstrong number since 3**3 + 7**3 + 1**3 = 371.
	 */
	private static void printArmstrongNumbers(int a) {
		System.out.println();
		for (int i=0; i<=a; i++) {
			int temp = i;
			double sum = 0;
			while (temp != 0) {
				sum = sum + (Math.pow(temp%10, 3));
				temp = temp/10;
			}
			if (sum == i) {
				System.out.print(i + " ");
			}
		}
	}
}
