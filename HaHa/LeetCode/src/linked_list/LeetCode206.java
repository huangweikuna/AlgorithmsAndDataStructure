package linked_list;

/*
 * 206. Reverse Linked List 翻转链表  //使用虚拟投节点  
 *  Input: 1->2->3->4->5->NULL
	Output: 5->4->3->2->1->NULL
 */

public class LeetCode206 {
	public ListNode removeElements(ListNode head, int val) {
		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		ListNode cur = dummyNode;
		//判断的是cur的下一个节点的val是否是要删除的val 这样可以保持住head指针的位置
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