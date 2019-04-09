package jianzhiOffer;

import linked_list.ListNode;

/*
		输入一个链表，反转链表后，输出新链表的表头。
 * 
 */
public class offer9 {
	public ListNode ReverseList(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		while(cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
}