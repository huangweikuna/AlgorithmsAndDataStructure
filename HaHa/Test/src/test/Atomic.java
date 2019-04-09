package test;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {
	 private AtomicInteger counter = new AtomicInteger(0);

	    public void increase() {    //累加操作
	        while (true) {
	            int cur = counter.get();
	            if (counter.compareAndSet(cur, cur+1)) {    //比较并交换，如果失败则立即重试
	                break;
	            }
	        }
	    }

	    public int getCounter() {
	        return counter.get();
	    }

	    public static void main(String[] args) throws Exception{
	    	Atomic increment = new Atomic();

	        for (int i = 0;i < 2; i++) {   //创建20个线程
	            Thread t = new Thread(new Runnable() {
	                @Override
	                public void run() {
	                    for (int i = 0; i < 100000; i++) {   //累加100000次
	                        increment.increase();
	                    }
	                }
	            });
	            t.start();
	            t.join();
	        }
	        System.out.println("20个线程，每个线程累加100000次的执行结果是：" + increment.getCounter());
	    }
}
