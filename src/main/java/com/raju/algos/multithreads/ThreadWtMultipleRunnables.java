package com.raju.algos.multithreads;

public class ThreadWtMultipleRunnables {

	public static void main(String args[]) {
		
		Thread t = new Thread(new Delegatee()) {
			public void run() {
				System.out.println("Native thread!");
			}
		};
		t.start();//Comment
	}
	
	private static class Delegatee implements Runnable {
		@Override
		public void run() {
			System.out.println("Delegatee Thread!");
		}
	}
}
