package com.example.basic;

public class SynchronizeExample {

	private volatile int count = 0;

	public synchronized void increment() {
		count++;
	}

	public static void main(String[] args) {
		SynchronizeExample example = new SynchronizeExample();
		try {
			example.doWork();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doWork() throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}

			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}

			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println("Count is =" + count);
	}
}
