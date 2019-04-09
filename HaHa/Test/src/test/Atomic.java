package test;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {
	 private AtomicInteger counter = new AtomicInteger(0);

	    public void increase() {    //�ۼӲ���
	        while (true) {
	            int cur = counter.get();
	            if (counter.compareAndSet(cur, cur+1)) {    //�Ƚϲ����������ʧ������������
	                break;
	            }
	        }
	    }

	    public int getCounter() {
	        return counter.get();
	    }

	    public static void main(String[] args) throws Exception{
	    	Atomic increment = new Atomic();

	        for (int i = 0;i < 2; i++) {   //����20���߳�
	            Thread t = new Thread(new Runnable() {
	                @Override
	                public void run() {
	                    for (int i = 0; i < 100000; i++) {   //�ۼ�100000��
	                        increment.increase();
	                    }
	                }
	            });
	            t.start();
	            t.join();
	        }
	        System.out.println("20���̣߳�ÿ���߳��ۼ�100000�ε�ִ�н���ǣ�" + increment.getCounter());
	    }
}
