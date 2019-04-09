package Trie;

import java.util.HashMap;

public class LeetCode211 {
	private class Node {
		public boolean isWord;
		public HashMap<Character, Node> next;

		public Node() {
			isWord = false;
			next = new HashMap<>();
		}
	}

	private Node root;

	/** Initialize your data structure here. */
	public LeetCode211() {
		root = new Node();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		Node cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!cur.next.containsKey(c)) {
				cur.next.put(c, new Node());
			}
			cur = cur.next.get(c);
		}
		if (!cur.isWord) {
			cur.isWord = true;
		}
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the dot
	 * character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		return search(root, word, 0);
	}

	private boolean search(Node node, String word, int index) {
		if(index == word.length())
			return node.isWord;
		char c = word.charAt(index);
		//如果不是.的话 正常搜索
		if (c != '.') {
			if (!node.next.containsKey(c)) {
				return false;
			}
			return search(node.next.get(c),word,index + 1);
		} else {
			//如果是点的话遍历接下来的孩子 进行匹配
			for (char nexChar : node.next.keySet()) {
				if(search(node.next.get(nexChar),word,index + 1))
					return true;
			}
			return false;
		}
	}
}
