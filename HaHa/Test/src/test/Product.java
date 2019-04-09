package test;

import java.util.ArrayList;

class Product2 {
	ArrayList<Integer> product = new ArrayList<>();
	public final int MAX_NUM = 10;

	public void make() {
		while (true) {
			synchronized(product) {
				while (product.size() == MAX_NUM) {
					product.notifyAll();
					try {
						product.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				product.add(product.size() + 1);
				System.out.println("make " + (product.size()));
				product.notifyAll();
			}
		}
	}

	public  void get() {
		while (true) {
			synchronized(product) {
				while (product.size() == 0) {
					product.notifyAll();
					try {
						product.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				product.remove(product.size() - 1);
				System.out.println("get " + (product.size()));
				product.notifyAll();
			}
		}
	}
}
class Producer implements Runnable{
	Product2 pro ;
	public Producer(Product2 pro) {
		this.pro = pro;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		pro.make();
	}
}
class Consumer implements Runnable{
	Product2 pro ;
	public Consumer(Product2 pro) {
		this.pro = pro;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		pro.get();
	}
}
public class Product {
	public static void main(String[] args) {
		Product2 p = new Product2();
		Consumer t1 = new Consumer(p);
		Producer t2 = new Producer(p);
		new Thread(t1).start();
		new Thread(t1).start();
		new Thread(t1).start();
		new Thread(t1).start();
		new Thread(t2).start();
		new Thread(t2).start();
		new Thread(t2).start();
		new Thread(t2).start();
		new Thread(t2).start();
	}
}
