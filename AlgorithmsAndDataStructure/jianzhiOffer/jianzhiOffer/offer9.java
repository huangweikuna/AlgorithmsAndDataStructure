package jianzhiOffer;

import linked_list.ListNode;

/*
		����һ��������ת��������������ı�ͷ��
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