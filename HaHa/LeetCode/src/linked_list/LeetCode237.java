package linked_list;

/*
 *  237. Delete Node in a Linked List ɾ��ָ���Ľ��
 *  Input: head = [4,5,1,9], node = 5
	Output: [4,1,9]
 */
public class LeetCode237 {
	//��ǰ���ֵ����node  ֮��nodeָ����һ����next ���൱��ɾ��node��ֵ
	public void deleteNode(ListNode node) {
		if (node.next != null) {
			node.val = node.next.val;
			node.next = node.next.next;
		} else
			node = null;
	}
}