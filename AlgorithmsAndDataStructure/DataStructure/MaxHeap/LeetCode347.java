package MaxHeap;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
//Given a non-empty array of integers, return the k most frequent elements.
//���س���������ߵ�ǰk����
/*
 *   ��Java�� PriorityQueue�����Ը���С�ѣ����Դ��ڶѶ�����Ԫ���е���Сֵ
 *   ���ǿ��԰�k��Ԫ�ط���PriorityQueue�У���Ԫ�س��ֵĴ����������������
 *   Ȼ��ÿ�ν�����Ԫ�ض��ͶѶ�Ԫ�رȽϣ�������ڶѶ��Ļ����ǲ��룬�ѶѶ���������ά�����ֻ��k��Ԫ�صĶ�
 */
public class LeetCode347 {
	public List<Integer> topKFrequent(int[] nums, int k) {
		//����TreeMap ͳ��ÿ��Ԫ�س��ֵĸ���
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < nums.length; i++) {
			int count = map.getOrDefault(nums[i], 0);
			map.put(nums[i], count + 1);
		}
		//�������ȶ��� Ҳ������С��  ���ǰ�Ԫ�س��ֵĴ�����Ϊ�����ԭ��
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			//�ڴ������ȶ��е�ʱ����һ������˵�������ԭ��
			@Override
			public int compare(Integer a, Integer b) {
				//ʹ�õľ���Ԫ�س��ֵĸ���
				return map.get(a) - map.get(b);
			}
		});
		//ά��k��Ԫ�ص����ȶ���
		for (int key : map.keySet()) {
			if (pq.size() < k)
				pq.add(key);
			else if (map.get(key) > map.get(pq.peek())) {
				pq.remove();
				pq.add(key);
			}
		}
		LinkedList<Integer> list = new LinkedList<>();
		while (!pq.isEmpty()) {
			list.add(pq.remove());
		}
		return list;
	}

	public static void main(String[] args) {
		LeetCode347 test = new LeetCode347();
		int nums[] = { 1, 1, 1, 1, 1, 2, 2, 3, 3, 3, 3 };
		System.out.println(test.topKFrequent(nums, 2));
	}
}
