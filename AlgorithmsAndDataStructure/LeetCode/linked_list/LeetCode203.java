package linked_list;

/*
 * 206. Reverse Linked List ·­×ªÁ´±í
 *  Input: 1->2->3->4->5->NULL
	Output: 5->4->3->2->1->NULL
 */
public class LeetCode203 {
	public ListNode reverseList(ListNode head) {
		if (head == null)
			return null;
		ListNode cur = head;
		ListNode pre = null;

		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
}