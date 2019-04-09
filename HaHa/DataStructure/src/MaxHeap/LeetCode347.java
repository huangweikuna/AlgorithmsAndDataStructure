package MaxHeap;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
//Given a non-empty array of integers, return the k most frequent elements.
//返回出现评率最高的前k个数
/*
 *   在Java中 PriorityQueue就是以个最小堆，所以存在堆顶的是元素中的最小值
 *   我们可以把k个元素放在PriorityQueue中，把元素出现的次数当做排序的条件
 *   然后每次进来的元素都和堆顶元素比较，如果大于堆顶的话我们插入，把堆顶弹出，并维护这个只有k个元素的堆
 */
public class LeetCode347 {
	public List<Integer> topKFrequent(int[] nums, int k) {
		//创建TreeMap 统计每个元素出现的个数
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < nums.length; i++) {
			int count = map.getOrDefault(nums[i], 0);
			map.put(nums[i], count + 1);
		}
		//创建优先队列 也就是最小堆  我们把元素出现的次数做为排序的原则
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			//在创建优先队列的时候传入一个对象说明排序的原则
			@Override
			public int compare(Integer a, Integer b) {
				//使用的就是元素出现的个数
				return map.get(a) - map.get(b);
			}
		});
		//维护k个元素的优先队列
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
