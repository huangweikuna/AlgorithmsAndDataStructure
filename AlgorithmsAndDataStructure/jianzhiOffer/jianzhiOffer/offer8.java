package jianzhiOffer;

import linked_list.ListNode;

/*
		����һ����������������е�����k����㡣
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