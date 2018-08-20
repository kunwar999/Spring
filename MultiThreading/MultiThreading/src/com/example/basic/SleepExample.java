package com.example.basic;

public class SleepExample {
	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(new ThreadExample());
		t1.start();
		Thread t2 = new Thread(new ThreadExample());
		t2.start();
	}
}

class ThreadExample implements Runnable {

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			System.out.println("Hello " + i);
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
