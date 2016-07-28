package com.raju.algos.multithreads;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinExample extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 1L;
	private static final int threshold = 1000;
	private int limit;
	
	public ForkJoinExample(int limit) {
		this.limit = limit;
	}
	
	@Override
	protected Integer compute() {
		if (limit > threshold) {
			ForkJoinExample left = new ForkJoinExample(limit/2);
			ForkJoinExample right = new ForkJoinExample(limit/2);
			left.fork();
			int rightAns = right.compute();
			int leftAns = left.join();
			return rightAns + leftAns;
		} else {
			int sum = 0;
			for (int i=0; i<limit; i++) {
				sum += 1;
			}
			return sum;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Data: " + ForkJoinPool.commonPool().invoke(new ForkJoinExample(10000000)));
	}
}
