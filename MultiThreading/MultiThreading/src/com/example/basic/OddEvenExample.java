package com.example.basic;

public class OddEvenExample {

	static OddEven oddEven = new OddEven();

	public static void main(String[] args) {
		try {
			Thread t1 = new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						oddEven.printEven();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			});
			Thread t2 = new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						oddEven.printOdd();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});

			t1.start();
			t2.start();

			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class OddEven {
	public void printEven() throws InterruptedException {
		int count = 0;
		synchronized (this) {

			while (count < 10) {
				if (count % 2 == 0) {
					Thread.sleep(2000);
					System.out.println("Even:" + count);
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					notify();
				}
				count++;
			}
		}
	}

	public void printOdd() throws InterruptedException {
		int count = 0;
		synchronized (this) {

			while (count < 10) {
				if (count % 2 != 0) {
					Thread.sleep(2000);
					System.out.println("Odd:" + count);
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					notify();
				}
				count++;
			}
		}
	}
}
