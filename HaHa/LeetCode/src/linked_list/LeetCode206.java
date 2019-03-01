package linked_list;

/*
 * 206. Reverse Linked List ��ת����  //ʹ������Ͷ�ڵ�  
 *  Input: 1->2->3->4->5->NULL
	Output: 5->4->3->2->1->NULL
 */

public class LeetCode206 {
	public ListNode removeElements(ListNode head, int val) {
		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		ListNode cur = dummyNode;
		//�жϵ���cur����һ���ڵ��val�Ƿ���Ҫɾ����val �������Ա���סheadָ���λ��
		while(cur.next != null) {
			if(cur.next.val == val) {
				ListNode delNode = cur.next;
				cur.next = delNode.next;
				delNode = null;
			} else
				cur = cur.next;
		}
		return dummyNode.next;
	}
}