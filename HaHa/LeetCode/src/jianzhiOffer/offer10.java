package jianzhiOffer;

import linked_list.ListNode;

/*
		���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
 * 
 */
public class offer10 {
	@SuppressWarnings("unused")
	public ListNode Merge(ListNode list1, ListNode list2) {
		ListNode p = list1;
		ListNode q = list2;
		ListNode result = new ListNode(0);
		ListNode head = result;
		while(true) {
			if(p == null) {
				while(q != null) {
					result.next = new ListNode(q.val);
					result = result.next;
					q = q.next;
				}
				break;
			}
			if(q == null) {
				while(p != null) {
					result.next = new ListNode(p.val);
					p = p.next;
					result = result.next;
				}	
				break;
			}
			if(p.val >= q.val) {
				result.next = new ListNode(q.val);
				result = result.next;
				q = q.next;
			}
			else {
				result.next = new ListNode(p.val);
				result = result.next;
				p = p.next;
			}
		}
		return head.next;
	}
}