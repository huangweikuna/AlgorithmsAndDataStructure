package jianzhiOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
	如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
	如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
	我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class offer26 {
	PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	});
	PriorityQueue<Integer> min = new PriorityQueue<>();
	public void Insert(Integer num) {
		//维护最大堆和最小堆  使得最小堆的值大于最大堆
		if(max.isEmpty() || num <= max.peek())max.add(num);
		else min.add(num);
		if(max.size()  == min.size() + 2) {
			min.add(max.poll());
		}
		if(max.size() + 1 == min.size()) {
			max.add(min.poll());
		}
		
	}
	public Double GetMedian() {
		return max.size() == min.size() ? (max.peek() + min.peek()) / 2.0 : max.peek() * 1.0;
	}
	public static void main(String[] args) {
		offer26 a = new offer26();
		a.Insert(5);
		System.out.println(a.GetMedian());
		a.Insert(2);
		System.out.println(a.GetMedian());
		a.Insert(3);
		System.out.println(a.GetMedian());
		a.Insert(4);
		System.out.println(a.GetMedian());
		a.Insert(1);
		System.out.println(a.GetMedian());
		a.Insert(6);
		System.out.println(a.GetMedian());
		a.Insert(7);
		System.out.println(a.GetMedian());
		a.Insert(0);
		System.out.println(a.GetMedian());
		a.Insert(8);
		System.out.println(a.GetMedian());
		
	}
}