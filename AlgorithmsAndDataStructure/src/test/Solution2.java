package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution2 {
	public class Node {
		public String c;
		public Node next;
		public Node(String c) {
			this.c = c;
		}
	}

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		ArrayList<String> list = new ArrayList<>();
//		int n = sc.nextInt();
//		Solution2 test = new Solution2();
//		String in = sc.nextLine();
//		for (int i = 0; i < n; i++) {
//		    in = sc.nextLine();
//			list.add(in);
//		}
//		for(int i = 0 ; i < list.size() ; i++) {
//			test.printRight(list.get(i));
//			if(i + 1 != list.size())
//                System.out.println();
//		}
//	}

	private void printRight(String str) {
		if (str.length() <= 2) {
			System.out.println(str);
			return;
		}
		Node head = new Node(str.charAt(0) + "");
		Node cur = head;
		for (int i = 1; i < str.length(); i++) {
			cur.next = new Node(str.charAt(i) + "");
			cur = cur.next;
		}
		Node pre = head;
		cur = pre.next;
		while(cur.next != null) {
			Node next = cur.next;
			//Ïû³ýAAA
			if(pre.c.equals(cur.c) && cur.c.equals(next.c)) {
				next = next.next;
				cur.next = next;
				continue;
			}
			
			if(next.next == null) {
				break;
			}
			//Ïû³ýAABB
			if(pre.c.equals(cur.c) && next.next != null && next.c.equals(next.next.c) ) {
				next = next.next;
				cur.next = next;
				continue;
			}
			pre = cur;
			cur = next;
		}
		while(head != null) {
			System.out.print(head.c);
			head = head.next;
		}
		
	}
	 public  class a{
			public void q() {
				System.out.println("q");
			}
		}
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> cls = Class.forName("test.Solution2");
		Solution2 s = (Solution2)cls.newInstance();
		s.printRight("wwwwwwwwwaaaaaaaaas");
		a c = new Solution2().new a();
	}
}