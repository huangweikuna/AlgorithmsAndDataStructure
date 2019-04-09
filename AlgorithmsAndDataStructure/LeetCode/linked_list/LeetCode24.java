package linked_list;

/*
 *  24. Swap Nodes in Pairs 2λ2λ�ķ�ת
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
			//��һ��ʱpΪdummy������  ���Խ�����ͷ���ָ���һ�ν������µ�ͷ���
			p.next = node2;
			//p֮��ı����ú�ı任�Ͳ���Ӱ������ͷ����next
			p = node1;
		}
		return dummy.next;
	}
}