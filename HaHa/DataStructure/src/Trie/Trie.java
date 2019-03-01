package Trie;

import java.util.HashMap;

public class Trie {
	private class Node {
		public boolean isWord;//判断是不是一个单词
		public HashMap<Character, Node> next;

		public Node() {
			isWord = false;
			next = new HashMap<>();
		}

		public Node(boolean isWord) {
			this.isWord = isWord;
			next = new HashMap<>();
		}
	}

	private Node root;
	private int size;

	public Trie() {
		root = new Node();
	}

	public int getSize() {
		return size;
	}

	public void add(String word) {
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
			size++;
		}
	}

	public boolean contains(String word) {
		Node cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(!cur.next.containsKey(c)) {
				return false;
			}
			cur = cur.next.get(c);
		}
		return cur.isWord;
	}
}