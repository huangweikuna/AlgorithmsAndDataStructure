package linked_list;

/*
 *  19. Remove Nth Node From End of List
 *  删除倒数第n个结点
 */
public class LeetCode19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		//使用双指针先找到q 与 p 相隔 n  之后将q移动到最后一位时 p 的位置就是要删除元素的前一个
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