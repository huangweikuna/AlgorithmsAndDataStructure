package linked_list;

/*
 *  24. Swap Nodes in Pairs 2位2位的翻转
 *  Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class LeetCode24 {
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = dummy;
		while (p.next != null && p.next.next != null) {
			ListNode node1 = p.next;
			ListNode node2 = node1.next;
			ListNode next = node2.next;
			
			node2.next = node1;
			node1.next = next;
			//第一次时p为dummy的引用  所以讲虚拟头结点指向第一次交换后新的头结点
			p.next = node2;
			//p之后改变引用后的变换就不会影响虚拟头结点的next
			p = node1;
		}
		return dummy.next;
	}
}