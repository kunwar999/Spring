package com.example.basic;

import java.util.LinkedList;
import java.util.Random;

public class ProducerConsumerProblem {

	static ProducerConsumer producerConsumer = new ProducerConsumer();

	public static void main(String[] args) {
		try {
			Thread t1 = new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						producerConsumer.produce();
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
						producerConsumer.consume();
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

class ProducerConsumer {
	LinkedList<Integer> list = new LinkedList<Integer>();
	private final int LIMIT = 2;

	Object lock = new Object();

	public void produce() throws InterruptedException {
		Random r = new Random();
			while (true) {
				synchronized (lock) {
				if (list.size() == LIMIT) {
					lock.wait();
				}
				int val = r.nextInt(100);
				list.add(val);
				System.out.println("Produced:" + val);

				lock.notify();

			}

		}
	}

	public void consume() throws InterruptedException {

			while (true) {
			synchronized (lock) {
				if (list.size() == 0) {
					lock.wait();
				}

				int val = list.removeFirst();
				System.out.println("Consumed:" + val);
				lock.notify();

				Thread.sleep(1000);
			}
		}
	}
}
