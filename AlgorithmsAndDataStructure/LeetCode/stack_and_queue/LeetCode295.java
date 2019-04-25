package stack_and_queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode295 {

	PriorityQueue<Integer> min;
	PriorityQueue<Integer> max;
	public LeetCode295() {
		min = new PriorityQueue<>();
		max = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});
	}

	public void addNum(int num) {
		if(max.isEmpty() || max.peek() > num)max.add(num);
		else min.add(num);
		if(max.size()  == min.size() + 2)min.add(max.poll());
		if(max.size() + 1 == min.size())max.add(min.poll());
	}

	public double findMedian() {
		return max.size() == min.size() ?  (double)(max.peek() + min.peek()) / 2.0 : max.peek() * 1.0;
	}
}
