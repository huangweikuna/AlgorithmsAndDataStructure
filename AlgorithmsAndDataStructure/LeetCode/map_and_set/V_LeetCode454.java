package map_and_set;

import java.util.HashMap;
import java.util.Map;

/*
 * 454. 4Sum II
 */
//��4�������и�ѡ��һ����   ʹ����4����֮��Ϊ0   ���ع��м������������
//O(n2)
public class V_LeetCode454 {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int num = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < C.length; j++) {
				int count = map.getOrDefault(C[i] + D[j], 0);
				map.put(C[i] + D[j], count + 1);
			}
		}
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < C.length; j++) {
				if (map.containsKey(0 - A[i] - B[j])) {
					num += map.get(0 - A[i] - B[j]);
				}
			}
		}
		return num;
	}
}
