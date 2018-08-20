package com.example.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SynchronizeBlockExample {

	static Object lock1 = new Object();
	static Object lock2 = new Object();

	static Random random = new Random();
	private static List<Integer> list1 = new ArrayList<Integer>();
	private static List<Integer> list2 = new ArrayList<Integer>();

	public static void stageOne() {
		synchronized (lock1) {

			list1.add(random.nextInt());
		}
	}

	public static void stageTwo() {
		synchronized (lock2) {
			list2.add(random.nextInt());
		}
	}

	public static void process() {
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}

	public static void main(String[] args) {
		System.out.println("Starting....");
		long start = System.currentTimeMillis();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				process();

			}

		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				process();

			}

		});

		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("time taken=" + (end - start));
		System.out.println("List1 Size=" + list1.size());
		System.out.println("List2 Size=" + list2.size());

	}
}
