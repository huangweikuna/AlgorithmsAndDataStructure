package linked_list;

/*
 *  19. Remove Nth Node From End of List
 *  ɾ��������n�����
 */
public class LeetCode19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		//ʹ��˫ָ�����ҵ�q �� p ��� n  ֮��q�ƶ������һλʱ p ��λ�þ���Ҫɾ��Ԫ�ص�ǰһ��
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = dummy;
		ListNode q = dummy;
		for (int i = 0; i < n + 1; i++) {
			q = q.next;
		}
		while(q != null) {
			p = p.next;
			q = q.next;
		}
		p.next = p.next.next;
		return dummy.next;
	}
}