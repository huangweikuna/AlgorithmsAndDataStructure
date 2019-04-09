package linked_list;

/*
 *  237. Delete Node in a Linked List 删除指定的结点
 *  Input: head = [4,5,1,9], node = 5
	Output: [4,1,9]
 */
public class LeetCode237 {
	//将前面的值给到node  之后node指向下一个的next 就相当于删除node的值
	public void deleteNode(ListNode node) {
		if (node.next != null) {
			node.val = node.next.val;
			node.next = node.next.next;
		} else
			node = null;
	}
}