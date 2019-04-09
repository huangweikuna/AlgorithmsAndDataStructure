package Trie;

import java.util.HashMap;
/**
 *  	 ÿһ�����ʴ���һ��ֵ  Ҫ��������ʵ�ǰ׺   ���㺬�д�ǰ׺�ĵ���ֵ�ĺ�
 *   	 �õݹ�ķ�ʽ�ۼ��ܺ�  ����isWord�滻��val ����������
 */
public class LeetCode677 {
	private class Node {
		public int val;
		public HashMap<Character, Node> next;

		public Node() {
			this.val = 0;
			next = new HashMap<>();
		}
	}

	private Node root;

	/** Initialize your data structure here. */
	public LeetCode677() {
		root = new Node();
	}

	public void insert(String key, int val) {
		Node cur = root;
		for (int i = 0; i < key.length(); i++) {
			char c = key.charAt(i);
			if (!cur.next.containsKey(c)) {
				cur.next.put(c, new Node());
			}
			cur = cur.next.get(c);
		}
		cur.val = val;
	}

	public int sum(String prefix) {
		Node cur = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (!cur.next.containsKey(c)) {
				return 0;
			}
			cur = cur.next.get(c);
		}
		return sum(cur);
	}

	private int sum(Node node) {
		int res = node.val;
		for(char c : node.next.keySet()) {
			res += sum(node.next.get(c));
		}
		return res;
	}
}
