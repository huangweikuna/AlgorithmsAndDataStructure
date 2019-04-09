package jianzhiOffer;

import linked_list.ListNode;

/*
		输入一个链表，输出该链表中倒数第k个结点。
 * 
 */
public class offer8 {
	public ListNode FindKthToTail(ListNode head,int k) {
		if(head == null || k <= 0)
			return null;
		ListNode node = head;
		ListNode last = node;
		for(int i = 1; i < k; i++) {
			if(last.next != null)
				last = last.next;
			else
				return null;
		}
		while(last.next != null) {
			last = last.next;
			node = node.next;
		}
		return node;
    }
}