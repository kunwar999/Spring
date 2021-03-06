package com.example.basic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountdownLatchesExample {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(3);
		ExecutorService executor = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 3; i++) {
			executor.submit(new Processor2(latch));
		}
		executor.shutdown();
		System.out.println("All task submitted");

		latch.await();
		System.out.println("All task Completed");

	}
}

class Processor2 implements Runnable {

	private CountDownLatch latch;

	public Processor2(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {

		System.out.println("Started");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();
	}

}
