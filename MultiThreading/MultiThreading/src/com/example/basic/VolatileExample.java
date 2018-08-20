package com.example.basic;

import java.util.Scanner;

public class VolatileExample {
	public static void main(String[] args) throws InterruptedException {

		Runner example = new Runner();
		Thread t1 = new Thread(example);
		t1.start();
		System.out.println("Press any key to stop");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		example.shutDown();
	}
}

class Runner implements Runnable {

	volatile boolean running = true;

	@Override
	public void run() {

		while (running) {
			System.out.println("Hello ");
		}

	}

	public void shutDown() {
		running = false;
	}
}
