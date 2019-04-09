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
	public static void main(String[] args) {
//		String a = "计算机软件";
//		String str1 = new StringBuilder("计算机").append("软件").toString();
//		System.out.println(str1.intern() == str1);
//
//		String str2 = new StringBuilder("Linu").append("x").toString();
//		System.out.println(str2.intern() == str2);
//		
//		
//		String s1 = new String("abc");// 堆内存的地值值
//		String s2 = "abc"; 
//		System.out.println(s1 == s2);// 输出false,因为一个是堆内存，一个是常量池的内存，故两者是不同的。
//		System.out.println(s1.intern() == s2);// 输出true
		B b = new B();
	}
}
class A{
	static {
		System.out.println("A");
	}
}
class B{
	A a = new A();
	static {
		System.out.println("B");
	}
}




