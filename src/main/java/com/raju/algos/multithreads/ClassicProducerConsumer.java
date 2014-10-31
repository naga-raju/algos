package com.raju.algos.multithreads;

import java.util.LinkedList;
import java.util.List;

public class ClassicProducerConsumer {

	private static List<Integer> dataQueue = new LinkedList<Integer>();
	static int count = 1;
	static boolean condition = true;

	public static void main(String args[]) {

		//Consumer Thread!
		Thread consumerThread = new Consumer();
		consumerThread.start();

		//Producer Thread!
		synchronized(dataQueue) {
			while (condition) {
				while (dataQueue.size() >= 3) {
					try {
						System.out.println("Producer entering wait!");
						dataQueue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}  
				System.out.println("Produced: " + count);
				dataQueue.add(count++);
				dataQueue.notifyAll();
				if (count > 10) {
					condition = false;
				}
			}
		}
	}

	static class Consumer extends Thread {

		public void run() {
			synchronized(dataQueue) {
				while (condition) {
					while (dataQueue.isEmpty()) {
						try {
							System.out.println("Consumer entering wait!");
							dataQueue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} 
					System.out.println("Consumed: " + dataQueue.remove(0));
					dataQueue.notifyAll();
				}
			}
		}
	}
}
