package test;

import java.util.Scanner;

public class Main {
	static String str;

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		str = cin.nextLine();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				str += "_A";
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					t1.join();
					str += "_B";
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					t2.join();
					str += "_C";
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
		t3.start();
		try {
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(str);
	}
}
