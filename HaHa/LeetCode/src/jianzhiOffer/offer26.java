package jianzhiOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
	��εõ�һ���������е���λ����������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��
	������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
	����ʹ��Insert()������ȡ��������ʹ��GetMedian()������ȡ��ǰ��ȡ���ݵ���λ����
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
		//ά�����Ѻ���С��  ʹ����С�ѵ�ֵ��������
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